package com.globaltek.springboot.backend.apirest.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="factura")
public class FacturaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final int IMPUESTO = 19;
	private static final int CIEN = 100; 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable=false, name="numero_factura")
	private Long numeroFactura; 
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="tipo_de_pago", nullable=false)
	@Size(min=4, max=21)
	private String tipoDePago;
	
	@Column(name="documento_cliente", nullable=false)
	private Long documentoCliente;

	@Column(name="nombre_cliente", nullable=false)
	private String nombreCliente;
	
	@Column(nullable=false)
	private Long subtotal;
	
	@Column(nullable=false)
	private Integer descuento;
	
	@Column(nullable=false)
	private Integer iva;
	
	@Column(name="total_descuento", nullable=false)
	private Double totalDescuento;
	
	@Column(name="total_impuesto", nullable=false)
	private Integer totalImpuesto;
	
	@Column(nullable=false)
	private Double total;
	
	@JsonIgnoreProperties({"detalle", "hibernateLazyInitializer", "handler",})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="factura", cascade=CascadeType.ALL)
	private List<DetalleEntity> listDetalle;
	
	public FacturaEntity() {
		this.listDetalle = new ArrayList<>();
	}

	public Long getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(Long documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public Long getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Long numeroFactura) {
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

	public Long getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Long subtotal) {
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
		this.iva = IMPUESTO;
	}

	public Double getTotalDescuento() {
		return totalDescuento;
	}

	public void calcularTotalDescuento() {
		this.totalDescuento = Double.valueOf( (this.subtotal * this.descuento) / CIEN);
	}

	public Integer getTotalImpuesto() {
		return totalImpuesto;
	}

	public void calcularTotalImpuesto() {
		this.totalImpuesto = (int) (this.subtotal * IMPUESTO / CIEN);
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = Double.valueOf((this.subtotal + this.totalImpuesto) - this.descuento) ;
	}

}
