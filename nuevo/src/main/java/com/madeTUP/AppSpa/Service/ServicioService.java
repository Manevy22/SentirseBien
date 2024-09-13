/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.DTO.ServicioDTO;
import com.madeTUP.AppSpa.Model.Servicio;
import com.madeTUP.AppSpa.Repository.IServicioRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Virginia
 */
@Service
public class ServicioService implements IServicioService{

    @Autowired
    private IServicioRepository serviciorepo;
    @Override
    public List<Servicio> getServicio() {
        return serviciorepo.findAll();
    }

    @Override
    public void saveServicio(Servicio servicio) {
        serviciorepo.save(servicio);
    }

    @Override
    public void deleteServicio(Long id) {
        serviciorepo.deleteById(id);
    }

    @Override
    public Servicio findServicio(Long id) {
        return serviciorepo.findById(id).orElse(null);
    }

    @Override
    public void editServicio(Long id, String nombre_servicio, Long nroEtapas) {
        Servicio servicio=this.findServicio(id);
        servicio.setNombreServicio(nombre_servicio);
        servicio.setNroEtapas(nroEtapas);
        }

    @Override
    public void editServicioII(Servicio servicio) {
        this.saveServicio(servicio);
        
    }
    @Override
    public List<ServicioDTO> obtenerTodosServicios() {
        List<Servicio> servicios = serviciorepo.findAll();
        return servicios.stream()
                .map(servicio -> new ServicioDTO(servicio.getId(), servicio.getNombreServicio()))
                .collect(Collectors.toList());
    }

    public List<ServicioDTO> getAllServicios() {
        // Recuperar todos los servicios de la base de datos
        List<Servicio> servicios = serviciorepo.findAll();

        // Convertir la lista de entidades a DTOs
        return servicios.stream()
                .map(servicio -> new ServicioDTO(servicio.getId(), servicio.getNombreServicio()))
                .collect(Collectors.toList());
    }

}
