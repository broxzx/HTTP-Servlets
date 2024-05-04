package com.project.servlet;

import com.project.dto.UserDto;
import com.project.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("content")
public class ContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", new UserDto(1L, "user-email@gmail.com"));
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
