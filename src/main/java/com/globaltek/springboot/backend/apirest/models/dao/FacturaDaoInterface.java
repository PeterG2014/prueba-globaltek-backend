package com.globaltek.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.globaltek.springboot.backend.apirest.models.entity.*;

public interface FacturaDaoInterface extends CrudRepository<FacturaEntity, Long>{

	@Query("from FacturaEntity")
	public List<FacturaEntity> findAllFactura();
	
}
