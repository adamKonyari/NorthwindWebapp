package com.codecool.web.service;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Query;

import java.util.List;

public class Task5Service {

    private Task5Dao task5Dao;

    public Task5Service(Task5Dao task5Dao) {
        this.task5Dao = task5Dao;
    }

    public List<Task5Query> getResult() {
        return task5Dao.getResult();
    }

    public List<Task5Query> getFilteredResult(String product_name) {
        return task5Dao.getFilteredResult(product_name);
    }
}
