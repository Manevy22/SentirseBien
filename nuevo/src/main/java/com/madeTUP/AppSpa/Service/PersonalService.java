/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Personal;
import com.madeTUP.AppSpa.Repository.IPersonalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Virginia
 */
@Service
public class PersonalService implements IPersonalService {
    @Autowired 
    private IPersonalRepository personalrepo;
    @Override
    public List<Personal> getPersonal() {
       return personalrepo.findAll();
    }

    @Override
    public void savePersonal(Personal personal) {
     personalrepo.save(personal);
    }

    @Override
    public void deletePersonal(Long id) {
    personalrepo.deleteById(id);
    }

    @Override
    public Personal findPersonal(Long id) {
        return personalrepo.findById(id).orElse(null);
    }

    @Override
    public void editPersonal(Long id, String nombre_usuario, String contrasenia) {
        Personal personal=this.findPersonal(id);
        personal.setNombre_usuario(nombre_usuario);
        personal.setContrasenia(contrasenia);
        
    }

    @Override
    public void editPersonalII(Personal personal) {
        this.savePersonal(personal);
    }
    
}
