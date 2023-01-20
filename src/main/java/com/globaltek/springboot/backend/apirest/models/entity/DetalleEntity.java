package com.globaltek.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle")
public class DetalleEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "factura"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_factura")
	private FacturaEntity factura;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "producto"})
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private ProductoEntity producto;
	
	
	@Column(nullable=false)
	private Integer cantidad;

	@Column(name="precio_unitario", nullable=false)
	private Long precioUnitario;
	
	//getter and setter

	public Long getId() {
		return id;
	}

	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Long precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public FacturaEntity getFactura() {
		return factura;
	}


	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	private static final long serialVersionUID = 1L;
}
