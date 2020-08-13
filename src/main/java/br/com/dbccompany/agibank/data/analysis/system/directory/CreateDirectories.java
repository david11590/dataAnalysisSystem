package br.com.dbccompany.agibank.data.analysis.system.directory;

import br.com.dbccompany.agibank.data.analysis.system.util.FormatStringHierarchyFile;
import br.com.dbccompany.agibank.data.analysis.system.util.StringFormatEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class CreateDirectories implements CommandLineRunner
{
    private static final Logger log = LoggerFactory.getLogger(CreateDirectories.class);
    @Value("${hierarchy.reading.directory}")
    private List<String> hierarchyFile;
    @Value("${hierarchy.done.directory}")
    private List<String> hierarchyFileDone;

    @Override
    public void run(String... args) throws Exception
    {
        log.info(StringFormatEnum
                .STRING_LOG_INPUT
                .value(),
                FormatStringHierarchyFile
                        .FormatHierarchyFileSearchFile(hierarchyFile));
        log.info(StringFormatEnum
                .STRING_LOG_OUTPUT
                .value(),
                FormatStringHierarchyFile
                        .FormatHierarchyFileWriteDirectory(hierarchyFileDone));

        Files
                .createDirectories(Paths
                        .get(FormatStringHierarchyFile
                                .FormatHierarchyFileSearchFile(hierarchyFile)));
        Files
                .createDirectories(Paths
                        .get(FormatStringHierarchyFile
                                .FormatHierarchyFileWriteDirectory(hierarchyFileDone)));
    }
}
