package com.tabacariachang.site.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funcionarios")
public class Funcionarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFunc;
	
	@Column(name = "telefone", nullable = false, length = 14)
	private String telefone;
	
	@Column(name = "senha", nullable = false, length = 80)
	private String senha;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dataNasci",nullable = false)
	private LocalDate dataNasci;
	
	@Column(name = "nome", nullable = false, length = 40)
	private String nome; 
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "endereco", nullable = false, length = 50)
	private String endereco;
	
	@Column(name = "sexo", nullable = false, length = 10)
	private String sexo;
	
	@Column(name = "login", nullable = false, length = 20)
	private String login;
	
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	
	public Funcionarios() {
		//construtor
	}

	public Integer getCodFunc() {
		return codFunc;
	}

	public void setCodFunc(Integer codFunc) {
		this.codFunc = codFunc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(LocalDate dataNasci) {
		this.dataNasci = dataNasci;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
