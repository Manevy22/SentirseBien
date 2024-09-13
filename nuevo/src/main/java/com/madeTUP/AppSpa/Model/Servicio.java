/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 *
 * @author Virginia
 */

@Entity
@Getter@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Servicio {
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombreServicio;
    private Long nroEtapas;
    
    public Servicio() {
    }

    public Servicio(Long id, String nombreServicio, Long nroEtapas) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.nroEtapas = nroEtapas;
    }


    public String getNombreServicio() {
        return nombreServicio;
    }



    public void setNroEtapas(Long nroEtapas) {
        this.nroEtapas=nroEtapas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio=nombreServicio;
    }
}
