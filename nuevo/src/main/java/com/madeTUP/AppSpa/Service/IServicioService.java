/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.DTO.ServicioDTO;
import com.madeTUP.AppSpa.Model.Servicio;
import java.util.List;

/**
 *
 * @author Virginia
 */
public interface IServicioService {
    public List<Servicio> getServicio();
    public void saveServicio (Servicio servicio);
    public void deleteServicio (Long id);
    public Servicio findServicio (Long id);
    public void editServicio (Long id,String nombre_servicio,Long nroEtapas);
    public void editServicioII (Servicio servicio);

   public  List<ServicioDTO> obtenerTodosServicios();

    public List<ServicioDTO> getAllServicios();
}
 