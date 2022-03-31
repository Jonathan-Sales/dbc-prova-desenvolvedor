package br.com.dbccompany.faker;

import br.com.dbccompany.model.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleFaker {

    public static String getValidSaleContentFake() {
        return "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
    }

    public static String getInvalidIdSaleContentFake() {
        return "999ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
    }

    public static String getInvalidSeparatorSaleContentFake() {
        return "003#10#[1-10-100,2-30-2.50,3-40-3.10]#Pedro";
    }

    public static List<Sale> getValidSalesList(){
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale("01", SaleItemFaker.getValidSaleItemListWithRandomSaleValues(), "Joao"));
        sales.add(new Sale("02", SaleItemFaker.getValidSaleItemListWithRandomSaleValues(), "Pedro"));
        sales.add(new Sale("03", SaleItemFaker.getValidSaleItemListWithRandomSaleValues(), "Paulo"));

        return sales;
    }
}
