package br.com.tokiomarine.seguradora.avaliacao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

/**
 * Repository spring de estudantes.
 * @author Bruno Alves Justino.
 */
@Repository
public interface EstudanteRepository extends CrudRepository<Estudante, Long> {}