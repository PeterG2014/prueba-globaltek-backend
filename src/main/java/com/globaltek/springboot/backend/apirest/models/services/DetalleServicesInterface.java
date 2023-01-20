package com.globaltek.springboot.backend.apirest.models.services;

import java.util.List;

import com.globaltek.springboot.backend.apirest.models.entity.DetalleEntity;
import com.globaltek.springboot.backend.apirest.models.entity.FacturaEntity;
import com.globaltek.springboot.backend.apirest.models.entity.ProductoEntity;

public interface DetalleServicesInterface {
	
	public List<DetalleEntity> findAll();
	
	public DetalleEntity save(DetalleEntity question);
	
	public DetalleEntity findById(Long id);
	
	public void delete(Long id);
	
	public List<ProductoEntity> findAllProducto();
	
	public List<FacturaEntity> findAllFactura();
	
}
