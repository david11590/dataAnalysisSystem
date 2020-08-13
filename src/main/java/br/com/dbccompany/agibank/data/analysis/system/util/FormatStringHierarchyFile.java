package br.com.dbccompany.agibank.data.analysis.system.util;

import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;

import java.io.File;
import java.util.List;

public class FormatStringHierarchyFile
{
    public static String FormatHierarchyFileSearchFile(List<String> hierarchyFile)
    {
        int count=0;
        return String
                .format(StringFormatEnum.STRING_FORMAT_HIERARCHY_FILE.value(),
                        System.getenv(hierarchyFile.get(count++)),
                        File.separator,
                        hierarchyFile.get(count++),
                        File.separator,
                        hierarchyFile.get(count++));
    }

    public static String FormatHierarchyFileWrite(List<String> hierarchyFile,String fileExtensionDone,String fileExtensionReading)
    {
        int count=0;
        return String
                .format(StringFormatEnum.STRING_FORMAT_HIERARCHY_FILE_WRITE.value(),
                        System.getenv(hierarchyFile.get(count++)),
                        File.separator,
                        hierarchyFile.get(count++),
                        File.separator,
                        hierarchyFile.get(count++),
                        File.separator,
                        ProcessFileServiceAux
                                .getInstance()
                                .getPath()
                                .getFileName()
                                .toString()
                                .replaceAll(fileExtensionReading,fileExtensionDone));
    }

    public static String FormatHierarchyFileWriteDirectory(List<String> hierarchyFile)
    {
        int count=0;
        return String
                .format(StringFormatEnum.STRING_FORMAT_HIERARCHY_FILE_WRITE_DIRECTORY.value(),
                        System.getenv(hierarchyFile.get(count++)),
                        File.separator,
                        hierarchyFile.get(count++),
                        File.separator,
                        hierarchyFile.get(count++));
    }
}
