package br.com.dbccompany.agibank.data.analysis.system.directory;

import br.com.dbccompany.agibank.data.analysis.system.util.FormatStringHierarchyFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class CreateDirectories implements CommandLineRunner
{
    @Value("${hierarchy.reading.directory}")
    private List<String> hierarchyFile;
    @Value("${hierarchy.done.directory}")
    private List<String> hierarchyFileDone;

    @Override
    public void run(String... args) throws Exception
    {
        Files.createDirectories(Paths.get(FormatStringHierarchyFile.FormatHierarchyFileSearchFile(hierarchyFile)));
        Files.createDirectories(Paths.get(FormatStringHierarchyFile.FormatHierarchyFileWriteDirectory(hierarchyFileDone)));
    }
}
