package com.proyecto.service.Impl;

import com.proyecto.dao.ProductoDao;
import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    //Esto crea una unica copia en un objeto //
    @Autowired
    public ProductoDao productoDao;
    
    @Override
    public List<Producto> getProductos(boolean estado) {
     
        var lista=(List<Producto>) productoDao.findAll();
       
       if(estado){
           lista.removeIf(e -> !e.isEstado());
       }
       return lista;
    }
    
    @Override
    public Producto getProducto(Producto producto) {
       return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
       
    }

    @Override
    public void saveProducto(Producto producto) {
        productoDao.save(producto);
    }
}