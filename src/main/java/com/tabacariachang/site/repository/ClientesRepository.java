package com.tabacariachang.site.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tabacariachang.site.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
		public Clientes findByCodCli(Integer codCli);
		public Clientes findByLogin(String login);
		public Page<Clientes> findByCodCli(Integer codCli,Pageable pageable);
		public Page<Clientes> findByCpf(String cpf,Pageable pageable);
		public Page<Clientes> findByEnderecoContainingIgnoreCase(String endereco,Pageable pageable);
		public Page<Clientes> findByDataNasci(LocalDate dataNasci,Pageable pageable);
		public Page<Clientes> findBySenhaContainingIgnoreCase(String senha,Pageable pageable);
		public Page<Clientes> findBySexoContainingIgnoreCase(String sexo,Pageable pageable);
		public Page<Clientes> findByLoginContainingIgnoreCase(String login,Pageable pageable);
		public Page<Clientes> findByNomeContainingIgnoreCase(String nome,Pageable pageable);
		public Page<Clientes> findByTelefone(String telefone,Pageable pageable);
		public Page<Clientes> findByEmailContainingIgnoreCase(String email,Pageable pageable);
}
