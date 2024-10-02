/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Personal;
import com.madeTUP.AppSpa.Model.Servicio;
import java.util.List;

/**
 *
 * @author Virginia
 */
public interface IPersonalService {
     public List<Personal> getPersonal();
    public void savePersonal (Personal personal);
    public void deletePersonal (Long id);
    public Personal findPersonal (Long id);
    public void editPersonal (Long id, String nombre, String apellido, String correo, String nombre_usuario, String contrasenia, Servicio servicio);
    public void editPersonalII (Personal personal);
}
