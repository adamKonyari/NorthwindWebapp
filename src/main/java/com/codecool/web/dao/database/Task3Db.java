package com.codecool.web.dao.database;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Task3Db extends AbstractDao implements Task3Dao {

    public Task3Db(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task3Query> getResult() {
        List<Task3Query> queries = new ArrayList<>();
        String sqlString = "select company_name as Company from suppliers s join products p on s.supplier_id = p.supplier_id group by s.company_name having count(product_name) = 5 order by s.company_name asc";
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
    public List<Task3Query> getFilteredResult(String company) {
        List<Task3Query> queries = new ArrayList<>();
        String sqlString = "select company_name as Company from suppliers s join products p on s.supplier_id = p.supplier_id where s.company_name = '" + company + "' group by s.company_name having count(product_name) = 5 order by s.company_name asc";
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

    private Task3Query fetchQuery(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        return new Task3Query(company);
    }


}
