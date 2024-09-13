/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.DTO;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Getter @Setter
public class SesionDTO { 
    private String servicio;
    private LocalDate fecha; 
    private Double costo;
    private int asistencia;

    public SesionDTO() {
    }

    public SesionDTO(String servicio, LocalDate fecha, Double costo, int asistencia) {
        this.servicio = servicio;
        this.fecha = fecha;
        this.costo = costo;
        this.asistencia = asistencia;
    }
    
    
    
}
