package com.j7ss.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;
import com.j7ss.entity.constraint.VagaEstagioAtividadeDiariaStatus;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
@Entity
@Table(name = "vaga_estagio_atividade_diaria")
public class VagaEstagioAtividadeDiaria implements IGenericEntity<VagaEstagioAtividadeDiaria>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date date;
	
	private String descricao;
	
	
	@ManyToOne
	private VagaEstagio vagaEstagio;
	
	private Integer quantidadeHoras;	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	
//******************************************************************************************************************************
//## Builder
	public VagaEstagioAtividadeDiaria id(Integer id){
		this.id = id;
		return this;
	}
	
	public VagaEstagioAtividadeDiaria date(Date date){
		this.date = date;
		return this;
	}
	
	public VagaEstagioAtividadeDiaria descricao(String descricao){
		this.descricao = descricao;
		return this;
	}
	
	public VagaEstagioAtividadeDiaria quantidadeHoras(Integer quantidadeHoras){
		this.quantidadeHoras = quantidadeHoras;
		return this;
	}
	
	public VagaEstagioAtividadeDiaria vagaEstagio(VagaEstagio vagaEstagio){
		this.vagaEstagio = vagaEstagio;
		return this;
	}
	
	public VagaEstagioAtividadeDiaria status(VagaEstagioAtividadeDiariaStatus status){
		this.status = status;
		return this;
	}
	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}
	
	public boolean isStatusNova(){
		return VagaEstagioAtividadeDiariaStatus.NOVA.equals(status);
	}
	
	public boolean isStatusOk(){
		return VagaEstagioAtividadeDiariaStatus.OK.equals(status);
	}
	
	
//******************************************************************************************************************************
//## DAO
	private static DAO<VagaEstagioAtividadeDiaria> dao = new DAO<VagaEstagioAtividadeDiaria>(VagaEstagioAtividadeDiaria.class);
	
	@Override
	public VagaEstagioAtividadeDiaria save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static List<VagaEstagioAtividadeDiaria> findByVagaEstagio(VagaEstagio vagaEstagio){
		return dao.findByQuery("Select v From VagaEstagioAtividadeDiaria v Where v.vagaEstagio = ?1", vagaEstagio);
	}
}
