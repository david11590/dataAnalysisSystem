package br.com.dbccompany.agibank.data.analysis.system.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import br.com.dbccompany.agibank.data.analysis.system.dto.OutputFile;
import br.com.dbccompany.agibank.data.analysis.system.file.*;
import br.com.dbccompany.agibank.data.analysis.system.reflection.ReflectionBase;
import br.com.dbccompany.agibank.data.analysis.system.util.StringFormatEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static br.com.dbccompany.agibank.data.analysis.system.reflection.ReflectionClassEnum.getClassReflectionMap;
import static java.lang.Class.forName;
import static java.lang.String.format;

public class ProcessFileServiceAux
{
    private static final Logger log = LoggerFactory.getLogger(ProcessFileServiceAux.class);
    private Path path;
    private static ProcessFileServiceAux instance;
    private ReflectionBase reflectionBase;
    private OutputFile OutputFile = new OutputFile();

    private ProcessFileServiceAux(){};

    public static ProcessFileServiceAux getInstance()
    {
        if(instance==null) instance = new ProcessFileServiceAux();
        return instance;
    }
    public void processAux(String reflectionPackage, List<String> hierarchyFileDone,String fileExtensionDone,String fileExtensionReading)
            throws IOException
    {
        ReadFile.getInstance().readFileLine(reflectionPackage);
        WriteFile.getInstance().WhiteFile(hierarchyFileDone,fileExtensionDone,fileExtensionReading);
        RenameFile.getInstance().renameFileInput(fileExtensionReading);
        log.info(StringFormatEnum.STRING_LOG.value(),ProcessFileServiceAux.getInstance().getPath().getFileName() );
    }

    public void processLine(String line,String reflectionPackage) {
        try {
            reflectionBase = (ReflectionBase)  forName(format(StringFormatEnum
                    .STRING_PACKAGE_REFLECTION
                    .value(), reflectionPackage,
                    getClassReflectionMap()
                    .get(line
                            .split(FileLineDelimiterEnum
                                    .DELIMITER_LINE
                                    .value())[FilePositionEnum
                            .POSITION_ID_LINE
                            .value()])))
                    .newInstance();
        }
        catch (ClassNotFoundException|IllegalAccessException|InstantiationException e)
        {
            e.printStackTrace();
        }
        reflectionBase.execution(line);
    }

    public Path getPath()
    {
        return path;
    }

    public void setPath(Path path)
    {
        this.path = path;
    }

    public OutputFile getOutputFile()
    {
        return OutputFile;
    }

    public void setOutputFile(OutputFile outputFile)
    {
        this.OutputFile = outputFile;
    }

}
