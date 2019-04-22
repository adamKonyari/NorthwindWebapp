package com.codecool.web.servlet;


import com.codecool.web.dao.Task5Dao;
import com.codecool.web.dao.database.Task5Db;
import com.codecool.web.model.Task5Query;
import com.codecool.web.service.Task5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task5")
public class Task5Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new Task5Db(connection);
            Task5Service task5Service = new Task5Service(task5Dao);
            List<Task5Query> task5result = task5Service.getResult();
            req.setAttribute("task5Result", task5result);
            req.getRequestDispatcher("tasks/task5.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product_name = req.getParameter("product_name");
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new Task5Db(connection);
            Task5Service task5Service = new Task5Service(task5Dao);
            List<Task5Query> task5Result = task5Service.getFilteredResult(product_name);
            req.setAttribute("task5Result", task5Result);
            req.getRequestDispatcher("tasks/task5.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
