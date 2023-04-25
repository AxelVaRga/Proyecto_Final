package com.proyecto.service.Impl;

import com.proyecto.dao.EmpleadoDao;
import com.proyecto.dao.TiendaDao;
import com.proyecto.domain.Empleado;
import com.proyecto.domain.Tienda;
import com.proyecto.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
  
    //Esto crea una unica copia en un objeto //
  @Autowired
    public EmpleadoDao empleadoDao;
   @Autowired
    public TiendaDao tiendaDao;
    
    @Override
    public List<Empleado> getEmpleados(boolean estado) {
      
       var lista=(List<Empleado>) empleadoDao.findAll();
       
       if(estado){
           lista.removeIf(e -> !e.isEstado());
       }
       return lista;
    }

    @Override
    public Empleado getEmpleado(Empleado empleado) {
       return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoDao.delete(empleado);
       
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        
        Tienda tienda=empleado.getTienda();
        tienda=tiendaDao.save(tienda);
        empleado.setTienda(tienda);
        empleadoDao.save(empleado);
    }
}