package com.proyecto.dao;

import com.proyecto.domain.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorDao extends JpaRepository<Proveedor,Long>{
    
}
