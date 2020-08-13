package br.com.dbccompany.agibank.data.analysis.system.reflection;

import br.com.dbccompany.agibank.data.analysis.system.file.FileLineDelimiterEnum;
import br.com.dbccompany.agibank.data.analysis.system.file.FilePositionEnum;
import br.com.dbccompany.agibank.data.analysis.system.service.ProcessFileServiceAux;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientProcess implements ReflectionBase
{
    @Override
    public void execution(String line)
    {
        ProcessFileServiceAux
                .getInstance()
                .getOutputFile()
                .getClientList()
                .add(Stream.of(line.split(FileLineDelimiterEnum.DELIMITER_LINE.value()))
                .collect(Collectors.toList()).get(FilePositionEnum.POSITION_CLIENT_CNPJ.value()));
    }
}
