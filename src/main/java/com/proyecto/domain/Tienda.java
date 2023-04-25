package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="tienda")
public class Tienda implements Serializable{
    private static final long serialVersionUID=1L;  /*asigna automaticamente el numero de id de los clientes*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tienda")
    private Long idTienda;
    
    private String localidad;
    private boolean estado;

    public Tienda() {
    }

    public Tienda(String localidad, boolean estado) {
        this.localidad = localidad;
        this.estado = estado;
    }
}