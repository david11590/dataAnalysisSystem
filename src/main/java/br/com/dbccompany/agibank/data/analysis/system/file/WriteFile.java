package br.com.dbccompany.agibank.data.analysis.system.file;

import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;
import br.com.dbccompany.agibank.data.analysis.system.util.FormatStringHierarchyFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class WriteFile
{
    private static WriteFile instance;
    private Path pathOutput;

    private WriteFile(){}

    public static WriteFile getInstance()
    {
        if(instance==null) instance = new WriteFile();
        return instance;
    }

    public void WhiteFile(List<String> hierarchyFile, String fileExtensionDone,String fileExtensionReading)
            throws IOException
    {
        pathOutput = Paths.get(FormatStringHierarchyFile.FormatHierarchyFileWrite(hierarchyFile,fileExtensionDone,fileExtensionReading));
        Files.createFile(pathOutput);
        Files.write(pathOutput, ProcessFileServiceAux
                                    .getInstance()
                                    .getOutputFile().toStringArray()
                                    ,StandardCharsets.UTF_8);
    }


}
