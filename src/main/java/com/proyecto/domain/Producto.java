package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")

public class Producto implements Serializable {
    private static final long serialVersionUID=1L;  /*asigna automaticamente el numero de id de los clientes*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto; 
    private String nombre;
    private String imagen;
    private double precio;
    private int existencias;
    private boolean estado;
    

    public Producto() {
    }

    public Producto(String nombre, String imagen, double precio, int existencias, boolean estado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.existencias = existencias;
        this.estado = estado;
    }
}
