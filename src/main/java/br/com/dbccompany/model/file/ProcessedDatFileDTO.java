package br.com.dbccompany.model.file;

import br.com.dbccompany.model.Client;
import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.Salesman;

import java.util.ArrayList;
import java.util.List;

public class ProcessedDatFileDTO {

    private String filename;
    private List<Salesman> salesmen;
    private List<Client> clients;
    private List<Sale> sales;

    public ProcessedDatFileDTO(String filename) {
        this.filename = filename;
        this.salesmen = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.sales = new ArrayList<>();
    }

    public String getFilename() {
        return filename;
    }

    public List<Salesman> getSalesmen() {
        return salesmen;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
