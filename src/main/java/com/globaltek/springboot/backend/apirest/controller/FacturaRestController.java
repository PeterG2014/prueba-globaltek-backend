package com.globaltek.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globaltek.springboot.backend.apirest.constants.EnumConstantsApi;
import com.globaltek.springboot.backend.apirest.models.entity.FacturaEntity;
import com.globaltek.springboot.backend.apirest.models.services.FacturaServicesInterface;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController()
@RequestMapping("/api")
public class FacturaRestController {

	@Autowired
	private FacturaServicesInterface facturaService;
	
	private final Logger log = LoggerFactory.getLogger(FacturaRestController.class);
	
	@GetMapping("/facturas")
	public List<FacturaEntity> index(){
		log.info("mostrando la informacion de las facruras");
		return this.facturaService.findAll();
	}
	
	@GetMapping("/factura/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		FacturaEntity factura = null;
		Map<String, Object> response = new HashMap<>();
		try {
			factura = this.facturaService.findById(id);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar la consulta : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (Objects.isNull(factura)) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "La factura con ID: ".concat(id.toString().concat("No existe en base de datos")));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(factura, HttpStatus.OK);
	}
	
	@PostMapping("/create-factura")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody FacturaEntity factura, BindingResult result){
		FacturaEntity facturaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo '"+ error.getField() +"' " + error.getDefaultMessage()).collect(Collectors.toList());
			
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			facturaNew = this.facturaService.save(factura);
		}catch(DataAccessException e) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar el Insert : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Cliente creado con exito");
		response.put(EnumConstantsApi.ST_STUDENT_JSON.getValue(), facturaNew);
		
		return new ResponseEntity<>( response, HttpStatus.CREATED);
	}
	
	@PutMapping("/factura/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody FacturaEntity factura,BindingResult result,  @PathVariable Long id) {
		System.out.println(factura);
		FacturaEntity facturaNow = facturaService.findById(id);
		FacturaEntity facturaUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo '"+ error.getField() +"' " + error.getDefaultMessage()).collect(Collectors.toList());
			
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (facturaNow == null) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error no se pudo editar con ID: ".concat(id.toString()));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
				
			facturaNow.setNombreCliente(factura.getNombreCliente());
			facturaNow.setNumeroFactura(factura.getNumeroFactura());
			facturaNow.setFecha(factura.getFecha());
			facturaNow.setTipoDePago(factura.getTipoDePago());
			facturaNow.setNombreCliente(factura.getNombreCliente());
			facturaUpdate = facturaService.save(facturaNow);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar la consulta : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Cliente actualizado con exito");
		response.put(EnumConstantsApi.ST_STUDENT_JSON.getValue(), facturaUpdate);
	
		
		return new ResponseEntity<>( response, HttpStatus.CREATED); 
		
	}
	 

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		FacturaEntity student = this.facturaService.findById(id);
		try{
			if(Objects.nonNull(student)) this.facturaService.delete(id);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al eliminar al estudiante : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "cliente eliminado con exito");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
