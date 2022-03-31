package br.com.dbccompany.faker;

import br.com.dbccompany.model.Salesman;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SalesmanFaker {

    public static String getValidSalesmanContentFake() {
        return "001ç1234567891234çPedroç50000";
    }

    public static String getInvalidIdSalesmanContentFake() {
        return "999ç1234567891234çPedroç50000";
    }

    public static String getInvalidSeparatorSalesmanContentFake() {
        return "001#1234567891234#Pedro#50000";
    }

    public static List<Salesman> getSalemanList(){
        List<Salesman> salesmen = new ArrayList<>();
        salesmen.add(
                new Salesman("68212594025", "John Doe", BigDecimal.valueOf(Math.random()).setScale(2, RoundingMode.DOWN))
        );
        salesmen.add(
                new Salesman("89572114034", "Pedro Silva", BigDecimal.valueOf(Math.random()).setScale(2, RoundingMode.DOWN))
        );
        salesmen.add(
                new Salesman("72928891072", "Jose Santos", BigDecimal.valueOf(Math.random()).setScale(2, RoundingMode.DOWN))
        );
        return salesmen;
    }
}
