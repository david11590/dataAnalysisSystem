package br.com.dbccompany.agibank.data.analysis.system.reflection;

import br.com.dbccompany.agibank.data.analysis.system.dto.ExpensiveSale;
import br.com.dbccompany.agibank.data.analysis.system.file.FileLineDelimiterEnum;
import br.com.dbccompany.agibank.data.analysis.system.file.FilePositionEnum;
import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalesProcess implements ReflectionBase {


    @Override
    public void execution(String line)
    {
        SalesProcessAux.getInstance().setIdxInitial();
        SalesProcessAux.getInstance().setValueAllSales(FilePositionEnum.VALUE_INITIAL_SALES.value());
        SalesProcessAux.getInstance().setNameSalesman(Stream.of(line.split(FileLineDelimiterEnum.DELIMITER_LINE.value())).collect(Collectors.toList()).get(FilePositionEnum.POSITION_SALESMAN_NAME_IN_SALES.value()));
        SalesProcessAux.getInstance().setIdSale(Stream.of(line.split(FileLineDelimiterEnum.DELIMITER_LINE.value())).collect(Collectors.toList()).get(FilePositionEnum.POSITION_ID_SALES.value()));

        Stream
          .of(line.split(FileLineDelimiterEnum.DELIMITER_LINE.value()))
          .collect(Collectors.toList())
          .forEach(E ->
        {
            if(E.contains(FileLineDelimiterEnum.DELIMITER_SALES_FIRST.value()))
               Stream.of(E.split(FileLineDelimiterEnum.DELIMITER_SALE.value()))
                        .collect(Collectors.toList())
                        .forEach(I -> Stream.of(I.split(FileLineDelimiterEnum.DELIMITER_SALES.value()))
                                .forEach(L -> valueAllSalesCount(Double.parseDouble(L.replaceAll(FileLineDelimiterEnum.DELIMITER_SALES_FIRST_END_RE.value(), FileLineDelimiterEnum.STRING_CLEAN.value())))));
        });

        ProcessFileServiceAux
                .getInstance()
                .getOutputFile()
                .getSalesManList()
                .stream()
                .filter(I -> I.getName().equals(SalesProcessAux.getInstance().getNameSalesman()))
                .findAny()
                .get()
                .setSale(SalesProcessAux.getInstance().getValueAllSales());

       if(ProcessFileServiceAux
                .getInstance()
                .getOutputFile()
                .getExpensiveSale()
                .getValue() < SalesProcessAux.getInstance().getValueAllSales())
       {
           ProcessFileServiceAux
                   .getInstance()
                   .getOutputFile()
                   .setExpensiveSale(new ExpensiveSale(SalesProcessAux.getInstance().getIdSale(),SalesProcessAux.getInstance().getValueAllSales()));
       }
    }

    private void valueAllSalesCount(Double value)
    {
        SalesProcessAux.getInstance().setIdxIncrementOne();
        if(SalesProcessAux.getInstance().getIdx()==FilePositionEnum.POSITION_VALUE_SALE.value())
        {
            SalesProcessAux.getInstance().setValueAllSalesIncrement(value);
            SalesProcessAux.getInstance().setIdxInitial();
        }
    }

}
