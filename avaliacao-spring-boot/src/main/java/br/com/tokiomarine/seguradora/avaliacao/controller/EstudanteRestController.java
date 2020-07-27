package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeServiceImpl;

/**
 * RestController da aplicacao.
 * @author Bruno Alves Justino.
 */
@RestController
public class EstudanteRestController {

	/**
	 * Service injetado responsavel por prover dados.
	 */
	@Autowired
	private EstudandeServiceImpl service;
	
	/**
	 * Disponibiliza a lista de estudantes.
	 * @return List<Estudante> - lista de estudantes.
	 */
	@RequestMapping(path="/listarEstudantesResource", method=RequestMethod.GET)
	public List<Estudante> getListaEstudantes(){
		return this.service.buscarEstudantes();
	}

	/**
	 * Disponibiliza a acao de adicionar o objeto de um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 * @return ResponseEntity<Estudante> - objeto de resposta para representar o estudante.
	 */
	@PostMapping(path="/addEstudanteResource")
	public ResponseEntity<Estudante> addEstudante(@Valid Estudante estudante){
		this.service.cadastrarEstudante(estudante);
		return new ResponseEntity<Estudante>(estudante, HttpStatus.CREATED);
	}
	
	/**
	 * Disponibiliza a acao de autalizar o objeto de um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 * @return ResponseEntity<Estudante> - objeto de resposta para representar o estudante.
	 */
	@RequestMapping(path="/atualizarEstudanteResource", method=RequestMethod.PUT)
	public ResponseEntity<Estudante> atualizarEstudante(@Valid Estudante estudante){
		this.service.atualizarEstudante(estudante);
		return new ResponseEntity<Estudante>(estudante, HttpStatus.OK);
	}
	
	/**
	 * isponibiliza a acao de remover o objeto de um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 * @return ResponseEntity<Estudante> - objeto de resposta para representar o estudante.
	 */
	@RequestMapping(path="/excluirEstudanteResource", method=RequestMethod.DELETE)
	public ResponseEntity<Estudante> apagarEstudante(@Valid Estudante estudante){
		this.service.apagarEstudante(estudante);
		return new ResponseEntity<Estudante>(estudante, HttpStatus.OK);
	}
	
}