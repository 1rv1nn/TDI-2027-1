package com.ejemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@WebServlet("/pop")
public class PopServlet extends HttpServlet {

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
}