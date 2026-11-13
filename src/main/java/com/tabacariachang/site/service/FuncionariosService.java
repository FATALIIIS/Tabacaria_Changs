package com.tabacariachang.site.service;

<<<<<<< HEAD
=======
import java.math.BigDecimal;
import java.time.LocalDate;
>>>>>>> d0c1821f9a4f0d92298089b8e9626e889430826f
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
<<<<<<< HEAD
private final FuncionariosRepository repository;
	
	public FuncionariosService(FuncionariosRepository repository) {
		this.repository=repository;
=======

	private final FuncionariosRepository funcionariosRepository;
	
	public FuncionariosService(FuncionariosRepository funcionariosRepository) {
		this.funcionariosRepository=funcionariosRepository;
>>>>>>> d0c1821f9a4f0d92298089b8e9626e889430826f
	}
	
	@Transactional
	public boolean salvar(Funcionarios funcionarios) {
<<<<<<< HEAD
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
=======
		try {
			funcionariosRepository.save(funcionarios);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Funcionarios buscarPorCodigo(Integer codFUnc) {
		return funcionariosRepository.findByCodFunc(codFUnc);
	}
	
	public Page<Funcionarios> listar(Pageable pageable){
		return funcionariosRepository.findAll(pageable);
	}
	
	public Page<Funcionarios> buscar(Pageable pageable,String campo,String valor){
		if(valor ==null || valor.trim().isEmpty()) {
			return funcionariosRepository.findAll(pageable);
		}
		switch(campo) {
		case "codigo":
			try {
				return funcionariosRepository.findByCodFunc(Integer.parseInt(valor), pageable);
			}catch (Exception e) {
				return Page.empty(pageable);
			}
			
		case "telefone":
			return funcionariosRepository.findByTelefoneContainingIgnoreCase(valor, pageable);
		case "dataNasci":
			return funcionariosRepository.findByDataNasciContainingIgnoreCase(LocalDate.parse(valor), pageable);
		case "nome":
			return funcionariosRepository.findByNomeContainingIgnoreCase(valor, pageable);
		case "cpf":
			return funcionariosRepository.findByCpfContainingIgnoreCase(valor, pageable);
		case "endereco":
			return funcionariosRepository.findByEnderecoContainingIgnoreCase(valor, pageable);
		case "email":
			return funcionariosRepository.findByEmailContainingIgnoreCase(valor, pageable);
		case "login":
			return funcionariosRepository.findByLoginContainingIgnoreCase(valor, pageable);
		default:
			return funcionariosRepository.findAll(pageable);
		}
	}
	@Transactional
	public boolean atualizar(Integer id,Funcionarios dadosNovos) {
		Funcionarios funcionarios = funcionariosRepository.findByCodFunc(id);
		if(funcionarios == null) {
			return false;
		}
		funcionarios.setTelefone(dadosNovos.getTelefone());
		funcionarios.setDataNasci(dadosNovos.getDataNasci());
		funcionarios.setNome(dadosNovos.getNome());
		funcionarios.setCpf(dadosNovos.getCpf());
		funcionarios.setEndereco(dadosNovos.getEndereco());
		funcionarios.setEmail(dadosNovos.getEmail());
		funcionarios.setLogin(dadosNovos.getLogin());
		funcionariosRepository.save(funcionarios);
		return true;
	}
	
	@Transactional
	public boolean delete(Integer codFunc) {
		Funcionarios funcionarios=funcionariosRepository.findByCodFunc(codFunc);
		if(funcionarios==null) {
			return false;
		}
		funcionariosRepository.delete(funcionarios);
		return true;
	}
	
	public List<Funcionarios> listarPorNome(){
		return funcionariosRepository.findAll(Sort.by(Sort.Direction.ASC,"nome"));
	}
>>>>>>> d0c1821f9a4f0d92298089b8e9626e889430826f
}
