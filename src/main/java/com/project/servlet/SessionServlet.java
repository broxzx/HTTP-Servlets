package com.project.servlet;

import com.project.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("session")
public class SessionServlet extends HttpServlet {

    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Enumeration<String> attributeNames = session.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();

            System.out.println(attributeName);
        }

        UserDto user = (UserDto) session.getAttribute(USER);
        if (user == null) {
            user = new UserDto(25L, "example@gmail.com");
            session.setAttribute("user", user);
        }

        System.out.println(session.getAttribute(USER));
    }
}
