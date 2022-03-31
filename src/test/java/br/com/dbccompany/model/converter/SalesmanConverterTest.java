package br.com.dbccompany.model.converter;

import br.com.dbccompany.faker.SalesmanFaker;
import br.com.dbccompany.model.Salesman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SalesmanConverterTest {

    private final SalesmanConverter salesmanConverter = new SalesmanConverter();

    @Test
    void shouldConvertContentToSalesmanObjectWithSuccess() {
        String salesmanContentFake = SalesmanFaker.getValidSalesmanContentFake();

        Salesman salesman = Assertions.assertDoesNotThrow(() -> salesmanConverter.convertContentToModel(salesmanContentFake));

        Assertions.assertNotNull(salesman);

        String[] salesmanSplitContent = salesmanContentFake.split("ç");
        Assertions.assertEquals(salesmanSplitContent[1], salesman.getCpf());
        Assertions.assertEquals(salesmanSplitContent[2], salesman.getName());
        Assertions.assertEquals(new BigDecimal(salesmanSplitContent[3]), salesman.getSalary());
    }

    @Test
    void shouldThrowsErrorWhenTryToConvertInvalidContent() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> salesmanConverter.convertContentToModel(SalesmanFaker.getInvalidIdSalesmanContentFake())
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> salesmanConverter.convertContentToModel(SalesmanFaker.getInvalidSeparatorSalesmanContentFake())
        );
    }
}
