package br.com.dbccompany.agibank.data.analysis.system.schedule;

import java.io.IOException;
import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Init
{
    @Autowired
    ProcessFileService ProcessFileService;

    @Scheduled(cron = "${cron.expression.second}")
    public void execScheduleBatch()
            throws IOException
    {
        ProcessFileService.execution();
    }
}
