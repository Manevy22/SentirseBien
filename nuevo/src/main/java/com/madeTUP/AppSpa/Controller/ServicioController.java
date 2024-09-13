/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Controller;

import com.madeTUP.AppSpa.DTO.ServicioDTO;
import com.madeTUP.AppSpa.Model.Servicio;
import com.madeTUP.AppSpa.Service.IServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Virginia
 */

@RestController
@RequestMapping("/servicio")

@CrossOrigin(origins = "http://127.0.0.1:8080")
public class ServicioController {
    @Autowired 
    private IServicioService servis;

    @GetMapping("/traerServicio")
    public ResponseEntity<List<ServicioDTO>> obtenerServicios() {
        // Lógica para obtener servicios
        List<ServicioDTO> servicios = servis.getAllServicios();
        return ResponseEntity.ok(servicios);
    }
    @GetMapping("/traer")
    public List<Servicio> getServicio(){
        return servis.getServicio();
    }
    
    @PostMapping("/Servicio/crear")
    public String crearServicio(@RequestBody Servicio c){
        servis.saveServicio(c);
        return "Servicio creado";
    }
    @GetMapping("/Servicio/encontrar/{id_servicio}")
    public Servicio findServicio(@PathVariable Long id_servicio){
        return servis.findServicio(id_servicio);
    }
    @DeleteMapping("/Servicio/eliminar/{id_servicio}")
     public String deleteServicio(@PathVariable Long id_servicio){
       servis.deleteServicio(id_servicio);
       return "Servicio eliminado";
    }
     @PutMapping("/Servicio/editar/{id_servicio}")
     public Servicio editServicio(@PathVariable Long id_servicio,
             @RequestParam(required=false,name="nombre_servicio")String newname,
            @RequestParam(required=false, name="nroEtapas")Long nroEtapas){
         
               servis.editServicio(id_servicio, newname, nroEtapas);
               Servicio c=this.findServicio(id_servicio);
               return c;
}
     @PutMapping("/Servicio/editarII")
     public Servicio editServicioII(@RequestBody Servicio c)
     {
         servis.editServicioII(c);
         return servis.findServicio(c.getId());
     }
}
 