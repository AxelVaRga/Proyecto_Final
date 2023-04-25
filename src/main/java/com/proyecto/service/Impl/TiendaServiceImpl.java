package com.proyecto.service.Impl;

import com.proyecto.dao.TiendaDao;
import com.proyecto.domain.Tienda;
import com.proyecto.service.TiendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaServiceImpl implements TiendaService{
  
    //Esto crea una unica copia en un objeto //
    @Autowired
    public TiendaDao tiendaDao;
    
    @Override
    public List<Tienda> getTiendas(boolean estado) {
      
       var lista=(List<Tienda>) tiendaDao.findAll();
       
       if(estado){
           lista.removeIf(e -> !e.isEstado());
       }
       return lista;
    }

    @Override
    public Tienda gettienda(Tienda tienda) {
       return tiendaDao.findById(tienda.getIdTienda()).orElse(null);
    }

    @Override
    public void deletetienda(Tienda tienda) {
        tiendaDao.delete(tienda);
       
    }

    @Override
    public void savetienda(Tienda tienda) {
        tiendaDao.save(tienda);
    }
}