package com.j7ss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

@Entity
@Table(name = "curso")
public class Curso implements IGenericEntity<Curso>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String professorOrientador;
	private String professorOrientadorTelefone;
	private String professorOrientadorEmail;
	
	private Integer duracaoEstagio;
	
	@ManyToOne
	private Departamento departamento;
	
	@OneToMany(mappedBy="curso", cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.JOIN)
	@OrderBy("ordem")
	private List<DocumentoCurso> documentoCursos;
	
	@OneToMany(mappedBy="curso")
	private List<Aluno> alunos;
	
	@ManyToOne
	private Professor professor;
	
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

	public String getProfessorOrientador() {
		return professorOrientador;
	}

	public void setProfessorOrientador(String professorOrientador) {
		this.professorOrientador = professorOrientador;
	}

	public String getProfessorOrientadorTelefone() {
		return professorOrientadorTelefone;
	}

	public void setProfessorOrientadorTelefone(String professorOrientadorTelefone) {
		this.professorOrientadorTelefone = professorOrientadorTelefone;
	}

	public String getProfessorOrientadorEmail() {
		return professorOrientadorEmail;
	}

	public void setProfessorOrientadorEmail(String professorOrientadorEmail) {
		this.professorOrientadorEmail = professorOrientadorEmail;
	}

	public Integer getDuracaoEstagio() {
		return duracaoEstagio;
	}

	public void setDuracaoEstagio(Integer duracaoEstagio) {
		this.duracaoEstagio = duracaoEstagio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<DocumentoCurso> getDocumentoCursos() {
		return documentoCursos;
	}

	public void setDocumentoCursos(List<DocumentoCurso> documentoCursos) {
		this.documentoCursos = documentoCursos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	//******************************************************************************************************************************
//## Builder
	public Curso id(Integer id){
		this.id = id;
		return this;
	}
	
	public Curso nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public Curso departamento(Departamento departamento){
		this.departamento = departamento;
		return this;
	}
	
	public Curso documentoCursos(List<DocumentoCurso> documentoCursos){
		this.documentoCursos = documentoCursos;
		return this;
	}
	
	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}
	
	public List<Documento> getDocumentos(){
		List<Documento> documentos = new ArrayList<>();
		for (DocumentoCurso dc : documentoCursos) {
			documentos.add(dc.getDocumento());
		}
		return documentos;
	}
	
	public void setDocumentos(List<Documento> documentos) throws DAOException{
		if(documentoCursos != null){
			for (DocumentoCurso dcs : documentoCursos) {
				dcs.remove();
			}
		}
		documentoCursos = new ArrayList<>();
		for (int i = 0; i < documentos.size(); i++) {
			documentoCursos.add( new DocumentoCurso(this).documento(documentos.get(i)).ordem(i).save() );
		}
	}
	
	
//******************************************************************************************************************************
//## DAO
	private static DAO<Curso> dao = new DAO<Curso>(Curso.class);
	
	@Override
	public Curso save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static Curso findById(Integer idCurso){
		return dao.findOne(idCurso);
	}
	
	public static List<Curso> findByNomeLike(Departamento departamento, String nome){
		return dao.findByQuery("SELECT i FROM Curso i WHERE i.departamento = ?1 AND lower(i.nome) like ?2" ,departamento, "%"+nome.toLowerCase()+"%");
	}
}
