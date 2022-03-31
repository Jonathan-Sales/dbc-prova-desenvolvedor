package br.com.dbccompany.model.calculations;

import br.com.dbccompany.model.Sale;

import java.math.BigDecimal;

public class SaleTotalCalculationDTO {

    private Sale sale;
    private BigDecimal total;

    public SaleTotalCalculationDTO(Sale sale, BigDecimal total) {
        this.sale = sale;
        this.total = total;
    }

    public Sale getSale() {
        return sale;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
