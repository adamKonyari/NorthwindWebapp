package com.codecool.web.service;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Query;

import java.util.List;

public class Task1Service {
    Task1Dao task1Dao;

    public Task1Service(Task1Dao task1Dao) {
        this.task1Dao = task1Dao;
    }

    public List<Task1Query> getResult() {
        return task1Dao.getResult();
    }

    public List<Task1Query> getFilteredResult(String company) {
        return task1Dao.getFilteredResult(company);
    }
}
