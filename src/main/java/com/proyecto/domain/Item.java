package com.proyecto.domain;

import lombok.Data;

@Data
public class Item extends  Producto{
    private int cantidad; //Almacenar la cantidad de items de un producto

    public Item() {
    }

    public Item(Producto producto) {
        super.setIdProducto(producto.getIdProducto());
        super.setImagen(producto.getImagen());
        super.setNombre(producto.getNombre());
        super.setExistencias(producto.getExistencias());
        super.setEstado(producto.isEstado());
        super.setPrecio(producto.getPrecio());
     
        this.cantidad = 0;
    }
}
