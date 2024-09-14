/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Getter
@Setter
public class PersonalPerfilDTO {
   
     private Long id;
    private String nombre_usuario;
    private List<SesionPersonalDTO> listaPer_Ses;

    public PersonalPerfilDTO() {
    }

    public PersonalPerfilDTO(Long id, String nombre_usuario, List<SesionPersonalDTO> listaPer_Ses) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.listaPer_Ses = listaPer_Ses;
    }
  
}
