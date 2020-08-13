package br.com.dbccompany.agibank.data.analysis.system.dto;

import java.util.*;
import static java.lang.String.valueOf;

public class OutputFile
{

    private List<String> clientList;
    private List<SalesMan> salesManList;
    private ExpensiveSale expensiveSale;

    public List<String> getClientList()
    {
        if(clientList==null) setClientList(new ArrayList<String>());
        return clientList;
    }

    public void setClientList(List<String> clientList)
    {
        this.clientList = clientList;
    }

    public List<SalesMan> getSalesManList()
    {
        if(salesManList==null) setSalesManList(new ArrayList<SalesMan>());
        return salesManList;
    }

    public void setSalesManList(List<SalesMan> salesManList)
    {
        this.salesManList = salesManList;
    }

    public ExpensiveSale getExpensiveSale()
    {
        if(expensiveSale==null) setExpensiveSale(new ExpensiveSale());
        return expensiveSale;
    }

    public void setExpensiveSale(ExpensiveSale expensiveSale)
    {
        this.expensiveSale = expensiveSale;
    }

    public List<String> toStringArray()
    {

        return Arrays.asList(
                             valueOf(getClientList().size()),
                             valueOf(getSalesManList().size()),
                             valueOf(getExpensiveSale().getSale()),
                             getSalesManList()
                                     .stream()
                                     .sorted(Comparator.comparing(O -> O.getSale()))
                                     .findFirst()
                                     .get()
                                     .getName().toString());
    }
}
