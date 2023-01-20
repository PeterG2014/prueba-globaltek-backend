package com.globaltek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.globaltek.springboot.backend.apirest.models.dao.FacturaDaoInterface;
import com.globaltek.springboot.backend.apirest.models.entity.FacturaEntity;

@Service
@ComponentScan
public class FacturaServicesImpl implements FacturaServicesInterface{

	@Autowired
	private FacturaDaoInterface facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<FacturaEntity> findAll() {
		return (List<FacturaEntity>) this.facturaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public FacturaEntity findById(Long id) {
		return this.facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public FacturaEntity save(FacturaEntity student) {
		return facturaDao.save(student);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		this.facturaDao.deleteById(id);
	}
}
