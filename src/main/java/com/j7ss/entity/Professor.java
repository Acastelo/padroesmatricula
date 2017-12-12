package com.j7ss.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

@Entity
@Table(name = "professor")
public class Professor implements IGenericEntity<Professor>{
	/**
	 * Serial default para o objeto aluno
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos da classe professor.
	 * Com as anotações de get e set para cada atributo.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQualificação() {
		return qualificação;
	}

	public void setQualificação(String qualificação) {
		this.qualificação = qualificação;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public List<Curso> getCursoDarAula() {
		return cursoDarAula;
	}

	public void setCursoDarAula(List<Curso> cursoDarAula) {
		this.cursoDarAula = cursoDarAula;
	}

	private String nome;
	
	private String qualificação;
	
	private Integer idade;
	
	@OneToMany(mappedBy="professor", cascade=CascadeType.REMOVE)
	private List<Curso> cursoDarAula;

	/**
	 * Métodos herdados da interface IGenericEntity.
	 * Que zera o objeto professor
	 */
	@Override
	public boolean isNew() {
		return id == null;
	}

	/**
	 * DAO
	 * Métodos de acesso ao banco
	 */
	private static DAO<Professor> daoProfessor = new DAO<Professor>(Professor.class);
	@Override
	
	//Método para salvar professor.
	public Professor save() throws DAOException {
		return isNew() ? daoProfessor.add(this) : daoProfessor.update(this);
	}

	//Método para remover professor
	@Override
	public boolean remove() throws DAOException {
		return daoProfessor.remove(this);
	}
	
	//Método para consulta de todos os professor
	public List<Professor> consulta() throws DAOException{
		List<Professor> professores = daoProfessor.findAll();
		
		return professores;
	}
	
	//método para consulta professor por ID
	public Professor consultaById(Integer id){
		return daoProfessor.findOneByQuery("SELECT p FROM professor p WHERE p.id = ?1", id);
		 
	}
	

}
