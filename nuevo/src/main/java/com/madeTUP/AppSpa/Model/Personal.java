package com.madeTUP.AppSpa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    
    @OneToOne
    @JoinColumn(name = "servicio_id")  // Define la columna que será clave aaforánea
    private Servicio servicio;  // Cambiado a una relación OneToOne con Servicio

    public Personal() {
    }

    public Personal(Long id, String nombre, String apellido, String correo, String nombre_usuario, String contrasenia, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.servicio = servicio;
    }
}
