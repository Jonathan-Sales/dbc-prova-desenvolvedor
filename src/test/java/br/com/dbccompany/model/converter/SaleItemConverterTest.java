package br.com.dbccompany.model.converter;

import br.com.dbccompany.faker.SaleItemFaker;
import br.com.dbccompany.model.SaleItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SaleItemConverterTest {

    private final SaleItemConverter saleItemConverter = new SaleItemConverter();

    @Test
    void shouldConvertContentToSaleItemWithSuccess() {
        String saleItemContent = SaleItemFaker.getValidSalesItemContentFake();

        List<SaleItem> saleItems = Assertions.assertDoesNotThrow(() -> this.saleItemConverter.convertContentToSaleItemList(saleItemContent));

        List<SaleItem> saleItemsValidationList = SaleItemFaker.getListValidSaleItemsFromContentFake();
        Assertions.assertEquals(saleItemsValidationList.size(), saleItems.size());
        Assertions.assertEquals(saleItemsValidationList, saleItems);
    }

    @Test
    void shouldThrowsErrorWhenTryToConvertInvalidContent() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> this.saleItemConverter.convertContentToSaleItemList(SaleItemFaker.getInvalidSalesItemContentFake())
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> this.saleItemConverter.convertContentToSaleItemList(SaleItemFaker.getInvalidSeparatorSalesItemsContentFake())
        );
    }
}
