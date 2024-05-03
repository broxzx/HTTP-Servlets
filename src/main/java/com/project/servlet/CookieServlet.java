package com.project.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    public static final String UNIQUE_ID = "user-id";
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies == null || Arrays.stream(cookies).anyMatch(cookie -> cookie.getName().equals(UNIQUE_ID))) {
            Cookie cookie = new Cookie(UNIQUE_ID, "anyValue");
            response.addCookie(cookie);
            ATOMIC_INTEGER.incrementAndGet();
        }

        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(ATOMIC_INTEGER.get());
        }

    }

}
