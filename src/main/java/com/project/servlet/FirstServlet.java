package com.project.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("param");
        Map<String, String[]> parameterMap = req.getParameterMap();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.printf("key : %s, value: %s%n", entry.getKey(), Arrays.toString(entry.getValue()));
        }

        resp.setContentType("text/html");
        req.getHeader("user-agent");
        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String string = headerNames.nextElement();
            System.out.println(req.getHeader(string));
        }

        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("token", "23541");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("Hello from first Servlet!");
        }
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
