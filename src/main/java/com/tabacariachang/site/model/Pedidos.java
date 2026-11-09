package com.tabacariachang.site.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPed;
	
	@Column(name = "valor",nullable = false, precision = 4, scale = 2)
	private BigDecimal valor;
	
	@Column(name = "data",nullable = false)
	private LocalDate data;
	
	@Column(name = "status",nullable = false, length = 40)
	private String status;
	
	public Pedidos() {
		//construtor
	}

	public Integer getCodPed() {
		return codPed;
	}

	public void setCodPed(Integer codPed) {
		this.codPed = codPed;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
