package com.tabacariachang.site.repository;

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
