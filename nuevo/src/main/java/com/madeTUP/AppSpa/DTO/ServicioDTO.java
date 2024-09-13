package com.madeTUP.AppSpa.DTO;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Virginia
 */
@Getter @Setter
public class ServicioDTO {
    private Long id;
    private String nombreServicio;

    public ServicioDTO(){}
    public ServicioDTO(Long id,String nombreServicio){
        this.id=id;
        this.nombreServicio=nombreServicio;

    }


    // Getter para id
    public Long getId() {
        return id;
    }

    // Setter para id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para nombre_servicio
    public String getNombre_servicio() {
        return nombreServicio;
    }

    // Setter para nombre_servicio
    public void setNombre_servicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

}
