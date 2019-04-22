package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.database.Task1Db;
import com.codecool.web.model.Task1Query;
import com.codecool.web.service.Task1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task1")
public class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new Task1Db(connection);
            Task1Service task1Service = new Task1Service(task1Dao);
            List<Task1Query> task1Result = task1Service.getResult();
            req.setAttribute("task1Result", task1Result);
            req.getRequestDispatcher("tasks/task1.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comapny = req.getParameter("company");
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new Task1Db(connection);
            Task1Service task1Service = new Task1Service(task1Dao);
            List<Task1Query> task1Result = task1Service.getFilteredResult(comapny);
            req.setAttribute("task1Result", task1Result);
            req.getRequestDispatcher("tasks/task1.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
