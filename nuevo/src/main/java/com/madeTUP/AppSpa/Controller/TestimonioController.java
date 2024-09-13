/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Controller;

import com.madeTUP.AppSpa.Model.Testimonio;
import com.madeTUP.AppSpa.Service.ITestimonioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Virginia
 */
@RestController
public class TestimonioController {
    @Autowired
    private ITestimonioService servis;
   
    @GetMapping("/Testimonio/traer")
    public List<Testimonio> getTestimonio(){
        return servis.getTestimonio();
    }
    
    @PostMapping("/Testimonio/crear")
    public String crearTestimonio(@RequestBody Testimonio c){
        servis.saveTestimonio(c);
        return "Testimonio creado";
    }
    @GetMapping("/Testimonio/encontrar/{id_testimonio}")
    public Testimonio findTestimonio(@PathVariable Long id_testimonio){
        return servis.findTestimonio(id_testimonio);
    }
    @DeleteMapping("/Testimonio/eliminar/{id_testimonio}")
     public String deleteTestimonio(@PathVariable Long id_testimonio){
       servis.deleteTestimonio(id_testimonio);
       return "Testimonio eliminado";
    }
     @PutMapping("/Testimonio/editar/{id_testimonio}")
     public Testimonio editTestimonio(@PathVariable Long id_testimonio,
             @RequestParam(required=false,name="nombre")String newname,
            @RequestParam(required=false, name="testimonio")String testimonio){
         
               servis.editTestimonio(id_testimonio, newname, testimonio);
               Testimonio c=this.findTestimonio(id_testimonio);
               return c;
}
     @PutMapping("/Testimonio/editarII")
     public Testimonio editTestimonioII(@RequestBody Testimonio c)
     {
         servis.editTestimonioII(c);
         return servis.findTestimonio(c.getId());
     }
}
