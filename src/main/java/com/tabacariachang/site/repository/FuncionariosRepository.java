package com.tabacariachang.site.repository;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tabacariachang.site.model.Funcionarios;

public interface FuncionariosRepository {
	public Funcionarios findBycpf(String cpf);
	public Funcionarios findBycodFunc(Integer codFunc);
	public Page<Funcionarios> findBynomeContainingIgnoreCase(
			String nome,Pageable pageable);
	public Page<Funcionarios> findBycodFunc(Integer codFunc,Pageable pageable);
	public Page<Funcionarios> findByenderecoContainingIgnoreCase(
			String endereco,Pageable pageable);
	public Page<Funcionarios> findBytelefoneContainingIgnoreCase(
			String telefone,Pageable pageable);
	public Page<Funcionarios> findBycpfContainingIgnoreCase(
			String cpf,Pageable pageable);
	public Page<Funcionarios> findBysexoContainingIgnoreCase(
			String sexo,Pageable pageable);
	public Page<Funcionarios> findByloginContainingIgnoreCase(
			String login,Pageable pageable);
	public Page<Funcionarios> findBysenhaContainingIgnoreCase(
			String senha,Pageable pageable);
	public Page<Funcionarios> findByemailContainingIgnoreCase(
			String email,Pageable pageable);
	public Page<Funcionarios> findBydataNasciContainingIgnoreCase(
			String dataNasci,Pageable pageable);
	
}
=======
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
>>>>>>> d0c1821f9a4f0d92298089b8e9626e889430826f
