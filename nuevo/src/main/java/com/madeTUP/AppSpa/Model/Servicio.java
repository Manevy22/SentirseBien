package com.madeTUP.AppSpa.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */

@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nombreServicio;
    private Long nroEtapas;
    
    @ManyToOne
    @JoinColumn(name = "personal_id")  // Un Servicio lo realiza un solo Personal
    private Personal personal;

    public Servicio() {
    }

    public Servicio(Long id, String nombreServicio, Long nroEtapas, Personal personal) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.nroEtapas = nroEtapas;
        this.personal = personal;
    }
}
