package com.example.mi_api;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Permite peticiones desde el formulario en el navegador
public class EdadController {

    @GetMapping("/api/calcular-edad")
    public Map<String, Object> calcularEdad(
            LocalDate fechaNacimiento) {

        LocalDate hoy = LocalDate.now();
        int edad = Period.between(fechaNacimiento, hoy).getYears();

        return Map.of(
            "fechaNacimiento", fechaNacimiento.toString(),
            "edad", edad,
            "mensaje", "Tienes " + edad + " años."
        );
    }
}