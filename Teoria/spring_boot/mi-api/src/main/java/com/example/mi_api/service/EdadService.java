package com.example.mi_api.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EdadService {
   public Map<String, Object> calcularEdad(LocalDate fechaNacimiento) {

        LocalDate hoy = LocalDate.now();
        int edad = Period.between(fechaNacimiento, hoy).getYears();

        return Map.of(
            "fechaNacimiento", fechaNacimiento.toString(),
            "edad", edad,
            "mensaje", "Tienes " + edad + " años."
        );
    }
}
