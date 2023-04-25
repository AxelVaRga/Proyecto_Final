package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
    private static final long serialVersionUID=1L;  /*asigna automaticamente el numero de id de los clientes*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor; 
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    private String marca;
    private String nacionalidad;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(String nombre, String apellidos, String correo, int telefono, String marca, String nacionalidad, boolean estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.marca = marca;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
    }
}