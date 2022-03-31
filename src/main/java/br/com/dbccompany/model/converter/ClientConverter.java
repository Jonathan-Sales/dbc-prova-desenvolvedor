package br.com.dbccompany.model.converter;

import br.com.dbccompany.model.Client;
import br.com.dbccompany.model.enums.DatFileLineTypeEnum;

public class ClientConverter extends ContentConverterStrategy {

    @Override
    protected DatFileLineTypeEnum getLineType() {
        return DatFileLineTypeEnum.CLIENT;
    }

    @Override
    public Client convertContentToModel(String content) throws IllegalArgumentException {
        super.validateContent(content);

        String[] contentSplit = content.split(super.separator);

        return new Client(
                contentSplit[1],
                contentSplit[2],
                contentSplit[3]
        );
    }


}
