package br.com.dbccompany.agibank.data.analysis.system.dto;

public class ExpensiveSale
{
    private String Sale;
    private double value;

    public ExpensiveSale() {}

    public ExpensiveSale(String sale, double value)
    {
        Sale = sale;
        this.value = value;
    }

    public String getSale()
    {
        return Sale;
    }

    public void setSale(String sale)
    {
        Sale = sale;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }
}
