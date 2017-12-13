package com.j7ss.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.entity.constraint.AlunoStatus;

@Entity
@Table(name = "aluno")
public class Aluno extends BaseEntity<Integer>{

	@Column(length=20) 
	private String matricula;
	
	@Column(length=20)
	private String telefone;
	
	@Column(length=15)
	private String cpf;
	
	private Date dataNascimento;
	
	private AlunoStatus status = AlunoStatus.NOVO;
	
	@ManyToOne
	private Curso curso;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private Usuario usuario;
	
	@OneToMany(mappedBy="aluno", cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.JOIN)
	private List<VagaEstagio> vagasEstagio;

	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public AlunoStatus getStatus() {
		return status;
	}

	public void setStatus(AlunoStatus status) {
		this.status = status;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setVagasEstagio(List<VagaEstagio> vagasEstagio) {
		this.vagasEstagio = vagasEstagio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", status=" + status + ", curso=" + curso + ", usuario="
				+ usuario + ", vagasEstagio=" + vagasEstagio + "]";
	}
	
}
