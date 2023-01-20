package com.globaltek.springboot.backend.apirest.models.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="facturas")
public class FacturaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final int IVA = 19;
	private static final int CIEN = 100; 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable=false)
	@Size(min=4, max=21)
	private String numeroFactura; 
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="tipo_de_pago", nullable=false)
	@Size(min=4, max=21)
	private String tipoDePago;

	@Column(name="nombre_cliente", nullable=false)
	private String nombreCliente;
	
	@Column(nullable=false)
	private Integer subtotal;
	
	@Column(nullable=false)
	private Integer descuento;
	
	@Column(nullable=false)
	private Integer iva;
	
	@Column(name="total_descuento", nullable=false)
	private Integer totalDescuento;
	
	@Column(name="total_impuesto", nullable=false)
	private Integer totalImpuesto;
	
	@Column(nullable=false)
	private Integer total;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "exam"})
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="exam_id")
	private DetalleEntity exam;
	
	private String photo;

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoDePago() {
		return tipoDePago;
	}

	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva() {
		this.iva = IVA;
	}

	public Integer getTotalDescuento() {
		return totalDescuento;
	}

	public void setTotalDescuento(Integer totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

	public Integer getTotalImpuesto() {
		return totalImpuesto;
	}

	public void calcularTotalImpuesto(int total) {
		this.totalImpuesto = total * IVA / CIEN;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public DetalleEntity getExam() {
		return exam;
	}

	public void setExam(DetalleEntity exam) {
		this.exam = exam;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	//getter and setter
}
