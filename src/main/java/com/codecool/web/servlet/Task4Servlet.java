package com.codecool.web.servlet;


import com.codecool.web.dao.Task4Dao;
import com.codecool.web.dao.database.Task4Db;
import com.codecool.web.model.Task4Query;
import com.codecool.web.service.Task4Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task4")
public class Task4Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4Dao task4Dao = new Task4Db(connection);
            Task4Service task4Service = new Task4Service(task4Dao);
            List<Task4Query> task4Result = task4Service.getResult();
            req.setAttribute("task4Result", task4Result);
            req.getRequestDispatcher("tasks/task4.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company = req.getParameter("company");
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4Dao task4Dao = new Task4Db(connection);
            Task4Service task4Service = new Task4Service(task4Dao);
            List<Task4Query> task4Result = task4Service.getFilteredResult(company);
            req.setAttribute("task4Result", task4Result);
            req.getRequestDispatcher("tasks/task4.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
