package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class Task1Db extends AbstractDao implements Task1Dao {


    public Task1Db(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task1Query> getResult() {
        List<Task1Query> queries = new ArrayList<>();
        String sqlString = "select product_name as Product, company_name as Company from products p join suppliers s on p.supplier_id = s.supplier_id order by p.product_name, s.company_name asc";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString)) {
            while(resultSet.next()) {
                queries.add(fetchQuery(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }

    @Override
    public List<Task1Query> getFilteredResult(String company) {
        List<Task1Query> queries = new ArrayList<>();
        String sqlString = "select product_name as Product, company_name as Company from products p join suppliers s on p.supplier_id = s.supplier_id where s.company_name = '" + company + "' order by p.product_name, s.company_name asc";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString)) {
            while(resultSet.next()) {
                queries.add(fetchQuery(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }

    private Task1Query fetchQuery(ResultSet resultSet) throws SQLException {
        String product = resultSet.getString("product");
        String company = resultSet.getString("company");
        return new Task1Query(product, company);
    }
}
