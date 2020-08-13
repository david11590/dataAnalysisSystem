package br.com.dbccompany.agibank.data.analysis.system.util;

public enum StringFormatEnum
{
    STRING_LOG {  public String value() { return "{} file processed."; } },
    STRING_LOG_INPUT {  public String value() { return "Directory input {} "; } },
    STRING_LOG_OUTPUT {  public String value() { return "Directory output {} "; } },
    STRING_PACKAGE_REFLECTION {  public String value() { return "%s.%s"; } },
    STRING_FORMAT_HIERARCHY_FILE_WRITE { public String value() { return "%s%s%s%s%s%s%s"; }},
    STRING_FORMAT_HIERARCHY_FILE_WRITE_DIRECTORY { public String value() { return "%s%s%s%s%s"; }},
    STRING_FORMAT_HIERARCHY_FILE { public String value() { return "%s%s%s%s%s"; }};
    public abstract String value();
}
