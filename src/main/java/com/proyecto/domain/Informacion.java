package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="informacion")

public class Informacion implements Serializable{
    private static final long serialVersionUID=1L;  /*asigna automaticamente el numero de id de los clientes*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona; 
    private String correo;


    public Informacion() {
    }

    public Informacion( String correo) {
 
        this.correo = correo;
    } 
}
