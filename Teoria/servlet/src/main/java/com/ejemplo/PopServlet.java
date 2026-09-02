package com.ejemplo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/pop")
public class PopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (InputStream index = getServletContext().getResourceAsStream("/index.html")) {
            if (index == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encontró index.html");
                return;
            }

            index.transferTo(response.getOutputStream());
        }
    }
}