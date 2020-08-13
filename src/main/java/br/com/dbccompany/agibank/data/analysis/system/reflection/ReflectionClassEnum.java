package br.com.dbccompany.agibank.data.analysis.system.reflection;

import java.util.HashMap;
import java.util.Map;

public enum ReflectionClassEnum
{
    SalesmanProcess, ClientProcess, SalesProcess;

    static Map<String,String> ClassReflectionMap = new HashMap<String,String>();

    static
    {
        ClassReflectionMap.put("001", ReflectionClassEnum.SalesmanProcess.toString());
        ClassReflectionMap.put("002", ReflectionClassEnum.ClientProcess.toString());
        ClassReflectionMap.put("003", ReflectionClassEnum.SalesProcess.toString());
    }

    public static Map<String,String> getClassReflectionMap()
    {
        return ClassReflectionMap;
    }
}
