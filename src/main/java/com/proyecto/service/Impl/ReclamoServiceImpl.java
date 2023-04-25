package com.proyecto.service.Impl;

import com.proyecto.dao.ReclamoDao;
import com.proyecto.domain.Reclamo;
import com.proyecto.service.ReclamoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamoServiceImpl implements ReclamoService{
  
    //Esto crea una unica copia en un objeto //
    @Autowired
    public ReclamoDao reclamodao;
    
    @Override
    public List<Reclamo> getReclamo() {
       return (List<Reclamo>) reclamodao.findAll();
    }

    @Override
    public Reclamo getReclamo(Reclamo reclamo) {
       return reclamodao.findById(reclamo.getIdCliente()).orElse(null);
    }

    @Override
    public void deleteReclamo(Reclamo reclamo) {
        reclamodao.delete(reclamo);
       
    }

    @Override
    public void saveReclamo(Reclamo reclamo) {
        reclamodao.save(reclamo);
    }
}