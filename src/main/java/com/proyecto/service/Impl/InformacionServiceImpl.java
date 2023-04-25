package com.proyecto.service.Impl;

import com.proyecto.dao.InformacionDao;
import com.proyecto.domain.Informacion;
import com.proyecto.service.InformacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service /*Se utiliza para que sea visible en el controlador */

public class InformacionServiceImpl implements InformacionService{
  
    //Esto crea una unica copia en un objeto //
    @Autowired
    public InformacionDao informaciondao;
    
    @Override
    public List<Informacion> getInformacion() {
       return (List<Informacion>) informaciondao.findAll();
    }

    @Override
    public Informacion getInformacion(Informacion informacion) {
       return informaciondao.findById(informacion.getIdPersona()).orElse(null);
    }

    @Override
    public void deleteInformacion(Informacion informacion) {
        informaciondao.delete(informacion);
       
    }

    @Override
    public void saveInformacion(Informacion informacion) {
        informaciondao.save(informacion);
    }
}