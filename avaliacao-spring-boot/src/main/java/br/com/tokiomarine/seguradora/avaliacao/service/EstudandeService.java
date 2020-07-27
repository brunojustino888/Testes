package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

/**
 * Inreface dos servicos da funcionalidade de cadastro de estudantes.
 * @author Bruno Alves Justino.
 */
public interface EstudandeService {

	/**
	 * Busca todos os estudantes.
	 * @return List<Estudante> - lista de estudantes.
	 */
	List<Estudante> buscarEstudantes();

	/**
	 * Cadastra um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 */
	void cadastrarEstudante(@Valid Estudante estudante);

	/**
	 * Busca um determinado estudante atraves do id.
	 * @param id - Long - codigo de identificacao do estudante.
	 * @return Estudante - representa um determinado estudante.
	 */
	Estudante buscarEstudante(Long id);

	/**
	 * Atualiza um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 */
	void atualizarEstudante(@Valid Estudante estudante);
	
	/**
	 * Apaga um determinado estudante.
	 * @param estudante - Estudante - representa um determinado estudante.
	 * @return true - em caso de exclusao com sucesso.
	 */
	boolean apagarEstudante(@Valid Estudante estudante);
	
}