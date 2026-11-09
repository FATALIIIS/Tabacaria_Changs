package com.tabacariachang.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabacariachang.site.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	
	public Administrador findByUsuario(String Usuario);
}
