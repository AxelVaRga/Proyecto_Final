package com.proyecto.service;

import com.proyecto.domain.Empleado;
import java.util.List;

public interface EmpleadoService {
     public List<Empleado> getEmpleados(boolean estado);
    
    
    //obtiene el registro de la tabla empleado
    //que tiene el idEmpleado pasado por el empleado
    public Empleado getEmpleado(Empleado empleado);
    
    
     //elimina el registro de la tabla empleado
    //que tiene el idEmpleado pasado por el empleado 
    public void deleteEmpleado(Empleado empleado);
    
    
    
    //si el idempleado pasado no existe o es nulo se crea un registro nuevo
    //en la tabla empleado 
    // si el id empleado existe se actualiza la informacion
    public void saveEmpleado(Empleado empleado);
}