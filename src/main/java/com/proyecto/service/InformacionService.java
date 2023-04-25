package com.proyecto.service;

import com.proyecto.domain.Informacion;
import java.util.List;

public interface InformacionService {
  
    //Obtiene una lista de registro de la tabla de informacions y lo coloca en una 
    //lista de objetos informacion
    
    public List<Informacion> getInformacion();
    
    
    //obtiene el registro de la tabla informacion
    //que tiene el idInformacion pasado por el informacion
    public Informacion getInformacion(Informacion informacion);
    
    
     //elimina el registro de la tabla informacion
    //que tiene el idInformacion pasado por el informacion 
    public void deleteInformacion(Informacion informacion);
    
    
    
    //si el idinformacion pasado no existe o es nulo se crea un registro nuevo
    //en la tabla informacion 
    // si el id informacion existe se actualiza la informacion
    public void saveInformacion(Informacion informacion);
}