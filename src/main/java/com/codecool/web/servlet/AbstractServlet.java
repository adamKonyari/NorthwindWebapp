package com.codecool.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class AbstractServlet extends HttpServlet {

    Connection getConnection(ServletContext servletContext) throws SQLException {
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        return dataSource.getConnection();
    }
}
