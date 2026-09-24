package com.example.mi_api.controller;

import  com.example.mi_api.service.EdadService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins = "*")
public class EdadController {
  
  private final EdadService edadService;

  public EdadController (EdadService edadService){
    this.edadService=edadService;
  }

  @GetMapping("/api/calcular-edad")
  public Map<String, Object> calcularEdad(
    @RequestParam("fechaNacimiento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaNacimiento) {
    return edadService.calcularEdad(fechaNacimiento);
  }
}
