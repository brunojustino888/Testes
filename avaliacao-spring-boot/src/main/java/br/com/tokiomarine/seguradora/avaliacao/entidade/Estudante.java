package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Entidade para representar um determinado estudante.
 * @author Bruno Alves Justino.
 */
@Entity
@Table(name="ESTUDANTE")
public class Estudante {

	/**
	 * Representa o codigo de identificacao de um determinado estudante.
	 * Chave primaria do estudante na base de dados.
	 * Com estrategia de incremento automatico.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	/**
	 * Representa o nome um determinado estudante.
	 */
	@Column(name="NOME") 
	@NotEmpty(message = "{validation.nome.notEmpty}")
	@NotNull(message="{validation.nome.notEmpty}")
	private String nome;
	
	/**
	 * Representa o email de um determinado estudante.
	 */
	@Column(name="EMAIL") 
	@NotEmpty(message = "{validation.email.notEmpty}")
	@NotNull(message="{validation.email.notEmpty}")
	private String email;
	
	/**
	 * Representa o telefone de um determinado estudante.
	 */
	@Column(name="TELEFONE") 
	private String telefone;
	
	/**
	 * Representa a matricula de um determinado estudante.
	 */
	@Column(name="MATRICULA") 
	@NotEmpty(message = "{validation.matricula.notEmpty}")
	@NotNull(message="{validation.matricula.notEmpty}")
	private String matricula;
	
	/**
	 * Representa o curso de um determinado estudante.
	 */
	@Column(name="CURSO") 
	private String curso;

	/**
	 * Metodo get do atributo id.
	 * @return id - Long - representa o codigo de identificacao de um determinado estudante.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Metodo set do atributo id.
	 * @param id - Long - representa o codigo de identificacao de um determinado estudante.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo get do atributo nome de um determinado estudante.
	 * @return nome - String - nome de um determinado estudante.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo set do atributo nome de um determinado estudante.
	 * @param nome - String - nome de um determinado estudante.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo get do email de um determinado estudante.
	 * @return email - String - email de um determinado estudante.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Metodo set do email de um determinado estudante.
	 * @param email - String - email de um determinado estudante.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo get do telefone do estudante.
	 * @return telefone - String - telefone do estudante.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Metodo set do telefone do estudante.
	 * @param telefone - String - telefone do estudante.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo get da matricula do estudante.
	 * @return matricula - String - matricula do estudante.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Metodo set da matricula do estudante.
	 * @param matricula - String - matricula do estudante.
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Metodo get do curso do estudante.
	 * @return curso - String - curso do estudante.
	 */
	public String getCurso() {
		return this.curso;
	}

	/**
	 * Metodo set do curso do estudante.
	 * @param curso - String - curso do estudante.
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}