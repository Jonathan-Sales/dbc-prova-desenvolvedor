package br.com.dbccompany.model.report;

import br.com.dbccompany.model.Salesman;

public class ReportOutputDataDTO {

    private int clientQuantity;
    private int salesmanQuantity;
    private String mostExpensiveSale;
    private Salesman worstSalesman;

    public ReportOutputDataDTO(int clientQuantity, int salesmanQuantity, String mostExpensiveSale, Salesman worstSalesman) {
        this.clientQuantity = clientQuantity;
        this.salesmanQuantity = salesmanQuantity;
        this.mostExpensiveSale = mostExpensiveSale;
        this.worstSalesman = worstSalesman;
    }

    public int getClientQuantity() {
        return clientQuantity;
    }

    public int getSalesmanQuantity() {
        return salesmanQuantity;
    }

    public String getMostExpensiveSale() {
        return mostExpensiveSale;
    }

    public Salesman getWorstSalesman() {
        return worstSalesman;
    }
}
