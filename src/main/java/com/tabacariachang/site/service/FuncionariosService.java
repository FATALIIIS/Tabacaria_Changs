package com.tabacariachang.site.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabacariachang.site.model.Funcionarios;
import com.tabacariachang.site.repository.FuncionariosRepository;

@Service
public class FuncionariosService {
private final FuncionariosRepository repository;
	
	public FuncionariosService(FuncionariosRepository repository) {
		this.repository=repository;
	}
	
	@Transactional
	public boolean salvar(Funcionarios funcionarios) {
		if(funcionarios.getCpf()!=null) {
			funcionarios.setCpf((funcionarios.getCpf().
					replaceAll("[^0-9]",""));
		}
		if(repository.findBycpf(funcionarios.getCpf())!=null) {
			return false;
		}
		repository.save(funcionarios);
		return true;
	}
	
	public Page<Funcionarios> listar(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Page<Funcionarios> buscar(Pageable pageable,
			String campo,String valor){
		if(valor ==null || valor.trim().isEmpty()) {
			return repository.findAll(pageable);
		}
		switch (campo) {
		case "codigo":
			try {
				return repository.findByCodFunc(
						Integer.parseInt(valor), pageable);
			}catch (Exception e) {
				return Page.empty(pageable);
			}
		case "nome":
			return repository.findByNomeContainingIgnoreCase(
					valor, pageable);
		case "endereco":
			return repository.findByEnderecoContainingIgnoreCase(
					valor, pageable);
		case "telefone":
			return repository.findByTelefoneContainingIgnoreCase(
					valor, pageable);
		case "cpf":
			return repository.findBycpfContainingIgnoreCase(
					valor, pageable);
		default:
			return repository.findAll(pageable);			
		}
		 
	}
	public Funcionarios buscarPorCodigo(Integer CodFunc) {
		Funcionarios Funcionarios=repository.findByCodFunc(CodFunc);
		return Funcionarios;
	}
	
	public boolean verificarcpf(String novocpf) {
		Funcionarios Funcionarios=repository.findBycpf(novocpf);
		if(Funcionarios==null) {
			return false;
		}else {
			return true;
		}
	}
		@Transactional
		public boolean atualizar(Integer id, Funcionarios dadosNovos) {
			Funcionarios Funcionarios = repository.findByCodFunc(id);
			if (Funcionarios == null) {
				return false;
			}
			String novocpf=dadosNovos.getcpf();
			if(novocpf!=null) {
				novocpf=novocpf.replaceAll("^[0-9]", "");
				Funcionarios.setcpf(novocpf);
			}
			
			Funcionarios.setNome(dadosNovos.getNome());
			Funcionarios.setEndereco(dadosNovos.getEndereco());
			Funcionarios.setTelefone(dadosNovos.getTelefone());
			
			repository.save(Funcionarios);
			return true;
	}
		@Transactional
		public boolean delete(Integer CodFunc) {
			Funcionarios Funcionarios=repository.findByCodFunc(CodFunc);
			if(Funcionarios==null) {
				return false;
			}
			repository.delete(Funcionarios);
			return true;
		}
		
		public List<Funcionarios> listarPorNome(){
			return repository.findAll(Sort.by(Sort.Direction.ASC,"nome"));
		}
}
