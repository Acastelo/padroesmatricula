package com.j7ss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_supervisor")
public class EmpresaSupervisor extends BaseEntity<Integer> {
	
	private String supervisor;
	
	private String cargoSupervisor;
	
	@Column(length=20)
	private String telefoneSupervisor;
		
	@ManyToOne
	private Empresa empresa;
	
	@OneToMany(mappedBy="empresaSupervisor")
	private List<VagaEstagio> vagaEstagios;
	
	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getCargoSupervisor() {
		return cargoSupervisor;
	}

	public void setCargoSupervisor(String cargoSupervisor) {
		this.cargoSupervisor = cargoSupervisor;
	}

	public String getTelefoneSupervisor() {
		return telefoneSupervisor;
	}

	public void setTelefoneSupervisor(String telefoneSupervisor) {
		this.telefoneSupervisor = telefoneSupervisor;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<VagaEstagio> getVagaEstagios() {
		return vagaEstagios;
	}

	public void setVagaEstagios(List<VagaEstagio> vagaEstagios) {
		this.vagaEstagios = vagaEstagios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
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
		EmpresaSupervisor other = (EmpresaSupervisor) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpresaSupervisor [supervisor=" + supervisor + ", cargoSupervisor=" + cargoSupervisor
				+ ", telefoneSupervisor=" + telefoneSupervisor + ", empresa=" + empresa + ", vagaEstagios="
				+ vagaEstagios + "]";
	}
	
}
