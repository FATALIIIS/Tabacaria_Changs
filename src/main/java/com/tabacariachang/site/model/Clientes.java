package com.tabacariachang.site.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCli;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "endereco", nullable = false, length = 50)
	private String endereco; 
	
	@Column(name = "dataNasci", nullable = false)
	private LocalDate dataNasci;
	
	@Column(name = "senha", nullable = false, length = 80)
	private String senha;
	
	@Column(name = "sexo", nullable = false, length = 1)
	private String sexo;
	
	@Column(name = "login", nullable = false, length = 20)
	private String login;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "telefone", nullable = false, length = 14)
	private String telefone; 
	
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	
	public Clientes () {
		//construtor
	}

	public Integer getCodCli() {
		return codCli;
	}

	public void setCodCli(Integer codCli) {
		this.codCli = codCli;
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

	public LocalDate getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(LocalDate dataNasci) {
		this.dataNasci = dataNasci;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
