package com.proyecto.service.Impl;

import com.proyecto.dao.ProveedorDao;
import com.proyecto.domain.Proveedor;
import com.proyecto.service.ProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService{
  
    //Esto crea una unica copia en un objeto //
  @Autowired
    public ProveedorDao proveedorDao;
    
    @Override
    public List<Proveedor> getProveedors(boolean estado) {
      
       var lista=(List<Proveedor>) proveedorDao.findAll();
       
       if(estado){
           lista.removeIf(e -> !e.isEstado());
       }
       return lista;
    }

    @Override
    public Proveedor getProveedor(Proveedor proveedor) {
       return proveedorDao.findById(proveedor.getIdProveedor()).orElse(null);
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
        proveedorDao.delete(proveedor);
       
    }

    @Override
    public void saveProveedor(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }   
}