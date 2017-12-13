package com.j7ss.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.entity.constraint.DocumentoStatus;

@Entity
@Table(name = "documento_vaga_estagio")
public class DocumentoVagaEstagio extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;
	
	private Integer ordem;
	
	private DocumentoStatus status;

	@ManyToOne
	private VagaEstagio vagaEstagio;
	
	@ManyToOne
	private Documento documento;
	
	@OneToMany(mappedBy="documentoVagaEstagio", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("date")
	private List<DocumentoVagaEstagioMessage> documentoAlunoMessages;
	
	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public DocumentoStatus getStatus() {
		return status;
	}

	public void setStatus(DocumentoStatus status) {
		this.status = status;
	}

	public void setVagaEstagio(VagaEstagio vagaEstagio) {
		this.vagaEstagio = vagaEstagio;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public void setDocumentoAlunoMessages(List<DocumentoVagaEstagioMessage> documentoAlunoMessages) {
		this.documentoAlunoMessages = documentoAlunoMessages;
	}

	public VagaEstagio getVagaEstagio() {
		return vagaEstagio;
	}

	public Documento getDocumento() {
		return documento;
	}

	public List<DocumentoVagaEstagioMessage> getDocumentoAlunoMessages() {
		return documentoAlunoMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		DocumentoVagaEstagio other = (DocumentoVagaEstagio) obj;
		if (ordem == null) {
			if (other.ordem != null)
				return false;
		} else if (!ordem.equals(other.ordem))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentoVagaEstagio [ordem=" + ordem + ", status=" + status + ", vagaEstagio=" + vagaEstagio
				+ ", documento=" + documento + ", documentoAlunoMessages=" + documentoAlunoMessages + "]";
	}
	
	
}