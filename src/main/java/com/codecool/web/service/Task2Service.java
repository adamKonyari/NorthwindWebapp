package com.codecool.web.service;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2Query;

import java.util.List;

public class Task2Service {

    private Task2Dao task2Dao;

    public Task2Service(Task2Dao task2Dao) {
        this.task2Dao = task2Dao;
    }

    public List<Task2Query> getResult() {
        return task2Dao.getResult();
    }

    public List<Task2Query> getFilteredResult(int numberOfProducts) {
        return task2Dao.getFilteredResult(numberOfProducts);
    }
}
