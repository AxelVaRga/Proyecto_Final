package com.proyecto.dao;

import com.proyecto.domain.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoDao extends JpaRepository<Reclamo,Long>{
    
    
}
