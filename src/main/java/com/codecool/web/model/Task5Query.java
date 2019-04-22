package com.codecool.web.model;

public class Task5Query {
    String company_name;
    String product_name;
    Double unit_price;

    public Task5Query(String company_name, String product_name, Double unit_price) {
        this.company_name = company_name;
        this.product_name = product_name;
        this.unit_price = unit_price;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Double getUnit_price() {
        return unit_price;
    }
}
