package br.com.dbccompany.model;

import java.math.BigDecimal;

public class Salesman {

    private String cpf;
    private String name;
    private BigDecimal salary;

    public Salesman(String cpf, String name, BigDecimal salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salesman salesman = (Salesman) o;

        if (!cpf.equals(salesman.cpf)) return false;
        return name.equals(salesman.name);
    }

    @Override
    public int hashCode() {
        int result = cpf.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
