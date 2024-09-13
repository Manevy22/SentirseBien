/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.DTO;

import com.madeTUP.AppSpa.Model.Sesion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Setter @Getter
public class ClientePerfilDTO {
    private Long id;
     private String nombre;
    private String apellido;
    private List<SesionDTO> lista_Sesiones;

    public ClientePerfilDTO() {
    }

    public ClientePerfilDTO(Long id, String nombre, String apellido, List<SesionDTO> lista_Sesiones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lista_Sesiones = lista_Sesiones;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<SesionDTO> getListaSesiones() {
        return lista_Sesiones;
    }

    public void setListaSesiones(List<SesionDTO> lista_Sesiones) {
        this.lista_Sesiones = lista_Sesiones;
    }



}
