package com.ejemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.Map;

@WebServlet("/pop")
public class PopServlet extends HttpServlet {

    private static final Set<String> ARTISTAS = Set.of("Michael Jackson", "Madonna");
    private static final Set<String> TITULOS = Set.of("Dangerous", "Into The Groove");
    private static final Set<String> ALBUMES = Set.of("Dangerous", "Holiday");

    private static final Map<String, String> CANCIONES = Map.ofEntries(
            Map.entry("like_virgin", "like_virgin.html"),
            Map.entry("remember_time", "remember_time.html"),
            Map.entry("papa_dont_preach", "papa_dont_preach.html"),
            Map.entry("one_more_chance", "one_more_chance.html"),
            Map.entry("holiday", "holiday.html"),
            Map.entry("baby_be_mine", "baby_be_mine.html"),
            Map.entry("you_rock_my_world", "you_rock_my_world.html"),
            Map.entry("everybody", "everybody.html"));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");

        String cancion = request.getParameter("cancion");
        if (cancion != null && !cancion.isBlank()) {
            String pagina = CANCIONES.get(cancion);
            if (pagina == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Canción no encontrada");
                return;
            }

            request.getRequestDispatcher("/html/" + pagina).forward(request, response);
            return;
        }

        try (InputStream index = getServletContext().getResourceAsStream("/index.html")) {
            if (index == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encontró index.html");
                return;
            }

            index.transferTo(response.getOutputStream());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        //Valores del formulario canciones.jsp

        String artista = request.getParameter("artista");
        String titulo = request.getParameter("titulo");
        String album = request.getParameter("album");

        if (!ARTISTAS.contains(artista) || !TITULOS.contains(titulo) || !ALBUMES.contains(album)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Los datos de la canción no son válidos");
            return;
        }

        //Guarda los datos como atributo, temporalmente
        request.setAttribute("artista", artista);
        request.setAttribute("titulo", titulo);
        request.setAttribute("album", album);

        //Son utilizados por JSP
        request.getRequestDispatcher("/cancion-agregada.jsp").forward(request, response);
    }
}