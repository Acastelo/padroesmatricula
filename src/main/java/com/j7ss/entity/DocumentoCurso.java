package com.j7ss.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

@Entity
@Table(name = "documento_curso")
public class DocumentoCurso implements IGenericEntity<DocumentoCurso> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer ordem;

	@ManyToOne
	private Curso curso = new Curso();
	
	@ManyToOne
	private Documento documento = new Documento();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public DocumentoCurso() { }
	
	public DocumentoCurso(Curso curso) {
		this.curso = curso;
	}

	
//******************************************************************************************************************************
//## Builder
	public DocumentoCurso id(Integer id){
		this.id = id;
		return this;
	}
	
	public DocumentoCurso ordem(Integer ordem){
		this.ordem = ordem;
		return this;
	}
	
	public DocumentoCurso curso(Curso curso){
		this.curso = curso;
		return this;
	}
	
	public DocumentoCurso documento(Documento documento){
		this.documento = documento;
		return this;
	}
	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}
	

//******************************************************************************************************************************
//## DAO
	private static DAO<DocumentoCurso> dao = new DAO<DocumentoCurso>(DocumentoCurso.class);
	
	@Override
	public DocumentoCurso save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
}