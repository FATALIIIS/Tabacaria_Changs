package com.tabacariachang.site.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabacariachang.site.model.Produtos;
import com.tabacariachang.site.repository.ProdutosRepository;

@Service
public class ProdutosService {

	private final ProdutosRepository produtosRepository;
	
	public ProdutosService(ProdutosRepository produtosRepository) {
		this.produtosRepository=produtosRepository;
	}
	
	@Transactional
	public boolean salvar(Produtos produtos) {
		try {
			produtosRepository.save(produtos);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Produtos buscarPorCodigo(Integer codProd) {
		return produtosRepository.findByCodProd(codProd);
	}
	
	public Page<Produtos> listar(Pageable pageable){
		return produtosRepository.findAll(pageable);
	}
	
	public Page<Produtos> buscar(Pageable pageable,String campo,String valor){
		if(valor ==null || valor.trim().isEmpty()) {
			return produtosRepository.findAll(pageable);
		}
		switch(campo) {
		case "codigo":
			try {
				return produtosRepository.findByCodProd(Integer.parseInt(valor), pageable);
			}catch (Exception e) {
				return Page.empty(pageable);
			}
		case "descricao":
			return produtosRepository.findByDescricaoContainingIgnoreCase(valor, pageable);	
		case "quantidade":
			return produtosRepository.findByQuantidadeContainingIgnoreCase(Integer.parseInt(valor), pageable);
		case "tipo":
			return produtosRepository.findByTipoContainingIgnoreCase(valor, pageable);
		case "validade":
			return produtosRepository.findByValidadeContainingIgnoreCase(LocalDate.parse(valor), pageable);
		case "nome":
			return produtosRepository.findByNomeContainingIgnoreCase(valor, pageable);
		case "valor":
			return produtosRepository.findByValorContainingIgnoreCase(new BigDecimal(valor), pageable);
		case "dataFabric":
			return produtosRepository.findByDataFabricContainingIgnoreCase(LocalDate.parse(valor), pageable);
		default:
			return produtosRepository.findAll(pageable);
		}
	}
	@Transactional
	public boolean atualizar(Integer id,Produtos dadosNovos) {
		Produtos produtos = produtosRepository.findByCodProd(id);
		if(produtos == null) {
			return false;
		}
		produtos.setNome(dadosNovos.getNome());
		produtos.setDescricao(dadosNovos.getDescricao());
		produtos.setQuantidade(dadosNovos.getQuantidade());
		produtos.setTipo(dadosNovos.getTipo());
		produtos.setValidade(dadosNovos.getValidade());
		produtos.setValor(dadosNovos.getValor());
		produtos.setDataFabric(dadosNovos.getDataFabric());
		
		produtosRepository.save(produtos);
		return true;
	}
	
	@Transactional
	public boolean delete(Integer codProd) {
		Produtos produtos=produtosRepository.findByCodProd(codProd);
		if(produtos==null) {
			return false;
		}
		produtosRepository.delete(produtos);
		return true;
	}
	
	public List<Produtos> listarPorNome(){
		return produtosRepository.findAll(Sort.by(Sort.Direction.ASC,"nome"));
	}
}
