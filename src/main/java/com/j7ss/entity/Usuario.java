package com.j7ss.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.j7ss.entity.constraint.UsuarioType;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(unique=true, length=80)
	private String email;
	
	private String senha;
	
	private UsuarioType tipoUsuario;
	
	private Boolean emailValido = false;
	
	private Boolean ativo = true;
	
	private String instituicaoFilter;
	
	@OneToOne
	private Instituicao instituicao;
	
	@OneToOne
	private Aluno aluno;
	
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

	public UsuarioType getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioType tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getEmailValido() {
		return emailValido;
	}

	public void setEmailValido(Boolean emailValido) {
		this.emailValido = emailValido;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getInstituicaoFilter() {
		return instituicaoFilter;
	}

	public void setInstituicaoFilter(String instituicaoFilter) {
		this.instituicaoFilter = instituicaoFilter;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void getSenha(String md5) {
		getSenha();
		
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", tipoUsuario="
				+ tipoUsuario + ", emailValido=" + emailValido + ", ativo=" + ativo + ", instituicaoFilter="
				+ instituicaoFilter + ", instituicao=" + instituicao + ", aluno=" + aluno + "]";
	}
	
	
	
}
