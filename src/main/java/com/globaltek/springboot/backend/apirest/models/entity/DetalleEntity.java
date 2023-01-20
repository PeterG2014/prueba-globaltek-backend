package com.globaltek.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle")
public class DetalleEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_factura", nullable=false)
	private Integer idFactura;
	
	@Column(name="id_producto", nullable=false)
	private Integer idProducto;
	
	@Column(nullable=false)
	private Integer cantidad;

	@Column(name="precio_unitario", nullable=false)
	private Float precioUnitario;
	
	@JsonIgnoreProperties({"exam", "hibernateLazyInitializer", "handler",})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="exam", cascade=CascadeType.ALL)
	private List<ProductoEntity> question;
	
	@JsonIgnoreProperties({"exam", "hibernateLazyInitializer", "handler",})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="exam", cascade=CascadeType.ALL)
	private List<FacturaEntity> student;
	
	//construct
	public DetalleEntity() {
		this.question = new ArrayList<>();
		this.student = new ArrayList<>();
	}
	
	//getter and setter

	
	
	
	
	public Long getId() {
		return id;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FacturaEntity> getStudent() {
		return student;
	}

	public void setStudent(List<FacturaEntity> student) {
		this.student = student;
	}

	public List<ProductoEntity> getQuestion() {
		return this.question;
	}

	public void setQuestion(List<ProductoEntity> question) {
		this.question = question;
	}

	private static final long serialVersionUID = 1L;
}
