package br.com.dbccompany.service;

import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.Salesman;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class SalesmanService {

    public Salesman findSalesmanFromListByName(List<Salesman> salesmen, String salesmanName) {
        return salesmen.stream()
                .filter(salesman -> salesman.getName().equals(salesmanName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%s não encontrado", salesmanName)
                ));
    }

    public HashMap<String, BigDecimal> sumSaleAmountPerSalesmanFromSalesList(List<Sale> sales) {
        HashMap<String, BigDecimal> salesAmountPerSalesman = new HashMap<>();
        for (Sale sale : sales) {
            BigDecimal saleTotal = sale.calculateTotal();
            salesAmountPerSalesman.merge(sale.getSalesmanName(), saleTotal, BigDecimal::add);
        }

        return salesAmountPerSalesman;
    }

}
