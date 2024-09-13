/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Sesion {
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
    @ManyToOne
@JoinColumn(name="cliente_id")
    private Cliente cliente;
    private LocalDate fecha; 
    private Double costo;
    private int asistencia;

    public Sesion() {
    }

    public Sesion(Long id, Servicio servicio, Cliente cliente, LocalDate fecha, Double costo, int asistencia) {
        this.id = id;
        
      this.servicio = servicio;
        this.cliente = cliente;
        this.fecha = fecha;
        this.costo = costo;
        this.asistencia = asistencia;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getId_Cliente() {
        return cliente;
    }

    public void setId_Cliente(Cliente id_Cliente) {
        this.cliente = id_Cliente;
    }

    public Servicio getId_Servicio() {
        return servicio;
    }

    public void setId_Servicio(Servicio id_Servicio) {
        this.servicio= id_Servicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public void setCliente(Cliente c) {
        this.cliente=c;
    }
    public void setServicio(Servicio s) {
        this.servicio=s;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
