package com.proyecto.dao;

import com.proyecto.domain.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacionDao extends JpaRepository<Informacion,Long> {  
}
