package com.proyecto.service;

import com.proyecto.domain.Tienda;
import java.util.List;

public interface TiendaService {
       //Obtiene una lista de registro de la tabla de Tiendas y lo coloca en una 
    //lista de objetos Tienda
    public List<Tienda> getTiendas(boolean estado);
    
    
    //obtiene el registro de la tabla Tienda
    //que tiene el idtienda pasado por el Tienda
    public Tienda gettienda(Tienda tienda);
    
    
     //elimina el registro de la tabla Tienda
    //que tiene el idtienda pasado por el Tienda 
    public void deletetienda(Tienda tienda);
    
    
    
    //si el idTienda pasado no existe o es nulo se crea un registro nuevo
    //en la tabla Tienda 
    // si el id Tienda existe se actualiza la informacion
    public void savetienda(Tienda tienda);
}