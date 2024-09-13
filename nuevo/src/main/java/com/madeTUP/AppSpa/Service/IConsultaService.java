/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Cliente;
import com.madeTUP.AppSpa.Model.Consulta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Virginia
 */
public interface IConsultaService {
     public List<Consulta> getConsultas();
    public void saveConsulta (Consulta consulta);
    public void deleteConsulta (Long id);
    public Consulta findConsulta (Long id);
    public void editConsulta (Long id,Cliente cliente,String Desconsulta,LocalDate fecha);
    public void editConsultaII(Consulta consulta);
}
 