package com.codecool.web.dao.database;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task4Query;
import com.codecool.web.model.Task5Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task5Db extends AbstractDao implements Task5Dao {

    public Task5Db(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task5Query> getResult() {
        List<Task5Query> queries = new ArrayList<>();
        String sqlString = "select suppliers.company_name, products.product_name, products.unit_price from products join suppliers on suppliers.supplier_id = products.supplier_id join (select products.supplier_id, max(products.unit_price) as unit_price from products group by products.supplier_id) as Q1 on products.supplier_id = Q1.supplier_id and products.unit_price = Q1.unit_price order by unit_price desc;";
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                queries.add(fetchQuery(resultSet));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return queries;
    }

    @Override
    public List<Task5Query> getFilteredResult(String product_name) {
        List<Task5Query> queries = new ArrayList<>();
        String sqlString = "select suppliers.company_name, products.product_name, products.unit_price from products join suppliers on suppliers.supplier_id = products.supplier_id join (select products.supplier_id, max(products.unit_price) as unit_price from products group by products.supplier_id) as Q1 on products.supplier_id = Q1.supplier_id and products.unit_price = Q1.unit_price where product_name = '" + product_name + "' order by unit_price desc;";
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                queries.add(fetchQuery(resultSet));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }

    private Task5Query fetchQuery(ResultSet resultSet) throws SQLException {
        String company_name = resultSet.getString("company_name");
        String product_name = resultSet.getString("product_name");
        Double unit_price = resultSet.getDouble("unit_price");
        return new Task5Query(company_name, product_name, unit_price);
    }

}
