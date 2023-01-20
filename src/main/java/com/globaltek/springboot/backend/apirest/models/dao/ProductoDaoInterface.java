package com.globaltek.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.globaltek.springboot.backend.apirest.models.entity.ProductoEntity;

public interface ProductoDaoInterface extends CrudRepository<ProductoEntity, Long> {

	public ProductoEntity findByProducto(String product);
}
