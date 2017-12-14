package com.j7ss.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.entity.constraint.AlunoStatus;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	private String senha;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<VagaEstagio> getVagasEstagio() {
		return vagasEstagio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", matricula="
				+ matricula + ", telefone=" + telefone + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", status=" + status + ", curso=" + curso + ", usuario=" + usuario + ", vagasEstagio=" + vagasEstagio
				+ "]";
	}

}
