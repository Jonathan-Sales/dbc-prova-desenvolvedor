package br.com.dbccompany.faker;

import br.com.dbccompany.model.SaleItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SaleItemFaker {

    public static String getValidSalesItemContentWithOneItemFake() {
        return "[1-34-10]";
    }

    public static String getValidSalesItemContentFake() {
        return "[1-34-10,2-33-1.50,3-40-0.10]";
    }

    public static List<SaleItem> getListValidSaleItemsFromContentFake() {
        String saleItems = getValidSalesItemContentFake();

        String sanitizedItems = saleItems.replace("[", "")
                .replace("]", "");
        String[] items = sanitizedItems.split(",");
        List<SaleItem> processedItems = new ArrayList<>();
        Arrays.stream(items).forEach(item -> {
            String[] itemSplit = item.split("-");
            processedItems.add(new SaleItem(
                    itemSplit[0],
                    Integer.parseInt(itemSplit[1]),
                    new BigDecimal(itemSplit[2])
            ));
        });

        return processedItems;
    }

    public static String getInvalidSalesItemContentFake() {
        return "[1-34,33-1.50,3-0.10]";
    }

    public static String getInvalidSeparatorSalesItemsContentFake() {
        return "[1-34-10#2-33-1.50#3-40-0.10]";
    }

    public static List<SaleItem> getValidSaleItemListWithRandomSaleValues() {
        List<SaleItem> saleItemList = new ArrayList<>();
        saleItemList.add(
                new SaleItem(
                        "01",
                        new Random().nextInt(10),
                        BigDecimal.valueOf(Math.random()).setScale(2, RoundingMode.DOWN)
                )
        );
        saleItemList.add(
                new SaleItem(
                        "02",
                        new Random().nextInt(10),
                        BigDecimal.valueOf(Math.random()).setScale(2, RoundingMode.DOWN)
                )
        );
        saleItemList.add(
                new SaleItem(
                        "03",
                        new Random().nextInt(10),
                        BigDecimal.valueOf(Math.random()).setScale(2, RoundingMode.DOWN)
                )
        );

        return saleItemList;
    }

}
