package com.ejemplo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hola")
public class HolaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("nombre");
        if (nombre == null || nombre.isBlank()) {
            nombre = "Mundo";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Hola Servlet</title></head>");
            out.println("<body>");
            out.println("<h1>¡Hola, " + nombre + "!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}