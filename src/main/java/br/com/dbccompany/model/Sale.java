package br.com.dbccompany.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Sale {

    private String saleId;
    private List<SaleItem> items;
    private String salesmanName;

    public Sale(String saleId, List<SaleItem> items, String salesmanName) {
        this.saleId = saleId;
        this.items = items;
        this.salesmanName = salesmanName;
    }

    public String getSaleId() {
        return saleId;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public BigDecimal calculateTotal() {
        return items.stream().reduce(
                BigDecimal.ZERO,
                (sum, saleItem) -> {
                    BigDecimal saleItemTotal = saleItem.getPrice().multiply(BigDecimal.valueOf(saleItem.getQuantity()));
                    return sum.add(saleItemTotal);
                },
                BigDecimal::add
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (!saleId.equals(sale.saleId)) return false;
        if (!Objects.equals(items, sale.items)) return false;
        return salesmanName.equals(sale.salesmanName);
    }

    @Override
    public int hashCode() {
        int result = saleId.hashCode();
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + salesmanName.hashCode();
        return result;
    }
}
