package br.com.dbccompany.model.enums;

import br.com.dbccompany.model.converter.ClientConverter;
import br.com.dbccompany.model.converter.ContentConverterStrategy;
import br.com.dbccompany.model.converter.SaleConverter;
import br.com.dbccompany.model.converter.SalesmanConverter;

import java.util.Arrays;

public enum DatFileLineTypeEnum {

    SALESMAN("001", new SalesmanConverter()),
    CLIENT("002", new ClientConverter()),
    SALE("003", new SaleConverter());

    private String lineTypeId;
    private ContentConverterStrategy contentConverterStrategy;

    DatFileLineTypeEnum(String lineTypeId, ContentConverterStrategy contentConverterStrategy){
        this.lineTypeId = lineTypeId;
        this.contentConverterStrategy = contentConverterStrategy;
    }

    public static DatFileLineTypeEnum getLineTypeFromString(String lineTypeString){
        return Arrays.stream(values())
                .filter(value -> value.lineTypeId.equals(lineTypeString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Não foi possível encontrar tipo para o tipo: %s", lineTypeString)
                ));
    }

    public String getLineTypeId() {
        return lineTypeId;
    }

    public ContentConverterStrategy getContentConverterStrategy() {
        return contentConverterStrategy;
    }
}
