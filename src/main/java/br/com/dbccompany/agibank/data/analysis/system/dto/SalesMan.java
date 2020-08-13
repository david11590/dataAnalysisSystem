package br.com.dbccompany.agibank.data.analysis.system.dto;

public class SalesMan
{
    private String name;
    private double sale;

    public SalesMan(String name, double sale)
    {
        this.name = name;
        this.sale = sale;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSale()
    {
        return sale;
    }

    public void setSale(double sale)
    {
        this.sale += sale;
    }
}
