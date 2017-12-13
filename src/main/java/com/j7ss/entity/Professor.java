package com.j7ss.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends BaseEntity<Integer>{
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Professor other = (Professor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", qualificação=" + qualificação + ", idade=" + idade + ", cursoDarAula="
				+ cursoDarAula + "]";
	}

}
