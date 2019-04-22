package com.codecool.web.dao;

import com.codecool.web.model.Task4Query;

import java.util.List;

public interface Task4Dao {

    List<Task4Query> getResult();
    List<Task4Query> getFilteredResult(String company);

}
