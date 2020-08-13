package br.com.dbccompany.agibank.data.analysis.system.file;

import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;
import br.com.dbccompany.agibank.data.analysis.system.util.FormatStringHierarchyFile;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

@Configuration
public class SearchFile
{

    private static SearchFile instance;

    private SearchFile(){}

    public static SearchFile getInstance()
    {
        if(instance==null) instance = new SearchFile();
        return instance;
    }

    public void identifyFilePath(List<String> hierarchyFile,String fileExtension)
    {
      try
      {
          ProcessFileServiceAux
                  .getInstance()
                  .setPath(Files.walk(Paths.get(FormatStringHierarchyFile.FormatHierarchyFileSearchFile(hierarchyFile)))
                          .filter(P -> P
                                  .getFileName()
                                  .toString()
                                  .toLowerCase()
                                  .endsWith(fileExtension))
                          .findFirst()
                          .get());
      }
      catch (NoSuchElementException|IOException e)
      {
          ProcessFileServiceAux
                  .getInstance()
                  .setPath(null);
      }
    }



}
