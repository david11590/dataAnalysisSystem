package br.com.dbccompany.agibank.data.analysis.system.file;

public enum FileLineDelimiterEnum
{
    DELIMITER_LINE {  public String value() { return "ç"; } },
    DELIMITER_SALES {  public String value() { return "-"; } },
    DELIMITER_SALES_FIRST {  public String value() { return "["; } },
    DELIMITER_SALES_FIRST_END_RE {  public String value() { return "[\\[\\]]"; } },
    STRING_CLEAN {  public String value() { return ""; } },
    DELIMITER_SALE {  public String value() { return ","; } };

    public abstract String value();
}
