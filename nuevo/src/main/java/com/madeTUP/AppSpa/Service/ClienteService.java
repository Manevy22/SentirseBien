/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Cliente;
import com.madeTUP.AppSpa.Model.Consulta;
import com.madeTUP.AppSpa.Model.Servicio;
import com.madeTUP.AppSpa.Model.Sesion;
import com.madeTUP.AppSpa.Repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Virginia
 */
@Service
public class ClienteService implements IClienteService{
    @Autowired 
    private IClienteRepository clienterepo;

    @Override
    public List<Cliente> getClientes() {
        return clienterepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        cliente.setear_Ses_Cons();
        clienterepo.save(cliente);
    }
    @Override
    public void deleteCliente(Long id) {
        clienterepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienterepo.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Long id, String nombre, String apellido, String correo, String contrasenia, String nombre_usuario, List<Sesion> listaSesiones, List<Consulta> listaConsultas,List<Servicio>listaServicios) {
        Cliente cliente=this.findCliente(id);
        cliente.setear_Ses_Cons();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);
        cliente.setContrasenia(contrasenia);
        cliente.setNombre_usuario(nombre_usuario);
        cliente.setListaSesiones(listaSesiones);
        cliente.setListaConsultas(listaConsultas);
        cliente.setListaServicio(listaServicios);
    }

    @Override
    public void editClienteII(Cliente cliente) {
        cliente.setear_Ses_Cons();
        this.saveCliente(cliente);
    }
}
