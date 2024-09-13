    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.madeTUP.AppSpa.Model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String nombre_usuario;
    @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sesion> listaSesiones;
    @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> listaConsultas;
@ManyToMany
    @JoinTable(name = "cliente_servicio", joinColumns = @JoinColumn(name = "cliente_id"),inverseJoinColumns = @JoinColumn(name = "servicio_id"))
            private List<Servicio> listaServicio;
    

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellido, String correo, String contrasenia, String nombre_usuario, List<Sesion> listaSesiones, List<Consulta> listaConsultas, List<Servicio> listaServicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombre_usuario = nombre_usuario;
        this.listaSesiones = listaSesiones;
        this.listaConsultas = listaConsultas;
        this.listaServicio = listaServicio;
    }
    public void setear_Ses_Cons()
    {
        for(Sesion sesion:listaSesiones){
            sesion.setCliente(this);
        }
        for(Consulta consulta:listaConsultas){
            consulta.setCliente(this);
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    // Getters y Setters para listaSesiones
    public List<Sesion> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(List<Sesion> listaSesiones) {
        this.listaSesiones = listaSesiones;
    }

    // Getters y Setters para listaConsultas
    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    // Getters y Setters para listaServicio
    public List<Servicio> getListaServicio() {
        return listaServicio;
    }

    public void setListaServicio(List<Servicio> listaServicio) {
        this.listaServicio = listaServicio;
    }
}
