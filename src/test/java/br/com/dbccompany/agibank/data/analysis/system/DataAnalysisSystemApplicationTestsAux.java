package br.com.dbccompany.agibank.data.analysis.system;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class DataAnalysisSystemApplicationTestsAux
{
    private Path pathInput;
    private Path pathOutput;
    private Path pathOutputTest;
    private Path pathInputTest;
    private int count;
    private static DataAnalysisSystemApplicationTestsAux instance;

    private DataAnalysisSystemApplicationTestsAux(){}

    public static DataAnalysisSystemApplicationTestsAux getInstance()
    {
        if(instance==null) instance= new DataAnalysisSystemApplicationTestsAux();
        return instance;
    }
    public String StringFormatInputPathDirectory(List<String> hierarchyFile)
    {
        count=0;
        return String.format("%s%s%s%s%s",
                System.getenv(hierarchyFile.get(count++)),
                File.separator,
                hierarchyFile.get(count++),
                File.separator,
                hierarchyFile.get(count++));
    }

    public String StringFormatInputPath(List<String> hierarchyFile)
    {
        count=0;
        return String.format("%s%s%s%s%s%s%s",
                             System.getenv(hierarchyFile.get(count++)),
                             File.separator,
                             hierarchyFile.get(count++),
                             File.separator,
                             hierarchyFile.get(count++),
                             File.separator,
                             "arquivoTest.dat");
    }

    public List<String> ListStringFileInputTest()
    {
        return  Arrays.asList("001ç1234567891234çPedroç50000",
                              "001ç3245678865434çPauloç40000.99",
                              "002ç2345675434544345çJose da SilvaçRural",
                              "002ç2345675433444345çEduardo PereiraçRural",
                              "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro",
                              "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
    }
    public String StringFormatOutputPathDirectory(List<String> hierarchyFileDone)
    {
        count=0;
        return String.format("%s%s%s%s%s",
                System.getenv(hierarchyFileDone.get(count++)),
                File.separator,
                hierarchyFileDone.get(count++),
                File.separator,
                hierarchyFileDone.get(count++));
    }
    public String StringFormatOutputPath(List<String> hierarchyFileDone)
    {
        count=0;
        return String.format("%s%s%s%s%s%s%s",
                             System.getenv(hierarchyFileDone.get(count++)),
                             File.separator,
                             hierarchyFileDone.get(count++),
                             File.separator,
                             hierarchyFileDone.get(count++),
                             File.separator,
                             "arquivoTest.done.dat");
    }

    public String StringFormatInputPathTest()
    {
        return "src/test/resources/arquivoTest.dat";
    }

    public String StringFormatOutputPathTest()
    {
        return "src/test/resources/arquivoTest.done.dat";
    }
    public String StringFormatInputPathProcess(List<String> hierarchyFile)
    {
        count=0;
        return String.format("%s%s%s%s%s%s%s",
                System.getenv(hierarchyFile.get(count++)),
                File.separator,
                hierarchyFile.get(count++),
                File.separator,
                hierarchyFile.get(count++),
                File.separator,
                "arquivoTest");
    }
}
