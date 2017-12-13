package com.j7ss.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j7ss.entity.constraint.DocumentoStatus;

@Entity
@Table(name = "documento_vaga_estagio_message")
public class DocumentoVagaEstagioMessage extends BaseEntity<Integer> {

	@Column(columnDefinition="text")
	private String message;
	
	private Date date;
	
	private DocumentoStatus status;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private DocumentoVagaEstagio documentoVagaEstagio;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DocumentoStatus getStatus() {
		return status;
	}

	public void setStatus(DocumentoStatus status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setDocumentoVagaEstagio(DocumentoVagaEstagio documentoVagaEstagio) {
		this.documentoVagaEstagio = documentoVagaEstagio;
	}

	public DocumentoVagaEstagio getDocumentoVagaEstagio() {
		return documentoVagaEstagio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		DocumentoVagaEstagioMessage other = (DocumentoVagaEstagioMessage) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentoVagaEstagioMessage [message=" + message + ", date=" + date + ", status=" + status
				+ ", usuario=" + usuario + ", documentoVagaEstagio=" + documentoVagaEstagio + "]";
	}

	
}