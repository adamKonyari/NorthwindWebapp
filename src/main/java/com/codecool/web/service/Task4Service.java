package com.codecool.web.service;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4Query;

import java.util.List;

public class Task4Service {

    private Task4Dao task4Dao;

    public Task4Service(Task4Dao task4Dao) {
        this.task4Dao = task4Dao;
    }

    public List<Task4Query> getResult() {
        return task4Dao.getResult();
    }

    public List<Task4Query> getFilteredResult(String company) {
        return task4Dao.getFilteredResult(company);
    }
}
