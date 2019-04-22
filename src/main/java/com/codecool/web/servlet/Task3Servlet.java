package com.codecool.web.servlet;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.dao.database.Task3Db;
import com.codecool.web.model.Task3Query;
import com.codecool.web.service.Task3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task3")
public class Task3Servlet extends AbstractServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new Task3Db(connection);
            Task3Service task3Service = new Task3Service(task3Dao);
            List<Task3Query> task3Result = task3Service.getResult();
            req.setAttribute("task3Result", task3Result);
            req.getRequestDispatcher("tasks/task3.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company = req.getParameter("company");
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new Task3Db(connection);
            Task3Service task3Service = new Task3Service(task3Dao);
            List<Task3Query> task3Result = task3Service.getFilteredResult(company);
            req.setAttribute("task3Result", task3Result);
            req.getRequestDispatcher("tasks/task3.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
