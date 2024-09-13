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
@Getter
@Setter
public class SesionPersonalDTO{
    private Long idA;
    private Long idCliente;
    private String nombreCliente;
     private String servicio;
    private LocalDate fecha; 
    private Double costo;
    private int asistencia;

    public SesionPersonalDTO() {
    }

    public SesionPersonalDTO(Long idA,Long idCliente, String nombreCliente, String servicio, LocalDate fecha, Double costo, int asistencia) {
       this.idA=idA;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.costo = costo;
        this.asistencia = asistencia;
    }
    public Long getIdSesion(Long idA) {
        return this.idA;
    }

    public void setId(Long idA) {
        this.idA = idA;
    }
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int  getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
}
    

