/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Controller;

import com.madeTUP.AppSpa.DTO.NewSesionDTO;
import com.madeTUP.AppSpa.DTO.SesionPersonalDTO;
import com.madeTUP.AppSpa.Model.Cliente;
import com.madeTUP.AppSpa.Model.Servicio;
import com.madeTUP.AppSpa.Model.Sesion;
import com.madeTUP.AppSpa.Service.IClienteService;
import com.madeTUP.AppSpa.Service.IServicioService;
import com.madeTUP.AppSpa.Service.ISesionService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class SesionController {
    @Autowired 
    private ISesionService servis;
     @Autowired 
    private IServicioService servis1;
     @Autowired 
    private IClienteService servis2;

    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PutMapping("/Sesion/cancelarAsistencia/{id}")
    public ResponseEntity<?> cancelarAsistencia(@PathVariable Long id) {
        boolean success = servis.cancelarAsistencia(id);  // Asegúrate de pasar el ID
        if (success) {
            return ResponseEntity.ok().body(Map.of("success", true));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("success", false));
        }
    }


    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping ("/Sesion/MostrarFecha")
    public List<SesionPersonalDTO> getSesionesPorFecha(@RequestParam("fecha") String fecha) {
        LocalDate localDate = LocalDate.parse(fecha);
        // Aquí se consulta la base de datos por las sesiones de la fecha dada
        List<SesionPersonalDTO> sesiones = servis.getSesionFecha(localDate);
        return sesiones;
    }
     @GetMapping("/Sesion/traer")
    public List<Sesion> getSesion(){
        return servis.getServicio();
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PostMapping("/Sesion/crear")    
    public String crearSesion(@RequestBody Sesion c){
        servis.saveSesion(c);
        return "Sesion creada";
    }
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PostMapping("/Sesion/crearDos")    
    public String crearSesionDTO(@RequestBody NewSesionDTO se){
        Sesion sesion= new Sesion();
        Cliente c= servis2.findCliente(se.getId_Cliente());
        sesion.setCliente(c);
        Servicio s=servis1.findServicio(se.getId_Servicio());
        sesion.setServicio(s);
        LocalDate fecha=LocalDate.parse(se.getFecha());
        sesion.setFecha(fecha);
        sesion.setAsistencia(se.getAsistencia());
       sesion.setCosto(se.getCosto());
       
        servis.saveSesion(sesion);
        return "Sesion creada";
    }
       @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/Sesion/encontrar/{id_sesion}")
    public Sesion findSesion(@PathVariable Long id_sesion){
        return servis.findSesion(id_sesion);
    }
    @DeleteMapping("/Sesion/eliminar/{id_sesion}")
     public String deleteSesion(@PathVariable Long id_sesion){
       servis.deleteSesion(id_sesion);
       return "Sesion eliminado";
    }
     @PutMapping("/Sesion/editar/{id_sesion}")
     public Sesion editSesion(@PathVariable Long id_sesion,
             @RequestParam(required=false,name="servicio")Servicio servicio,
            @RequestParam(required=false, name="cliente")Cliente cliente,
            @RequestParam(required=false,name="fecha")LocalDate fecha,
           @RequestParam(required=false,name="costo")Double costo,
            @RequestParam(required=false,name="asistencia") int asistencia){
         
               servis.editSesion(id_sesion, servicio, cliente, fecha, costo, asistencia);
               Sesion c=this.findSesion(id_sesion);
               return c;
}
     @PutMapping("/Sesion/editarII")
     public Sesion editSesionII(@RequestBody Sesion c)
     {
         servis.editSesionII(c);
         return servis.findSesion(c.getId());
     }
     
     
    
}
 
    