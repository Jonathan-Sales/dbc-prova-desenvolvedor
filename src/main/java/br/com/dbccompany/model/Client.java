package br.com.dbccompany.model;

public class Client {

    private String cnpj;
    private String name;
    private String bussinessArea;

    public Client(String cnpj, String name, String bussinessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.bussinessArea = bussinessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBussinessArea() {
        return bussinessArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!cnpj.equals(client.cnpj)) return false;
        return name.equals(client.name);
    }

    @Override
    public int hashCode() {
        int result = cnpj.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
