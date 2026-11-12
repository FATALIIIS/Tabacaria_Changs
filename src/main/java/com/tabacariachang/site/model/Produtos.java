package com.tabacariachang.site.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProd;
	
	@Column(name = "descricao",nullable = false, columnDefinition = "text")
	private String descricao;
	
	@Column(name = "quantidade",nullable = false, length = 9999)
	private int quantidade;
	
	@Column(name = "tipo",nullable = false, length = 30)
	private String tipo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "validade",nullable = false)
	private LocalDate validade;	
	
	@Column(name = "nome",nullable = false, length = 50)
	private String nome;
	
	@Column(name = "valor", precision = 4, scale = 2)
	private BigDecimal valor;
	
	@Column(name = "imagem",nullable = false, columnDefinition = "bytea")
	private byte[] imagem;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dataFabric",nullable = false)
	private LocalDate dataFabric;
	
	public Produtos() {
		//construtor
	}

	public Integer getCodProd() {
		return codProd;
	}

	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public LocalDate getDataFabric() {
		return dataFabric;
	}

	public void setDataFabric(LocalDate dataFabric) {
		this.dataFabric = dataFabric;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
