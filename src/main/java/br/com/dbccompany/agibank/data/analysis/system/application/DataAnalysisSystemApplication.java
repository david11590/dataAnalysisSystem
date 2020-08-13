package br.com.dbccompany.agibank.data.analysis.system.application;

import br.com.dbccompany.agibank.data.analysis.system.directory.CreateDirectories;
import br.com.dbccompany.agibank.data.analysis.system.schedule.Init;
import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackageClasses = {Init.class,
		                             ProcessFileService.class,
		                             CreateDirectories.class})
public class DataAnalysisSystemApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DataAnalysisSystemApplication.class, args);
	}
}
