package com.codecool.web.model;

import java.sql.Array;

public class Task4Query {

    String company;
    Array order_id;

    public Task4Query(String company, Array order_id) {
        this.company = company;
        this.order_id = order_id;
    }

    public String getCompany() {
        return company;
    }

    public Array getOrder_id() {
        return order_id;
    }
}
