/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Controller;

import com.madeTUP.AppSpa.DTO.ClienteLoginDTO;
import com.madeTUP.AppSpa.DTO.SesionPersonalDTO;
import com.madeTUP.AppSpa.DTO.PersonalPerfilDTO;
import com.madeTUP.AppSpa.DTO.SesionDTO;
import com.madeTUP.AppSpa.Model.Personal;
import com.madeTUP.AppSpa.Model.Sesion;
import com.madeTUP.AppSpa.Service.IPersonalService;
import com.madeTUP.AppSpa.Service.ISesionService;
import java.util.ArrayList;
import java.util.HashMap;
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
public class PersonalController {
    @Autowired
    private IPersonalService servis;
    @Autowired
    private ISesionService servisSesion;
    
    
     @GetMapping("/Personal/traer")
    public List<Personal> getPersonal(){
        return servis.getPersonal();
    }
    
    @PostMapping("/Personal/crear")
    public String crearPersonal(@RequestBody Personal c){
        servis.savePersonal(c);
        return "Personal creado";
    }
    @GetMapping("/Personal/encontrar/{id_personal}")
    public Personal findPersonal(@PathVariable Long id_personal){
        return servis.findPersonal(id_personal);
    }
    @DeleteMapping("/Personal/eliminar/{id_personal}")
     public String deletePersonal(@PathVariable Long id_personal){
       servis.deletePersonal(id_personal);
       return "Personal eliminado";
    }
     @PutMapping("/Personal/editar/{id_personal}")
     public Personal editPersonal(@PathVariable Long id_personal,
             @RequestParam(required=false,name="nombre_usuario")String newname,
           @RequestParam(required=false,name="contrasenia")String newcontrasenia){
         
               servis.editPersonal(id_personal, newname, newcontrasenia);
               Personal c=this.findPersonal(id_personal);
               return c;
}
     @PutMapping("/Personal/editarII")
     public Personal editPersonalII(@RequestBody Personal c)
     {
         servis.editPersonalII(c);
         return servis.findPersonal(c.getId());
     }
   @CrossOrigin(origins = "http://127.0.0.1:8080")
@PostMapping("/Personal/login")
public ResponseEntity<Map<String, Object>> loginPersonal(@RequestBody ClienteLoginDTO pers) {
    List<Personal> listaPersonal = servis.getPersonal();
    for (Personal personal : listaPersonal) {
        if (personal.getNombre_usuario().equals(pers.getUsername())) {
            if (personal.getContrasenia().equals(pers.getPassword())) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Inicio de sesión exitoso.");
                response.put("personalId", personal.getId()); // Devolver el ID del personal
                return ResponseEntity.ok(response);
            }
        }
    }
    Map<String, Object> response = new HashMap<>();
    response.put("success", false);
    response.put("message", "Nombre de usuario o contraseña incorrectos.");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
}

@CrossOrigin(origins = "http://127.0.0.1:8080")
@GetMapping("/personal/perfil")
    public ResponseEntity<PersonalPerfilDTO> getPerfilPersonal(@RequestParam Long PersonalId) {
        //creo un Personal que le pasa datos basicos a PERSONALDTO
        Personal personal1= servis.findPersonal(PersonalId);
        PersonalPerfilDTO perfilDTO = new PersonalPerfilDTO();
        perfilDTO.setId(PersonalId);
        perfilDTO.setNombre_usuario(personal1.getNombre_usuario());
        
        //Traigo todas las sesiones de la BD
        List<Sesion> lista= servisSesion.getServicio();
       List<SesionPersonalDTO> listaSesionesDos= new ArrayList<>();
        
        for(Sesion sesion : lista){
           SesionPersonalDTO s= new SesionPersonalDTO(sesion.getId(),sesion.getCliente().getId(),sesion.getCliente().getNombre(),sesion.getServicio().getNombreServicio(),sesion.getFecha(),sesion.getCosto(),sesion.getAsistencia());
           listaSesionesDos.add(s);
        }
        perfilDTO.setListaPer_Ses(listaSesionesDos);
        return ResponseEntity.ok(perfilDTO);
    }
}
 