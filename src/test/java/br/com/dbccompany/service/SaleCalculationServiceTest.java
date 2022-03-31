package br.com.dbccompany.service;

import br.com.dbccompany.faker.SaleFaker;
import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.calculations.SaleTotalCalculationDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SaleCalculationServiceTest {

    private SaleCalculationService saleCalculationService = new SaleCalculationService();

    @Test
    public void shouldFindMostExpensiveSale() {
        List<Sale> salesList = SaleFaker.getValidSalesList();
        Sale validationLessExpensiveSale = Collections.max(salesList, Comparator.comparing(Sale::calculateTotal));

        SaleTotalCalculationDTO mostExpensiveSale = this.saleCalculationService.findMostExpensiveSaleFromSaleList(salesList);
        Assertions.assertNotNull(mostExpensiveSale);
        Assertions.assertEquals(validationLessExpensiveSale, mostExpensiveSale.getSale());
    }

    @Test
    public void shouldFindLessExpensiveSale() {
        List<Sale> salesList = SaleFaker.getValidSalesList();
        Sale validationLessExpensiveSale = Collections.min(salesList, Comparator.comparing(Sale::calculateTotal));

        SaleTotalCalculationDTO lessExpensiveSale = this.saleCalculationService.findLessExpensiveSaleFromSaleList(salesList);
        Assertions.assertNotNull(lessExpensiveSale);
        Assertions.assertEquals(validationLessExpensiveSale, lessExpensiveSale.getSale());
    }

}
