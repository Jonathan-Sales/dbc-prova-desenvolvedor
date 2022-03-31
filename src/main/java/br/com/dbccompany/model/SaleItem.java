package br.com.dbccompany.model;

import java.math.BigDecimal;

public class SaleItem {

    private String itemId;
    private int quantity;
    private BigDecimal price;

    public SaleItem(String itemId, int quantity, BigDecimal price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleItem saleItem = (SaleItem) o;

        if (quantity != saleItem.quantity) return false;
        if (!itemId.equals(saleItem.itemId)) return false;
        return price.equals(saleItem.price);
    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
