package com.codecool.web.model;

public class Task2Query {
    private String company;
    private int numberOfProducts;

    public Task2Query(String company, int numberOfProducts) {
        this.company = company;
        this.numberOfProducts = numberOfProducts;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }
}
