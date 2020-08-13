package br.com.dbccompany.agibank.data.analysis.system.service;

import br.com.dbccompany.agibank.data.analysis.system.dto.OutputFile;
import br.com.dbccompany.agibank.data.analysis.system.file.SearchFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class ProcessFileService
{
    @Value("${hierarchy.reading.directory}")
    private List<String> hierarchyFile;
    @Value("${hierarchy.done.directory}")
    private List<String> hierarchyFileDone;
    @Value("${file.reading.extension}")
    private String fileExtensionReading;
    @Value("${file.done.extension}")
    private String fileExtensionDone;
    @Value("${reflection.package}")
    private String reflectionPackage;

    public void execution()
            throws IOException
    {
        ProcessFileServiceAux
                .getInstance()
                .setOutputFile(new OutputFile());

        SearchFile
        .getInstance()
        .identifyFilePath(hierarchyFile,fileExtensionReading);

        if(ProcessFileServiceAux
                .getInstance()
                .getPath() != null)
        {
            ProcessFileServiceAux
                    .getInstance()
                    .processAux(reflectionPackage,hierarchyFileDone,fileExtensionDone, fileExtensionReading);
        }
    }
}
