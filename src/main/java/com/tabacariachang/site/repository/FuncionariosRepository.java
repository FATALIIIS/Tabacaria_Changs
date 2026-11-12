package com.tabacariachang.site.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tabacariachang.site.model.Funcionarios;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer>{
	public Funcionarios findByCodFunc(Integer codFunc);
	public Page<Funcionarios> findByCodFunc(Integer codFunc,Pageable pageable);
	public Page<Funcionarios> findByTelefoneContainingIgnoreCase(String telefone,Pageable pageable);
	public Page<Funcionarios> findBySenhaContainingIgnoreCase(String senha,Pageable pageable);
	public Page<Funcionarios> findByDataNasciContainingIgnoreCase(LocalDate dataNasci,Pageable pageable);
	public Page<Funcionarios> findByNomeContainingIgnoreCase(String nome,Pageable pageable);
	public Page<Funcionarios> findByCpfContainingIgnoreCase(String cpf,Pageable pageable);
	public Page<Funcionarios> findByEnderecoContainingIgnoreCase(String endereco,Pageable pageable);
	public Page<Funcionarios> findBySexoContainingIgnoreCase(String sexo,Pageable pageable);
	public Page<Funcionarios> findByLoginContainingIgnoreCase(String login,Pageable pageable);
	public Page<Funcionarios> findByEmailContainingIgnoreCase(String email,Pageable pageable);
} 
