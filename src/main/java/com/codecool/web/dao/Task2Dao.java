package com.codecool.web.dao;

import com.codecool.web.model.Task2Query;

import java.util.List;

public interface Task2Dao {

    List<Task2Query> getResult();

    List<Task2Query> getFilteredResult(int numberOfProducts);
}
