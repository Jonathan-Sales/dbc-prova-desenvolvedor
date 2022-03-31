package br.com.dbccompany.service;

import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.calculations.SaleTotalCalculationDTO;

import java.math.BigDecimal;
import java.util.List;

public class SaleCalculationService {

    public SaleTotalCalculationDTO findMostExpensiveSaleFromSaleList(List<Sale> salesList) {
        Sale mostExpensiveSale = null;
        BigDecimal mostExpensiveSaleTotal = BigDecimal.ZERO;
        for (Sale sale : salesList) {
            BigDecimal totalSaleValue = sale.calculateTotal();

            if (mostExpensiveSaleTotal.compareTo(totalSaleValue) <= 0) {
                mostExpensiveSaleTotal = totalSaleValue;
                mostExpensiveSale = sale;
            }
        }

        return new SaleTotalCalculationDTO(mostExpensiveSale, mostExpensiveSaleTotal);
    }

    public SaleTotalCalculationDTO findLessExpensiveSaleFromSaleList(List<Sale> salesList) {
        Sale lessExpensiveSale = null;
        BigDecimal lessExpensiveSaleTotal = null;
        for (Sale sale : salesList) {
            BigDecimal totalSaleValue = sale.calculateTotal();

            if (lessExpensiveSaleTotal == null || lessExpensiveSaleTotal.compareTo(totalSaleValue) >= 0) {
                lessExpensiveSaleTotal = totalSaleValue;
                lessExpensiveSale = sale;
            }
        }

        return new SaleTotalCalculationDTO(lessExpensiveSale, lessExpensiveSaleTotal);
    }

}
