package com.tabacariachang.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabacariachang.site.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{

	public Produtos findByCodProd(Integer codProd);
	
}
