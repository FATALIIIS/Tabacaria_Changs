package com.tabacariachang.site.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codAdm;
	
	@Column(name = "nome",nullable = false,length = 40)
	private String nome;
	
	@Column(name = "usuario",nullable = false,length = 20,unique = true)
	private String usuario;
	
	@Column(name = "senha",nullable = false,length = 80)
	private String senha;
	
	@Column(name = "cpf",nullable = false, length = 11,unique = true)
	private String cpf;
	
	public Administrador() {
		//construtor
	}

	public Integer getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(Integer codAdm) {
		this.codAdm = codAdm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
