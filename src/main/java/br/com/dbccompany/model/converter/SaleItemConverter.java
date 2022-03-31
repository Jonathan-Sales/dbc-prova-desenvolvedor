package br.com.dbccompany.model.converter;

import br.com.dbccompany.model.SaleItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleItemConverter {

    public List<SaleItem> convertContentToSaleItemList(String content) {
        this.validateContent(content);

        String sanitizedItems = content.replace("[", "")
                .replace("]", "");
        String[] items = sanitizedItems.split(",");
        List<SaleItem> convertedItems = new ArrayList<>();
        for (String item : items) {
            convertedItems.add(this.convertContentToItemSale(item));
        }

        return convertedItems;
    }

    private void validateContent(String content) {
        boolean containsBrackets = content.startsWith("[") && content.endsWith("]");
        boolean containsItemDetailSeparator = content.contains("-");
        if (!containsBrackets || !containsItemDetailSeparator) {
            throw new IllegalArgumentException(String.format("Não é possível converter o item: %s", content));
        }
    }

    private SaleItem convertContentToItemSale(String content){
        try {
            String[] itemSplit = content.split("-");
            return new SaleItem(
                    itemSplit[0],
                    Integer.parseInt(itemSplit[1]),
                    new BigDecimal(itemSplit[2])
            );
        } catch (Exception ex) {
            throw new IllegalArgumentException(String.format("Não é possível converter o item: %s", content));
        }
    }

}
