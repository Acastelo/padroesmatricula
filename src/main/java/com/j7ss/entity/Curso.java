package com.j7ss.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "curso")
public class Curso extends BaseEntity<Integer>{

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", professorOrientador=" + professorOrientador + ", professorOrientadorTelefone="
				+ professorOrientadorTelefone + ", professorOrientadorEmail=" + professorOrientadorEmail
				+ ", duracaoEstagio=" + duracaoEstagio + ", departamento=" + departamento + ", documentoCursos="
				+ documentoCursos + ", alunos=" + alunos + ", professor=" + professor + "]";
	}
	
	
}
