package br.com.dbccompany.agibank.data.analysis.system.util;

public enum StringFormatEnum
{
    STRING_LOG {  public String value() { return "{} file processed."; } },
    STRING_PACKAGE_REFLECTION {  public String value() { return "%s.%s"; } },
    STRING_FORMAT_HIERARCHY_FILE_WRITE { public String value() { return "%s%s%s%s%s%s%s"; }},
    STRING_FORMAT_HIERARCHY_FILE_WRITE_DIRECTORY { public String value() { return "%s%s%s%s%s"; }},
    STRING_FORMAT_HIERARCHY_FILE { public String value() { return "%s%s%s%s%s"; }};
    //STRING_OUTPUT_FILE_TO_STRING_BYTE { public String value() { return "%s\r\n%s\r\n%s\r\n%s"; }};
    public abstract String value();
}
