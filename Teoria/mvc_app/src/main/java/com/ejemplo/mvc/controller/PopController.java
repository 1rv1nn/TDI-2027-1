package com.ejemplo.mvc.controller;

import com.ejemplo.mvc.dao.CancionDAO;
import com.ejemplo.mvc.model.Cancion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/pop")
public class PopController extends HttpServlet {
    private final CancionDAO cancionDAO = new CancionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("cancion");
        if (id != null && !id.isBlank()) {
            Cancion cancion = cancionDAO.buscarPorId(id).orElse(null);
            if (cancion == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Canción no encontrada");
                return;
            }
            request.getRequestDispatcher("/html/" + cancion.getPagina()).forward(request, response);
            return; //evitar que cargue el catalogo general
        }

        request.setAttribute("filtro", valor(request.getParameter("filtro")));
        request.setAttribute("canciones", cancionDAO.listar(request.getParameter("filtro")));
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String> datos = Map.ofEntries(
            Map.entry("artista", valor(request.getParameter("artista"))),
            Map.entry("titulo", valor(request.getParameter("titulo"))),
            Map.entry("album", valor(request.getParameter("album"))));

        if (!cancionDAO.esValida(datos)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Los datos de la canción no son válidos");
            return;
        }

        cancionDAO.agregar(datos.get("artista"), datos.get("titulo"), datos.get("album"));
        response.sendRedirect(request.getContextPath() + "/pop?agregada=true");
    }

    private String valor(String valor) {
        return valor == null ? "" : valor;
    }
}
