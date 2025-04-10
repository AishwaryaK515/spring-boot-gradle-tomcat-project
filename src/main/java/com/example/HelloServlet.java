package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Properties;

public class HelloServlet extends HttpServlet {
    private String appName;

    @Override
    public void init() throws ServletException {
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            appName = prop.getProperty("app.name", "MyApp");
        } catch (IOException e) {
            appName = "DefaultApp";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome to " + appName + "</h1>");
    }
}
