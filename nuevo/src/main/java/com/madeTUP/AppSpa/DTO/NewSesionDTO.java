/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Getter@Setter
public class NewSesionDTO {
    
    private Long id; 
    private Long id_Cliente;
    private Long id_Servicio;
     private String fecha; 
    private Double costo;
    private int asistencia;

    public NewSesionDTO() {
    }
    

    public NewSesionDTO(Long id, Long id_Cliente, Long id_Servicio, String fecha, Double costo, int asistencia) {
        this.id = id;
        this.id_Cliente = id_Cliente;
        this.id_Servicio = id_Servicio;
        this.fecha = fecha;
        this.costo = costo;
        this.asistencia = asistencia;
    }



}
