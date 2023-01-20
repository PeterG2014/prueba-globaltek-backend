package com.globaltek.springboot.backend.apirest.models.services;

import com.globaltek.springboot.backend.apirest.models.entity.ProductoEntity;

public interface ProductoServicesInterface {
	public ProductoEntity loadProducto(String producto);
}
