package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

/**
 * Implementacao dos servicos responveis pela funcionalidade completa de cadastro de estudantes.
 * @author Bruno Alves Justino.
 */
@Service
public class EstudandeServiceImpl implements EstudandeService {

	/**
	 * Repository injeto da aplicacao.
	 */
	@Autowired
	private EstudanteRepository repository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Estudante> buscarEstudantes() {
		return (List<Estudante>) repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Estudante buscarEstudante(Long id) {
		return repository.findById(id).get();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean apagarEstudante(@Valid Estudante estudante) {
		repository.delete(estudante);
		return true;
	}

}