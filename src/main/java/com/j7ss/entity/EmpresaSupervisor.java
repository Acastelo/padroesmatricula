package com.j7ss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

@Entity
@Table(name = "empresa_supervisor")
public class EmpresaSupervisor implements IGenericEntity<EmpresaSupervisor> {
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String supervisor;
	
	private String cargoSupervisor;
	
	@Column(length=20)
	private String telefoneSupervisor;
		
	@ManyToOne
	private Empresa empresa;
	
	@OneToMany(mappedBy="empresaSupervisor")
	private List<VagaEstagio> vagaEstagios;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	//******************************************************************************************************************************	
//## Builder
	public EmpresaSupervisor id(Integer id){
		this.id = id;
		return this;
	}
	
	public EmpresaSupervisor supervisor(String supervisor){
		this.supervisor = supervisor;
		return this;
	}
	
	public EmpresaSupervisor cargoSupervisor(String cargoSupervisor){
		this.cargoSupervisor = cargoSupervisor;
		return this;
	}
	
	public EmpresaSupervisor telefoneSupervisor(String telefoneSupervisor){
		this.telefoneSupervisor = telefoneSupervisor;
		return this;
	}
	
	public EmpresaSupervisor empresa(Empresa empresa){
		this.empresa = empresa;
		return this;
	}

//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}
	
	
//******************************************************************************************************************************
//## DAO
	private static DAO<EmpresaSupervisor> dao = new DAO<EmpresaSupervisor>(EmpresaSupervisor.class);
	
	@Override
	public EmpresaSupervisor save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static List<EmpresaSupervisor> findAll(){
		return dao.findAll();
	}
}
