/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Cliente;
import com.madeTUP.AppSpa.Model.Consulta;
import com.madeTUP.AppSpa.Model.Servicio;
import com.madeTUP.AppSpa.Model.Sesion;
import java.util.List;

/**
 *
 * @author Virginia
 */
public interface IClienteService{
     public List<Cliente> getClientes();
    public void saveCliente (Cliente cliente);
    public void deleteCliente (Long id);
    public Cliente findCliente(Long id);
    public void editCliente (Long id,String nombre,String apellido,String correo,String contrasenia,String nombre_usuario,List<Sesion> listaSesiones,List<Consulta> listaConsultas,List<Servicio>listaServicios);
    public void editClienteII (Cliente cliente);
}
 