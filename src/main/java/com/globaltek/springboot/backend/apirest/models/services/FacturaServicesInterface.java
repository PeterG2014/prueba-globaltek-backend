package com.globaltek.springboot.backend.apirest.models.services;


import java.util.List;

import com.globaltek.springboot.backend.apirest.models.entity.FacturaEntity;

public interface FacturaServicesInterface {
	
	public List<FacturaEntity> findAll();
	
	public void delete(Long id);
	
	public FacturaEntity findById(Long id);
	
	public FacturaEntity save(FacturaEntity factura);
	
}
