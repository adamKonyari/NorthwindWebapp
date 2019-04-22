package com.codecool.web.service;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3Query;

import java.util.List;

public class Task3Service {
    private Task3Dao task3Dao;

    public Task3Service(Task3Dao task3Dao) {
        this.task3Dao = task3Dao;
    }

    public List<Task3Query> getResult() {
        return task3Dao.getResult();
    }

    public List<Task3Query> getFilteredResult(String company) {
        return task3Dao.getFilteredResult(company);
    }
}
