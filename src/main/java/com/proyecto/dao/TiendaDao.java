package com.proyecto.dao;

import com.proyecto.domain.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaDao extends JpaRepository<Tienda,Long>{
    
}
