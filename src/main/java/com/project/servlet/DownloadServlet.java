package com.project.servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=download.txt");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        byte[] bytes = Files.readAllBytes(Path.of("resources", "template.json"));
        try (ServletOutputStream outputStream = response.getOutputStream();
             InputStream resourceAsStream = DownloadServlet.class.getClassLoader().getResourceAsStream("template.json")) {
            outputStream.write(resourceAsStream.readAllBytes());
        }

    }

}
