package com.j7ss.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j7ss.entity.constraint.VagaEstagioAtividadeDiariaStatus;

@Entity
@Table(name = "vaga_estagio_atividade_diaria")
public class VagaEstagioAtividadeDiaria extends BaseEntity<Integer>{

	private Date date;
	private String descricao;
	
	@ManyToOne
	private VagaEstagio vagaEstagio;
	
	private Integer quantidadeHoras;	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public VagaEstagio getVagaEstagio() {
		return vagaEstagio;
	}

	public void setVagaEstagio(VagaEstagio vagaEstagio) {
		this.vagaEstagio = vagaEstagio;
	}

	public VagaEstagioAtividadeDiariaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaEstagioAtividadeDiariaStatus status) {
		this.status = status;
	}

	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	private VagaEstagioAtividadeDiariaStatus status = VagaEstagioAtividadeDiariaStatus.NOVA;

	@Override
	public String toString() {
		return "VagaEstagioAtividadeDiaria [date=" + date + ", descricao=" + descricao + ", vagaEstagio=" + vagaEstagio
				+ ", quantidadeHoras=" + quantidadeHoras + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((vagaEstagio == null) ? 0 : vagaEstagio.hashCode());
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
		VagaEstagioAtividadeDiaria other = (VagaEstagioAtividadeDiaria) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (vagaEstagio == null) {
			if (other.vagaEstagio != null)
				return false;
		} else if (!vagaEstagio.equals(other.vagaEstagio))
			return false;
		return true;
	}
	
	
	
}
