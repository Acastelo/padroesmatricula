package com.j7ss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento extends BaseEntity<Integer>{

	private String nome;
	
	private String titulo;
	
	@Column(columnDefinition="text")
	private String descricao;
	
	@Column(columnDefinition="text")
	private String htmlPage;
	
	private Boolean extra = false;
	
	private Boolean obrigatorio = true;
	
	@Column(columnDefinition="text")
	private String keys;
	
	
	@OneToMany(mappedBy="documento")
	@OrderBy("ordem")
	private List<DocumentoCurso> documentoCursos;
	
	@OneToMany(mappedBy="documento")
	@OrderBy("ordem")
	private List<DocumentoVagaEstagio> documentoVagasEstagio;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHtmlPage() {
		return htmlPage;
	}

	public void setHtmlPage(String htmlPage) {
		this.htmlPage = htmlPage;
	}

	public Boolean getExtra() {
		return extra;
	}

	public void setExtra(Boolean extra) {
		this.extra = extra;
	}

	public Boolean getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(Boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public List<DocumentoCurso> getDocumentoCursos() {
		return documentoCursos;
	}

	public void setDocumentoCursos(List<DocumentoCurso> documentoCursos) {
		this.documentoCursos = documentoCursos;
	}

	public List<DocumentoVagaEstagio> getDocumentoVagasEstagio() {
		return documentoVagasEstagio;
	}

	public void setDocumentoVagasEstagio(List<DocumentoVagaEstagio> documentoVagasEstagio) {
		this.documentoVagasEstagio = documentoVagasEstagio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((keys == null) ? 0 : keys.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Documento other = (Documento) obj;
		if (keys == null) {
			if (other.keys != null)
				return false;
		} else if (!keys.equals(other.keys))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Documento [nome=" + nome + ", titulo=" + titulo + ", descricao=" + descricao + ", htmlPage=" + htmlPage
				+ ", extra=" + extra + ", obrigatorio=" + obrigatorio + ", keys=" + keys + ", documentoCursos="
				+ documentoCursos + ", documentoVagasEstagio=" + documentoVagasEstagio + "]";
	}
	
}