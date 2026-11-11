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

import com.tabacariachang.site.model.Produtos;
import com.tabacariachang.site.service.ProdutosService;

@Controller
public class ProdutosController {
	
	private final ProdutosService produtosService;
	
	public ProdutosController(ProdutosService produtosService) {
		this.produtosService=produtosService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("imagem");
	}
	
	@GetMapping("/produtos/cadastrar")
	public String salvar(Model model) {
		model.addAttribute("produtos",new Produtos());
		return "cadastrarprodutos";
	}
	
	@PostMapping("/produtos/cadastrar")
	public String cadastrar(Model model, Produtos produtos, @RequestParam(value = "imagem",required=true)MultipartFile arquivo) {
		try {
			if(arquivo != null && !arquivo.isEmpty ()) {
				produtos.setImagem(arquivo.getBytes());
			}
			boolean resultado=produtosService.salvar(produtos);
			String resposta=(resultado)?"Cadastrado com sucesso!":"Erro na tentativa de cadastrar!";
			model.addAttribute("resposta",resposta);
		}catch (Exception e) {
			model.addAttribute("resposta","Erro ao processar a foto!"+e);
		}
		model.addAttribute("produtos", new Produtos());
		return "cadastrarprodutos";
	}
	
	@GetMapping("/produtos/listar")
	public String listar(Model model,@PageableDefault(size=5,sort = "codProd")Pageable pageable) {
		Page<Produtos> pagina=produtosService.listar(pageable);	
		model.addAttribute("produtos", pagina.getContent());
		model.addAttribute("paginaAtual", pagina.getNumber());
		model.addAttribute("totalPaginas", pagina.getTotalPages());
		model.addAttribute("total", pagina.getTotalElements());
		return "listarprodutos";
	}
	
	@GetMapping("/produtos/buscar")
	public String buscar(
			@RequestParam(name="campo",required=false) String campo,
			@RequestParam(name="valor",required=false) String valor,
			@PageableDefault(size = 5, sort="codProd") Pageable pageable,
			Model model
			) {
		Page<Produtos> pagina;
		if(campo !=null && valor!=null && !valor.trim().isEmpty()) {
			pagina=produtosService.buscar(pageable, campo, valor);
		}else {
			pagina=produtosService.listar(pageable);
		}
		
		model.addAttribute("produtos",pagina.getContent());
		model.addAttribute("paginaAtual",pagina.getNumber());
		model.addAttribute("totalPaginas",pagina.getTotalPages());
		model.addAttribute("total",pagina.getTotalElements());
		
		model.addAttribute("campo",campo);
		model.addAttribute("valor",valor);
		
		return "buscarprodutos";
	}
	
	@GetMapping("/produtos/alterar")
	public String alterar(@RequestParam(name="codProd") Integer codProd,
			Model model) {
		Produtos produtos=produtosService.buscarPorCodigo(codProd);
		model.addAttribute("produtos",produtos);
		return "alterarprodutos";
	}
	
	@PostMapping("/produtos/alterar")
	public String alterar(
			@RequestParam("codProd") Integer codProd,
			Produtos produtos,
			Model model,@RequestParam(value = "imagem",required=true)MultipartFile arquivo) {
		produtos.setCodProd(codProd);
		
		Produtos velhoProd=produtosService.buscarPorCodigo(codProd);
		if(velhoProd==null) {
			model.addAttribute("resposta","Erro: Produto não encontrado!");
			model.addAttribute("produtos",produtos);
			return "alterarprodutos";
		}
		try {
			if(arquivo != null && !arquivo.isEmpty ()) {
				produtos.setImagem(arquivo.getBytes());
			}
			}catch (Exception e) {
				model.addAttribute("resposta","Erro ao processar a foto!"+e);
			}
		boolean resultado=produtosService.atualizar(codProd, produtos);
		String resposta=(resultado)?"Alterado com sucesso!": "Erro na tentativa de alterar!";
		model.addAttribute("resposta",resposta);
		model.addAttribute("produtos", produtos);
		return "alterarprodutos";
	}
	
	@GetMapping("/produtos/excluir")
	public String excluir(
			@RequestParam(name = "codProd",required=true) Integer codProd,
			Model model) {
		Produtos produtos=produtosService.buscarPorCodigo(codProd);
		model.addAttribute("produtos", produtos);
		return "excluirprodutos";
	}
	
	@PostMapping("/produtos/excluir")
	public String confirmaExcluir(@RequestParam("codProd") Integer codProd, Model model) {
		boolean resultado=produtosService.delete(codProd);
		if(resultado) {
			model.addAttribute("resposta", true);
			return "produtosexcluido";
		}else {
			model.addAttribute("resposta","Erro na tentativa de excluir!");
			return "excluirprodutos";
		}
	}
	@GetMapping("/produtos/imagem/{id}")
	public ResponseEntity<byte[]> exibirFoto(@PathVariable("id") Integer id){
		Produtos produtos=produtosService.buscarPorCodigo(id); if(produtos!=null && produtos.getImagem()!= null) {
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<>(produtos.getImagem(),headers,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/produtos/{id}")
	public String mostraDetalhes(Model model, @PathVariable("id") Integer id) {
		Produtos produtos=produtosService.buscarPorCodigo(id);
		if(produtos!=null) {
			model.addAttribute("produtos",produtos);
			return "produtos";
		}else {
			return "redirect:/produtos/buscar";
		}
	}
}