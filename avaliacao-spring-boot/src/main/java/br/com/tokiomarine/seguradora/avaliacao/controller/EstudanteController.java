package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeServiceImpl;

/**
 * Controller da aplicacao com os mapeamentos das requisicoes da funcionalidade de estudantes.
 * @author Bruno Alves Justino.
 */
@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	/**
	 * Service injetado responsavel por prover dados.
	 */
	@Autowired
	private EstudandeServiceImpl service;

	/**
	 * Incia a pagina de cadastro de estudantes.
	 * @param estudante - representa um determinado estudante.
	 * @return String - pagina de cadastro de estudantes.
	 */
	@GetMapping("criar")
	public String iniciarCastrado(Estudante estudante) {
		return "cadastrar-estudante";
	}

	/**
	 * Faz a consulta de estudantes, adciona eles no model e direciona para a pagina incial.
	 * @param model - Model - objeto spring para prover os dados da view.
	 * @return String - pagina inicial.
	 */
	@GetMapping("listar")
	public String listarEstudantes(Model model) {
		model.addAttribute("estudantes", this.service.buscarEstudantes());
		return "index";
	}

	/**
	 * Responsavel por adicionar um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 * @param result - BindingResult - objeto spring.
	 * @param model - Model - objeto spring para prover os dados da view.
	 * @return String - redirect ate a pagina inicial em caso de sucesso e redirect para a tela de cadastro novamente em caso de falha de validacao.
	 */
	@PostMapping("add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "cadastrar-estudante";
		}
		this.service.cadastrarEstudante(estudante);
		return "redirect:listar";
	}

	/**
	 * Exibe a tela de edicao dos estudantes.
	 * @param id - Long- representa a identificacao de um determinado estudante.
	 * @param model - Model - objeto spring para prover os dados da view.
	 * @return String - pagina de edicao de um determinado estudante.
	 */
	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(@PathVariable("id") Long id, Model model) {
		Estudante estudante = this.service.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}

	/**
	 * Atualiza um determinado estudante. 
	 * @param id - Long- representa a identificacao de um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 * @param result - BindingResult - objeto spring.
	 * @param model - Model - objeto spring para prover os dados da view.
	 * @return String - pagina inicial.
	 */
	@PostMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") Long id, @Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			estudante.setId(id);
			return "atualizar-estudante";
		}
		this.service.atualizarEstudante(estudante);
		model.addAttribute("estudantes", this.service.buscarEstudantes());
		return "index";
	}

	/**
	 * Apaga um determinado estudante.
	 * @param id - Long- representa a identificacao de um determinado estudante.d
	 * @param model - Model - objeto spring para prover os dados da view.
	 * @return String - pagina inicial.
	 */
	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") Long id, Model model) {
		this.service.apagarEstudante(this.service.buscarEstudante(id));
		model.addAttribute("estudantes", this.service.buscarEstudantes());
		return "index";
	}

}