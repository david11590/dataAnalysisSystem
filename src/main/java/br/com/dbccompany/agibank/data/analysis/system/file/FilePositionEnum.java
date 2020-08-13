package br.com.dbccompany.agibank.data.analysis.system.file;

public enum FilePositionEnum
{
    POSITION_ID_LINE {  public int value() { return 0; } },
    POSITION_CLIENT_CNPJ {  public int value() { return 1; } },
    POSITION_SALESMAN_NAME {  public int value() { return 2; } },
    POSITION_SALESMAN_NAME_IN_SALES {  public int value() { return 3; } },
    POSITION_ID_SALES {  public int value() { return 1; } },
    POSITION_VALUE_SALE {  public int value() { return 3; } },
    VALUE_INITIAL_SALESMAN {  public int value() { return 0; } },
    VALUE_IDX_INITIAL {  public int value() { return 0; } },
    VALUE_INITIAL_SALES {  public int value() { return 0; } };
    public abstract int value();
}
