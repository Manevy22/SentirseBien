/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Controller;

import com.madeTUP.AppSpa.Model.Cliente;
import com.madeTUP.AppSpa.Model.Consulta;
import com.madeTUP.AppSpa.Service.IConsultaService;
import java.time.LocalDate;
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
public class ConsultaController {
    @Autowired 
    private IConsultaService servis;
    
    @GetMapping("/consulta/traer")
  public List<Consulta> getConsultas(){
      return servis.getConsultas();
  }
  
  @PostMapping("/Consulta/crear")
  public String crearConsulta(@RequestBody Consulta c){
      servis.saveConsulta(c);
      return "Consulta realizada";
  }
   @GetMapping("/Consulta/encontrar/{id_consulta}")
    public Consulta findConsulta(@PathVariable Long id_consulta){
        return servis.findConsulta(id_consulta);
    }
   @DeleteMapping("/Consulta/eliminar/{id_consulta}")
     public String deleteConsulta(@PathVariable Long id_consulta){
       servis.deleteConsulta(id_consulta);
       return "Consulta eliminada";
    }
     @PutMapping("/Consulta/editar/{id_consulta}")
     public Consulta editConsulta(@PathVariable Long id_consulta,
             @RequestParam(required=false,name="cliente")Cliente cliente,
            @RequestParam(required=false, name="Desconsulta")String Desconsulta,
            @RequestParam(required=false,name="fecha")LocalDate fecha){
         
               servis.editConsulta(id_consulta, cliente, Desconsulta, fecha);
               Consulta c=this.findConsulta(id_consulta);
               return c;
}
     @PutMapping("/Consulta/editarII")
     public Consulta editConsultaII(@RequestBody Consulta c)
     {
         servis.editConsultaII(c);
         return servis.findConsulta(c.getId());
     }
     
}

