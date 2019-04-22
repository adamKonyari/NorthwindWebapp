package com.codecool.web.dao;

import com.codecool.web.model.Task5Query;

import java.util.List;

public interface Task5Dao {

    List<Task5Query> getResult();
    List<Task5Query> getFilteredResult(String product_name);
}
