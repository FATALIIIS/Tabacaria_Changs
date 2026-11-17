package com.tabacariachang.site.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabacariachang.site.model.Clientes;
import com.tabacariachang.site.repository.ClientesRepository;

@Service
public class ClientesService {

	private final ClientesRepository clientesRepository;
	private final BCryptPasswordEncoder encoder;
	
	public ClientesService(ClientesRepository clientesRepository) {
		this.clientesRepository=clientesRepository;
		this.encoder=new BCryptPasswordEncoder();
	}
	
	public Clientes buscarPorCodigo(Integer codCli) {
		return clientesRepository.findByCodCli(codCli);
	}

	@Transactional
	public boolean salvar(Clientes clientes) {
		try {
			clientesRepository.save(clientes);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Transactional
	public boolean atualizar(Integer id,Clientes dadosNovos) {
		Clientes clientes = clientesRepository.findByCodCli(id);
		if(clientes == null) {
			return false;
		}
		clientes.setCpf(dadosNovos.getCpf());
		clientes.setEndereco(dadosNovos.getEndereco());
		clientes.setDataNasci(dadosNovos.getDataNasci());
		clientes.setSenha(dadosNovos.getSenha());
		clientes.criptografa();
		clientes.setSexo(dadosNovos.getSexo());
		clientes.setLogin(dadosNovos.getLogin());
		clientes.setNome(dadosNovos.getNome());
		clientes.setTelefone(dadosNovos.getTelefone());
		clientes.setEmail(dadosNovos.getEmail());
		clientesRepository.save(clientes);
		return true;
	}
	
	@Transactional
	public boolean delete(Integer codCli) {
		Clientes clientes=clientesRepository.findByCodCli(codCli);
		if(clientes==null) {
			return false;
		}
		clientesRepository.delete(clientes);
		return true;
	}
	@Transactional
	public Clientes autenticar(String login, String senhaDigitada) {
		Clientes clientesEncontrado=clientesRepository.findByLogin(login);
		
		if(clientesEncontrado!=null && encoder.matches(senhaDigitada,clientesEncontrado.getSenha())) {
			return clientesEncontrado;
		}
		
		return null;
	}
}