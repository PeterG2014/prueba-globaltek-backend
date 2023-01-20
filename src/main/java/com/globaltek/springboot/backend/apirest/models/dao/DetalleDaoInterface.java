package com.globaltek.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.globaltek.springboot.backend.apirest.models.entity.DetalleEntity;
import com.globaltek.springboot.backend.apirest.models.entity.FacturaEntity;
import com.globaltek.springboot.backend.apirest.models.entity.ProductoEntity;

public interface DetalleDaoInterface extends CrudRepository<DetalleEntity, Long>{

	@Query("from DetalleEntity")
	public List<DetalleEntity> findAllDetalle();
	
	@Query("from FacturaEntity")
	public List<FacturaEntity> findAllFactura();
	
	@Query("from ProductoEntity")
	public List<ProductoEntity> findAllProducto();
	
}
