package br.com.dbccompany.agibank.data.analysis.system.reflection;

import br.com.dbccompany.agibank.data.analysis.system.dto.SalesMan;
import br.com.dbccompany.agibank.data.analysis.system.file.FileLineDelimiterEnum;
import br.com.dbccompany.agibank.data.analysis.system.file.FilePositionEnum;
import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalesmanProcess implements ReflectionBase {

    @Override
    public void execution(String line)
    {
        ProcessFileServiceAux
                .getInstance()
                .getOutputFile()
                .getSalesManList()
                .add(new SalesMan(Stream.of(line.split(FileLineDelimiterEnum.DELIMITER_LINE.value()))
                .collect(Collectors.toList())
                .get(FilePositionEnum.POSITION_SALESMAN_NAME.value()),
                        FilePositionEnum.VALUE_INITIAL_SALESMAN.value()));
    }
}

