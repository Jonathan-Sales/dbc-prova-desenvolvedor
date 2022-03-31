package br.com.dbccompany.model.converter;

import br.com.dbccompany.model.Salesman;
import br.com.dbccompany.model.enums.DatFileLineTypeEnum;

import java.math.BigDecimal;

public class SalesmanConverter extends ContentConverterStrategy {

    @Override
    DatFileLineTypeEnum getLineType() {
        return DatFileLineTypeEnum.SALESMAN;
    }

    @Override
    public Salesman convertContentToModel(String content) throws IllegalArgumentException {
        this.validateContent(content);

        String[] contentSplit = content.split(super.separator);

        return new Salesman(
                contentSplit[1],
                contentSplit[2],
                new BigDecimal(contentSplit[3])
        );
    }

}
