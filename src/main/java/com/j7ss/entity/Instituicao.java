package com.j7ss.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "instituicao")
public class Instituicao extends BaseEntity<Integer>{

	private String nome;
	
	@Column(length=80)
	private String email;
	
	@Column(length=20)
	private String telefone;
	
	private String responsavel;
	
	@OneToMany(mappedBy="instituicao", cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.JOIN)
	private List<Campus> campus;
	
	@OneToMany(mappedBy="instituicao")
	private List<Usuario> usuarios;
	
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public List<Campus> getCampus() {
		return campus;
	}

	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
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
		Instituicao other = (Instituicao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instituicao [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", responsavel="
				+ responsavel + ", campus=" + campus + ", usuarios=" + usuarios + "]";
	}
	
}
