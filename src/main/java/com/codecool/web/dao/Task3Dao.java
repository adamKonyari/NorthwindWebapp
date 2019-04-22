package com.codecool.web.dao;

import com.codecool.web.model.Task3Query;

import java.util.List;

public interface Task3Dao {

    List<Task3Query> getResult();
    List<Task3Query> getFilteredResult(String company);
}
