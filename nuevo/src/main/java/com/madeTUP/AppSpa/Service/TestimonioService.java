/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Testimonio;
import com.madeTUP.AppSpa.Repository.ITestimonioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Virginia
 */
@Service
public class TestimonioService implements ITestimonioService{

    @Autowired
    private ITestimonioRepository testirepo;
    
    @Override
    public List<Testimonio> getTestimonio() {
       return testirepo.findAll();
    }

    @Override
    public void saveTestimonio(Testimonio testimonio) {
        testirepo.save(testimonio);
    }

    @Override
    public void deleteTestimonio(Long id) {
        testirepo.deleteById(id);
    }

    @Override
    public Testimonio findTestimonio(Long id) {
        return testirepo.findById(id).orElse(null);
    }
    

    @Override
    public void editTestimonio(Long id, String nombre, String testimonio) {
        Testimonio testi=this.findTestimonio(id);
        testi.setNombre(nombre);
        testi.setTestimonio(testimonio);
    }

    @Override
    public void editTestimonioII(Testimonio testimonio) {
        testirepo.save(testimonio);
    }
    
}
