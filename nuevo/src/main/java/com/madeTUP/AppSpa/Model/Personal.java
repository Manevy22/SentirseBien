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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Personal {
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String nombre_usuario;
    private String contrasenia;
    @ManyToMany
    @JoinTable(name = "empleado_servicio", joinColumns = @JoinColumn(name = "empleado_id"),inverseJoinColumns = @JoinColumn(name = "servicio_id"))
            private List<Servicio> listaServicio;
    

    public Personal() {
    }

    public Personal(Long id, String nombre, String apellido, String correo, String nombre_usuario, String contrasenia, List<Servicio> listaServicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.listaServicio = listaServicio;
    }

    
    

}
