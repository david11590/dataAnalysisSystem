package br.com.dbccompany.agibank.data.analysis.system.file;

import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ReadFile
{
    private static ReadFile instance;

    private ReadFile(){}

    public static ReadFile getInstance()
    {
        if(instance==null) instance = new ReadFile();
        return instance;
    }

    public void readFileLine(String reflectionPackage)
            throws IOException
    {
       Files.lines(ProcessFileServiceAux
               .getInstance()
               .getPath(),StandardCharsets.UTF_8)
               .forEach(L -> ProcessFileServiceAux
                       .getInstance()
                       .processLine(L,reflectionPackage));
    }
}
