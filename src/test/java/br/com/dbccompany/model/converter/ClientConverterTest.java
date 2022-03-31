package br.com.dbccompany.model.converter;

import br.com.dbccompany.faker.ClientFaker;
import br.com.dbccompany.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientConverterTest {

    private final ClientConverter clientConverter = new ClientConverter();

    @Test
    void shouldConvertContentToSalesmanObjectWithSuccess() {
        String clientContentFake = ClientFaker.getValidClientContentFake();

        Client client = Assertions.assertDoesNotThrow(() -> clientConverter.convertContentToModel(clientContentFake));

        Assertions.assertNotNull(client);

        String[] salesmanSplitContent = clientContentFake.split("ç");
        Assertions.assertEquals(salesmanSplitContent[1], client.getCnpj());
        Assertions.assertEquals(salesmanSplitContent[2], client.getName());
        Assertions.assertEquals(salesmanSplitContent[3], client.getBussinessArea());
    }

    @Test
    void shouldThrowsErrorWhenTryToConvertInvalidContent() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> clientConverter.convertContentToModel(ClientFaker.getInvalidIdClientContentFake())
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> clientConverter.convertContentToModel(ClientFaker.getInvalidSeparatorClientContentFake())
        );
    }
}
