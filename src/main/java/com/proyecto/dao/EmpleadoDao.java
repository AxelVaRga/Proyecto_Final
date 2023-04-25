package com.proyecto.dao;

import com.proyecto.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository<Empleado,Long>{
    
}
