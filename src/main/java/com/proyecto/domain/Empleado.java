package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID=1L;  /*asigna automaticamente el numero de id de los clientes*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado; 
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    private double salario;
    private String puesto;
    private String nacionalidad;
    private boolean estado;
    
    @JoinColumn(name="id_tienda", referencedColumnName="id_tienda")
    @ManyToOne
    
    private Tienda tienda;

    public Empleado() {
    }

    public Empleado(Long idEmpleado, String nombre, String apellidos, String correo, int telefono, double salario, String puesto, String nacionalidad, boolean estado, Tienda tienda) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.salario = salario;
        this.puesto = puesto;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
        this.tienda = tienda;
    }
}
