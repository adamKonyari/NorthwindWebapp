package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task1Query;
import com.codecool.web.model.Task2Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Task2Db extends AbstractDao implements Task2Dao {
    public Task2Db(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task2Query> getResult() {
        List<Task2Query> queries = new ArrayList<>();
        String sqlString = "select company_name as Company, count(product_name) as NumberOfProducts from suppliers s join products p on s.supplier_id = p.supplier_id group by s.company_name order by NumberOfProducts desc, Company asc";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                queries.add(fetchQuery(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }

    @Override
    public List<Task2Query> getFilteredResult(int numberOfProducts) {
        List<Task2Query> queries = new ArrayList<>();
        String sqlString = "select company_name as Company, count(product_name) as NumberOfProducts from suppliers s join products p on s.supplier_id = p.supplier_id group by s.company_name having count(product_name) = " + numberOfProducts + " order by NumberOfProducts desc, Company asc";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                queries.add(fetchQuery(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }

    private Task2Query fetchQuery(ResultSet resultSet) throws SQLException {
        String product = resultSet.getString("product");
        int numberOfProducts = resultSet.getInt("numberofproducts");
        return new Task2Query(product, numberOfProducts);
    }
}
