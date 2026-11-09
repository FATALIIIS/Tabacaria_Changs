package com.tabacariachang.site.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Itens")
public class Itens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codItem;
	
	@ManyToOne
	@JoinColumn(name = "codPed")
	private Pedidos pedidos;
	@ManyToOne
	@JoinColumn(name = "codProd")
	private Produtos produtos;
	
	public Itens() {
		//construtor
	}

	public Integer getCodItem() {
		return codItem;
	}

	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	
}
