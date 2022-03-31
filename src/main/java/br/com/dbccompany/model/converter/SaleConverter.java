package br.com.dbccompany.model.converter;

import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.SaleItem;
import br.com.dbccompany.model.enums.DatFileLineTypeEnum;

import java.util.List;

public class SaleConverter extends ContentConverterStrategy {

    private final SaleItemConverter saleItemConverter;

    public SaleConverter() {
        super();
        this.saleItemConverter = new SaleItemConverter();
    }

    @Override
    DatFileLineTypeEnum getLineType() {
        return DatFileLineTypeEnum.SALE;
    }

    @Override
    public Sale convertContentToModel(String content) throws IllegalArgumentException {
        this.validateContent(content);

        String[] contentSplit = content.split(super.separator);
        List<SaleItem> items = saleItemConverter.convertContentToSaleItemList(contentSplit[2]);
        return new Sale(
                contentSplit[1],
                items,
                contentSplit[3]
        );
    }

}
