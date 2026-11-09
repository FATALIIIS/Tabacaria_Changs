package com.tabacariachang.site.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tabacariachang.site.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{

	public Produtos findByCodProd(Integer codProd);
	public Page<Produtos> findByCodProd(Integer codProd,Pageable pageable);
	public Page<Produtos> findByDescricaoContainingIgnoreCase(String descricao,Pageable pageable);
	public Page<Produtos> findByQuantidadeContainingIgnoreCase(int quantidade,Pageable pageable);
	public Page<Produtos> findByTipoContainingIgnoreCase(String tipo,Pageable pageable);
	public Page<Produtos> findByValidadeContainingIgnoreCase(LocalDate validade,Pageable pageable);
	public Page<Produtos> findByNomeContainingIgnoreCase(String nome,Pageable pageable);
	public Page<Produtos> findByValorContainingIgnoreCase(BigDecimal valor,Pageable pageable);
	public Page<Produtos> findByDataFabricContainingIgnoreCase(LocalDate dataFabric,Pageable pageable);
}
