package com.globaltek.springboot.backend.apirest.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltek.springboot.backend.apirest.models.dao.ProductoDaoInterface;
import com.globaltek.springboot.backend.apirest.models.entity.ProductoEntity;

@Service
public class ProductoServicesImpl implements ProductoServicesInterface {

	private ProductoDaoInterface productoDao;
	
	@Override
	@Transactional(readOnly=true)
	public ProductoEntity loadProducto(String producto) {
		return this.productoDao.findByProducto(producto);
	}
}
