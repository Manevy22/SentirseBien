/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Controller;

import com.madeTUP.AppSpa.DTO.ClienteLoginDTO;
import com.madeTUP.AppSpa.DTO.SesionPersonalDTO;
import com.madeTUP.AppSpa.DTO.PersonalPerfilDTO;
import com.madeTUP.AppSpa.Model.Personal;
import com.madeTUP.AppSpa.Model.Servicio;
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
//     @PutMapping("/Personal/editar/{id_personal}")
//     public Personal editPersonal(@PathVariable Long id_personal,
//             @RequestParam(required=false,name="nombre_usuario")String newname,
//           @RequestParam(required=false,name="contrasenia")String newcontrasenia){
//         
//               servis.editPersonal(id_personal, newname, newcontrasenia);
//               Personal c=this.findPersonal(id_personal);
//               return c;
//}
     @PutMapping("/Personal/editarII")
     public Personal editPersonalII(@RequestBody Personal c)
     {
         servis.editPersonalII(c);
         return servis.findPersonal(c.getId());
     }
@PostMapping("/Personal/login")
public ResponseEntity<Map<String, Object>> loginPersonal(@RequestBody ClienteLoginDTO pers) {
    List<Personal> listaPersonal = servis.getPersonal();
    for (Personal personal : listaPersonal) {
        if (personal.getNombre_usuario().equals(pers.getUsername()) || personal.getCorreo().equals(pers.getUsername())) {
            if (personal.getContrasenia().equals(pers.getPassword())) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Inicio de sesión exitoso.");
                response.put("personalId", personal.getId()); // Devolver el ID del personal
                response.put("nombre_usuario", personal.getNombre_usuario());//Devolver nombre
                return ResponseEntity.ok(response);
            }
        }
    }
    Map<String, Object> response = new HashMap<>();
    response.put("success", false);
    response.put("message", "Nombre de usuario o contraseña incorrectos.");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
}

@GetMapping("/personal/perfil")
public ResponseEntity<PersonalPerfilDTO> getPerfilPersonal(@RequestParam Long PersonalId) {
    // Buscar al personal por su ID
    Personal personal1 = servis.findPersonal(PersonalId);
    
    if (personal1 == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Manejar caso de no encontrar al personal
    }

    // Crear el DTO para el perfil del personal
    PersonalPerfilDTO perfilDTO = new PersonalPerfilDTO();
    perfilDTO.setId(PersonalId);
    perfilDTO.setNombre_usuario(personal1.getNombre_usuario());

    List<SesionPersonalDTO> listaSesionesDos = new ArrayList<>();
    
    // Si el personal es la Dra. Felicidad (id = 1), tiene acceso a todas las sesiones
    if (PersonalId == 1) {
        // Obtener todas las sesiones
        List<Sesion> todasSesiones = servisSesion.getServicio();
        
        // Convertir cada sesión a SesionPersonalDTO y agregarla a la lista
        for (Sesion sesion : todasSesiones) {
            SesionPersonalDTO s = new SesionPersonalDTO(
                sesion.getId(),
                sesion.getCliente().getId(),
                sesion.getCliente().getNombre(),
                sesion.getServicio().getNombreServicio(),
                sesion.getFecha(),
                sesion.getCosto(),
                sesion.getAsistencia()
            );
            listaSesionesDos.add(s);
        }
    } else {
        // Obtener las sesiones que coincidan con los servicios que presta el personal
        List<Sesion> listaSesiones = servisSesion.getServicio(); // O consulta optimizada

        for (Sesion sesion : listaSesiones) {
            for (Servicio servi : personal1.getListaServicio()) {
                if (sesion.getServicio().getId().equals(servi.getId())) { // Usar equals en lugar de ==
                    SesionPersonalDTO s = new SesionPersonalDTO(
                        sesion.getId(),
                        sesion.getCliente().getId(),
                        sesion.getCliente().getNombre(),
                        sesion.getServicio().getNombreServicio(),
                        sesion.getFecha(),
                        sesion.getCosto(),
                        sesion.getAsistencia()
                    );
                    listaSesionesDos.add(s);
                    break; // Salir del bucle interno cuando se encuentra el servicio
                }
            }
        }
    }

    // Añadir las sesiones al perfil del personal
    perfilDTO.setListaPer_Ses(listaSesionesDos);

    return ResponseEntity.ok(perfilDTO);
}

}
 
