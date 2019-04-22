package com.codecool.web.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public final class WebappContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataSource dataSource = putDataSourceToServletContext(servletContextEvent);
        System.out.println("Webapp deployed.");
    }

    private DataSource putDataSourceToServletContext(ServletContextEvent servletContextEvent) {
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/northwindWebapp");
            ServletContext servletContext = servletContextEvent.getServletContext();
            servletContext.setAttribute("dataSource", dataSource);
            return dataSource;

        } catch (NamingException ex) {
            ex.printStackTrace();
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Webapp undeployed.");
    }
}
