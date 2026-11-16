package com.tabacariachang.site.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tabacariachang.site.model.Administrador;
import com.tabacariachang.site.model.Clientes;
import com.tabacariachang.site.service.ClientesService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClientesController {
	
	private final ClientesService ClientesService;
	
	public ClientesController(ClientesService clientesService) {
		this.ClientesService=clientesService;
	}
	
	@GetMapping("/clientes/cadastrar")
	public String salvar(Model model) {
		model.addAttribute("clientes",new Clientes());
		return "cadastrarclientes";
	}
	
	@PostMapping("/clientes/cadastrar")
	public String cadastrar(Model model, Clientes clientes) {
			boolean resultado=ClientesService.salvar(clientes);
			String resposta=(resultado)?"Cadastrado com sucesso!":"Erro na tentativa de cadastrar!";
			model.addAttribute("resposta",resposta);
		model.addAttribute("clientes", new Clientes());
		return "cadastrarclientes";
	}
	
	@GetMapping("/clientes/alterar")
	public String alterar(@RequestParam(name="codCli") Integer codCli,
			Model model) {
		Clientes clientes=ClientesService.buscarPorCodigo(codCli);
		model.addAttribute("clientes",clientes);
		return "alterarfuncionarios";
	}
	
	@PostMapping("/clientes/alterar")
	public String alterar(
			@RequestParam("codCli") Integer codCli,
			Clientes clientes,
			Model model) {
		clientes.setCodCli(codCli);
		
		Clientes velhoFunc=ClientesService.buscarPorCodigo(codCli);
		if(velhoFunc==null) {
			model.addAttribute("resposta","Erro: Cliente não encontrado!");
			model.addAttribute("clientes",clientes);
			return "alterarclientes";
		}
		boolean resultado=ClientesService.atualizar(codCli, clientes);
		String resposta=(resultado)?"Alterado com sucesso!": "Erro na tentativa de alterar!";
		model.addAttribute("resposta",resposta);
		model.addAttribute("clientes", clientes);
		return "alterarclientes";
	}
	
	@GetMapping("/clientes/excluir")
	public String excluir(
			@RequestParam(name = "codCli",required=true) Integer codCli,
			Model model) {
		Clientes clientes=ClientesService.buscarPorCodigo(codCli);
		model.addAttribute("clientes", clientes);
		return "excluirclientes";
	}
	
	@PostMapping("/clientes/excluir")
	public String confirmaExcluir(@RequestParam("codCli") Integer codCli, Model model) {
		boolean resultado=ClientesService.delete(codCli);
		if(resultado) {
			model.addAttribute("resposta", true);
			return "clientesexcluido";
		}else {
			model.addAttribute("resposta","Erro na tentativa de excluir!");
			return "excluirclientes";
		}
	}
	@GetMapping("/cliente/login")
	public String logar(Model model) {
		model.addAttribute("clientes",new Clientes());
		return "clienteslogin";
	}
	
	@PostMapping("/cliente/login")
	public String fazerLogin(Model model, HttpSession session, @ModelAttribute Clientes clientes) {
		Clientes clientesAutenticado=ClientesService.autenticar(clientes.getLogin(),clientes.getSenha());
		
		if(clientesAutenticado!=null) {
			session.setAttribute("clientes", clientesAutenticado);
			model.addAttribute("resposta",true);
		}else {
			model.addAttribute("resposta",false);
		}
		return "clienteslogin";
	}
}