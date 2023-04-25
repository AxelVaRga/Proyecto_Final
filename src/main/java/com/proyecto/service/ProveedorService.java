package com.proyecto.service;

import com.proyecto.domain.Proveedor;
import java.util.List;

public interface ProveedorService {
    public List<Proveedor> getProveedors(boolean estado);
    
    
    //obtiene el registro de la tabla proveedor
    //que tiene el idProveedor pasado por el proveedor
    public Proveedor getProveedor(Proveedor proveedor);
    
    
     //elimina el registro de la tabla proveedor
    //que tiene el idProveedor pasado por el proveedor 
    public void deleteProveedor(Proveedor proveedor);
    
    
    
    //si el idproveedor pasado no existe o es nulo se crea un registro nuevo
    //en la tabla proveedor 
    // si el id proveedor existe se actualiza la informacion
    public void saveProveedor(Proveedor proveedor);
}