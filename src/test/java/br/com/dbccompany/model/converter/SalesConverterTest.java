package br.com.dbccompany.model.converter;

import br.com.dbccompany.faker.SaleFaker;
import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.SaleItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SalesConverterTest {

    private final SaleConverter saleConverter = new SaleConverter();
    private final SaleItemConverter saleItemConverter = new SaleItemConverter();

    @Test
    void shouldConvertContentToSalesmanObjectWithSuccess() {
        String saleContentFake = SaleFaker.getValidSaleContentFake();

        Sale sale = Assertions.assertDoesNotThrow(() -> this.saleConverter.convertContentToModel(saleContentFake));

        Assertions.assertNotNull(sale);

        String[] salesmanSplitContent = saleContentFake.split("ç");
        List<SaleItem> validationItems = this.saleItemConverter.convertContentToSaleItemList(salesmanSplitContent[2]);

        Assertions.assertEquals(salesmanSplitContent[1], sale.getSaleId());
        Assertions.assertEquals(validationItems, sale.getItems());
        Assertions.assertEquals(salesmanSplitContent[3], sale.getSalesmanName());
    }

    @Test
    void shouldThrowsErrorWhenTryToConvertInvalidContent() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> saleConverter.convertContentToModel(SaleFaker.getInvalidIdSaleContentFake())
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> saleConverter.convertContentToModel(SaleFaker.getInvalidSeparatorSaleContentFake())
        );
    }

}
