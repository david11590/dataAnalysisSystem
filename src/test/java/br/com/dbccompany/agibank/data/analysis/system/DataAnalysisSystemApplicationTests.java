package br.com.dbccompany.agibank.data.analysis.system;

import br.com.dbccompany.agibank.data.analysis.system.application.DataAnalysisSystemApplication;
import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = DataAnalysisSystemApplication.class)

class DataAnalysisSystemApplicationTests
{
	@Autowired
	ProcessFileService ProcessFileService;
	@Value("${hierarchy.reading.directory}")
	private List<String> hierarchyFile;
	@Value("${hierarchy.done.directory}")
	private List<String> hierarchyFileDone;
	private Path pathInput;
	private Path pathOutput;
	private Path pathOutputTest;
	private Path pathInputTest;

	@Test
	void createFileTest() throws Exception
	{
		Files.createDirectories(Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatInputPathDirectory(hierarchyFile)));
		Files.createDirectories(Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatOutputPathDirectory(hierarchyFileDone)));
		pathInput = Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatInputPath(hierarchyFile));
		Files.deleteIfExists(pathInput);
		Files.createFile(pathInput);
        Files.write(pathInput,DataAnalysisSystemApplicationTestsAux.getInstance().ListStringFileInputTest(), StandardCharsets.UTF_8);
		pathInputTest = Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatInputPathTest());
		String inputEx=Files.lines(pathInputTest, StandardCharsets.UTF_8).collect(Collectors.toList()).toString();
		String inputFile=Files.lines(pathInput, StandardCharsets.UTF_8).collect(Collectors.toList()).toString();
		if(!inputEx.equals(inputFile)) throw new Exception();
	}

	@Test
	void serviceTestExecution()
			throws IOException
	{
		Files.deleteIfExists(Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatInputPathProcess(hierarchyFile)));
		Files.deleteIfExists(Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatOutputPath(hierarchyFileDone)));
		ProcessFileService.execution();
	}

	@Test
	void outputFileTest ()
			throws Exception
	{
		Thread.sleep(1000);
		pathOutput = Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatOutputPath(hierarchyFileDone));
		pathOutputTest = Paths.get(DataAnalysisSystemApplicationTestsAux.getInstance().StringFormatOutputPathTest());
		String outpuEx = Files.lines(pathOutputTest, StandardCharsets.UTF_8).collect(Collectors.toList()).toString();
		String outputFile = Files.lines(pathOutput, StandardCharsets.UTF_8).collect(Collectors.toList()).toString();
		if (!outpuEx.equals(outputFile)) throw new Exception();

	}

}
