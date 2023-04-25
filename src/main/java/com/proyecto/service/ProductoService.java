package com.proyecto.service;

import com.proyecto.domain.Producto;
import java.util.List;

public interface ProductoService {
      //Obtiene una lista de registro de la tabla de productos y lo coloca en una 
    //lista de objetos producto
    
    public List<Producto> getProductos(boolean estado);
    
    
    //obtiene el registro de la tabla producto
    //que tiene el idProducto pasado por el producto
    public Producto getProducto(Producto producto);
    
    
     //elimina el registro de la tabla producto
    //que tiene el idProducto pasado por el producto 
    public void deleteProducto(Producto producto);
    
    
    
    //si el idproducto pasado no existe o es nulo se crea un registro nuevo
    //en la tabla producto 
    // si el id producto existe se actualiza la informacion
    public void saveProducto(Producto producto);
}