package br.com.dbccompany.agibank.data.analysis.system.reflection;

import br.com.dbccompany.agibank.data.analysis.system.file.FilePositionEnum;

public class SalesProcessAux
{
    private int idx;
    private double valueAllSales;
    private String nameSalesman;
    private String idSale;
    private static SalesProcessAux instance;

    private SalesProcessAux(){}

    public static SalesProcessAux getInstance()
    {
        if(instance==null) instance = new SalesProcessAux();
        return instance;
    }

    public int getIdx()
    {
        return idx;
    }

    public void setIdxIncrementOne()
    {
        this.idx++;
    }

    public double getValueAllSales()
    {
        return valueAllSales;
    }

    public void setValueAllSalesIncrement(double valueAllSales)
    {
        this.valueAllSales+=valueAllSales;
    }

    public void setValueAllSales(double valueAllSales)
    {
        this.valueAllSales = valueAllSales;
    }

    public String getNameSalesman()
    {
        return nameSalesman;
    }

    public void setNameSalesman(String nameSalesman)
    {
        this.nameSalesman = nameSalesman;
    }

    public String getIdSale()
    {
        return idSale;
    }

    public void setIdSale(String idSale)
    {
        this.idSale = idSale;
    }

    public void setIdxInitial()
    {
       this.idx=FilePositionEnum.VALUE_IDX_INITIAL.value();
    }
}
