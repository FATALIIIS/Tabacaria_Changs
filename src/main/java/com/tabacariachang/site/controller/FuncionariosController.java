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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tabacariachang.site.model.Funcionarios;
import com.tabacariachang.site.service.FuncionariosService;

@Controller
public class FuncionariosController {
	
	private final FuncionariosService FuncionariosService;
	
	public FuncionariosController(FuncionariosService funcionariosService) {
		this.FuncionariosService=funcionariosService;
	}
	
	@GetMapping("/funcionarios/cadastrar")
	public String salvar(Model model) {
		model.addAttribute("funcionarios",new Funcionarios());
		return "cadastrarfuncionarios";
	}
	
	@PostMapping("/funcionarios/cadastrar")
	public String cadastrar(Model model, Funcionarios funcionarios) {
			boolean resultado=FuncionariosService.salvar(funcionarios);
			String resposta=(resultado)?"Cadastrado com sucesso!":"Erro na tentativa de cadastrar!";
			model.addAttribute("resposta",resposta);
		model.addAttribute("funcionarios", new Funcionarios());
		return "cadastrarfuncionarios";
	}
	
	@GetMapping("/funcionarios/listar")
	public String listar(Model model,@PageableDefault(size=5,sort = "codFunc")Pageable pageable) {
		Page<Funcionarios> pagina=FuncionariosService.listar(pageable);	
		model.addAttribute("funcionarios", pagina.getContent());
		model.addAttribute("paginaAtual", pagina.getNumber());
		model.addAttribute("totalPaginas", pagina.getTotalPages());
		model.addAttribute("total", pagina.getTotalElements());
		return "listarfuncionarios";
	}
	
	@GetMapping("/funcionarios/buscar")
	public String buscar(
			@RequestParam(name="campo",required=false) String campo,
			@RequestParam(name="valor",required=false) String valor,
			@PageableDefault(size = 5, sort="codFunc") Pageable pageable,
			Model model
			) {
		Page<Funcionarios> pagina;
		if(campo !=null && valor!=null && !valor.trim().isEmpty()) {
			pagina=FuncionariosService.buscar(pageable, campo, valor);
		}else {
			pagina=FuncionariosService.listar(pageable);
		}
		
		model.addAttribute("funcionarios",pagina.getContent());
		model.addAttribute("paginaAtual",pagina.getNumber());
		model.addAttribute("totalPaginas",pagina.getTotalPages());
		model.addAttribute("total",pagina.getTotalElements());
		
		model.addAttribute("campo",campo);
		model.addAttribute("valor",valor);
		
		return "buscarfuncionarios";
	}
	
	@GetMapping("/funcionarios/alterar")
	public String alterar(@RequestParam(name="codFunc") Integer codFunc,
			Model model) {
		Funcionarios funcionarios=FuncionariosService.buscarPorCodigo(codFunc);
		model.addAttribute("funcionarios",funcionarios);
		return "alterarfuncionarios";
	}
	
	@PostMapping("/funcionarios/alterar")
	public String alterar(
			@RequestParam("codFunc") Integer codFunc,
			Funcionarios funcionarios,
			Model model) {
		funcionarios.setCodFunc(codFunc);
		
		Funcionarios velhoFunc=FuncionariosService.buscarPorCodigo(codFunc);
		if(velhoFunc==null) {
			model.addAttribute("resposta","Erro: Funcionário não encontrado!");
			model.addAttribute("funcionario",funcionarios);
			return "alterarfuncionarios";
		}
		boolean resultado=FuncionariosService.atualizar(codFunc, funcionarios);
		String resposta=(resultado)?"Alterado com sucesso!": "Erro na tentativa de alterar!";
		model.addAttribute("resposta",resposta);
		model.addAttribute("funcionarios", funcionarios);
		return "alterarfuncionarios";
	}
	
	@GetMapping("/funcionarios/excluir")
	public String excluir(
			@RequestParam(name = "codFunc",required=true) Integer codFunc,
			Model model) {
		Funcionarios funcionarios=FuncionariosService.buscarPorCodigo(codFunc);
		model.addAttribute("funcionarios", funcionarios);
		return "excluirfuncionarios";
	}
	
	@PostMapping("/funcionarios/excluir")
	public String confirmaExcluir(@RequestParam("codFunc") Integer codFunc, Model model) {
		boolean resultado=FuncionariosService.delete(codFunc);
		if(resultado) {
			model.addAttribute("resposta", true);
			return "funcionariosexcluido";
		}else {
			model.addAttribute("resposta","Erro na tentativa de excluir!");
			return "excluirfuncionarios";
		}
	}
	
	@GetMapping("/funcionarios/{id}")
	public String mostraDetalhes(Model model, @PathVariable("id") Integer id) {
		Funcionarios funcionarios=FuncionariosService.buscarPorCodigo(id);
		if(funcionarios!=null) {
			model.addAttribute("funcionarios", funcionarios);
			return "funcionarios";
		}else {
			return "redirect:/funcionarios/buscar";
		}
	}
}