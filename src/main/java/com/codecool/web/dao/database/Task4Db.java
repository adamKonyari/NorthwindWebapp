package com.codecool.web.dao.database;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task4Db extends AbstractDao implements Task4Dao {

    public Task4Db(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task4Query> getResult() {
        List<Task4Query> queries = new ArrayList<>();
        String sqlString = "select company_name as Company, array_agg(order_id) as order_id from customers c left join orders o on c.customer_id = o.customer_id group by c.company_name order by Company";
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
    public List<Task4Query> getFilteredResult(String company) {
        List<Task4Query> queries = new ArrayList<>();
        String sqlString = "select company_name as Company, array_agg(order_id) as order_id from customers c left join orders o on c.customer_id = o.customer_id where company_name = '" + company + "'group by c.company_name order by Company";
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

    private Task4Query fetchQuery(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        Array order_id = resultSet.getArray("order_id");
        return new Task4Query(company, order_id);
    }

}
