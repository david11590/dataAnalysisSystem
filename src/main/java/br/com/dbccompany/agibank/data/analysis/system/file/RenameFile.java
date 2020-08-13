package br.com.dbccompany.agibank.data.analysis.system.file;

import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class RenameFile
{
    private static RenameFile instance;

    private RenameFile(){}

    public static RenameFile getInstance()
    {
        if(instance==null) instance = new RenameFile();
        return instance;
    }

    public void renameFileInput(String fileExtensionReading) throws IOException
    {
        Path source =ProcessFileServiceAux.getInstance().getPath();
        Files.move(source, source.resolveSibling(source.getFileName().toString().replaceAll(fileExtensionReading,FileLineDelimiterEnum.STRING_CLEAN.value())), StandardCopyOption.ATOMIC_MOVE);
    }
}
