package com.tabacariachang.site.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tabacariachang.site.model.Administrador;
import com.tabacariachang.site.repository.AdministradorRepository;

import jakarta.transaction.Transactional;

@Service
public class AdministradorService {

	private final AdministradorRepository administradorRepository; 
	private final BCryptPasswordEncoder encoder;
	
	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository=administradorRepository;
		this.encoder=new BCryptPasswordEncoder();
	}
	
	@Transactional
	public Administrador autenticar(String usuario, String senhaDigitada) {
		Administrador admEncontrado=administradorRepository.findByUsuario(usuario);
		
		if(admEncontrado!=null && encoder.matches(senhaDigitada,admEncontrado.getSenha())) {
			return admEncontrado;
		}
		
		return null;
	}
}
