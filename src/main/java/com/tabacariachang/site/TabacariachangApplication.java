package com.tabacariachang.site;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tabacariachang.site.model.Administrador;
import com.tabacariachang.site.repository.AdministradorRepository;

@SpringBootApplication
public class TabacariachangApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabacariachangApplication.class, args);
	}
	
	@Bean
	CommandLineRunner iniciarDatabase(AdministradorRepository repository) {
		return args->{
			if(repository.count()==0) {
				Administrador administrador=new Administrador();
				administrador.setNome("Sr Wong");
				administrador.setUsuario("admin");
				administrador.setSenha("admin");
				administrador.setCpf("10020099955");
				administrador.criptografa();
				repository.save(administrador);
			}
		};
	}
}

