package com.proyecto.service;

import com.proyecto.domain.Reclamo;
import java.util.List;

public interface ReclamoService {
     //Obtiene una lista de registro de la tabla de reclamos y lo coloca en una 
    //lista de objetos reclamo
    
    public List<Reclamo> getReclamo();
    
    
    //obtiene el registro de la tabla reclamo
    //que tiene el idReclamo pasado por el reclamo
    public Reclamo getReclamo(Reclamo reclamo);
    
    
     //elimina el registro de la tabla reclamo
    //que tiene el idReclamo pasado por el reclamo 
    public void deleteReclamo(Reclamo reclamo);
    
    
    
    //si el idreclamo pasado no existe o es nulo se crea un registro nuevo
    //en la tabla reclamo 
    // si el id reclamo existe se actualiza la reclamo
    public void saveReclamo(Reclamo reclamo);
}