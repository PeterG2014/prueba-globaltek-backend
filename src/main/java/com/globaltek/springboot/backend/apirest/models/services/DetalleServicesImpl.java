package com.globaltek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltek.springboot.backend.apirest.models.dao.DetalleDaoInterface;
import com.globaltek.springboot.backend.apirest.models.entity.DetalleEntity;
import com.globaltek.springboot.backend.apirest.models.entity.FacturaEntity;
import com.globaltek.springboot.backend.apirest.models.entity.ProductoEntity;

@Service
@ComponentScan
public class DetalleServicesImpl implements DetalleServicesInterface {

	@Autowired
	private DetalleDaoInterface detalleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleEntity> findAll() {
		return (List<DetalleEntity>) this.detalleDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public DetalleEntity findById(Long id) {
		return this.detalleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetalleEntity save(DetalleEntity exam) {
		return detalleDao.save(exam);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		this.detalleDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoEntity> findAllProducto() {
		return this.detalleDao.findAllProducto();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FacturaEntity> findAllFactura() {
		return this.detalleDao.findAllFactura();
	}

}
