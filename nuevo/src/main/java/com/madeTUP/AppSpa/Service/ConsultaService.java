/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Cliente;
import com.madeTUP.AppSpa.Model.Consulta;
import com.madeTUP.AppSpa.Repository.IConsultaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Virginia
 */
@Service
public class ConsultaService implements IConsultaService{
    @Autowired
    private IConsultaRepository consultarepo;
    @Override
    public List<Consulta> getConsultas() {
        return consultarepo.findAll();
    }

    @Override
    public void saveConsulta(Consulta consulta) {
        consultarepo.save(consulta);
    }

    @Override
    public void deleteConsulta(Long id) {
        consultarepo.deleteById(id);
    }

    @Override
    public Consulta findConsulta(Long id) {
        return consultarepo.findById(id).orElse(null);
    }

    @Override
    public void editConsulta(Long id, Cliente cliente, String Desconsulta, LocalDate fecha) {
        Consulta consulta=this.findConsulta(id);
        consulta.setCliente(cliente);
        consulta.setDesconsulta(Desconsulta);
        consulta.setFecha(fecha);
    }

    @Override
    public void editConsultaII(Consulta consulta) {
        this.saveConsulta(consulta);
    }
    
}
