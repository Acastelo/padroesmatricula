package com.j7ss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

@Entity
@Table(name = "campus")
public class Campus implements IGenericEntity<Campus>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@Column(length=20)
	private String telefone;
	
	@Column(length=80)   
	private String email;
	
	private String endereco;
	
	@Column(length=10)
	private String numero;
	
	private String bairro;
	
	@Column(length=10)
	private String cep;
	
	@Column(length=2)
	private String uf;
	
	private String cidade;
	
	@ManyToOne
	private Instituicao instituicao = new Instituicao();
	
	@OneToMany(mappedBy="campus", cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.JOIN)
	private List<Departamento> departamentos;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	//******************************************************************************************************************************
//## Builder
	public Campus id(Integer id){
		this.id = id;
		return this;
	}
	
	public Campus nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public Campus telefone(String telefone){
		this.telefone = telefone;
		return this;
	}
	
	public Campus email(String email){
		this.email = email;
		return this;
	}
	
	public Campus instituicao(Instituicao instituicao){
		this.instituicao = instituicao;
		return this;
	}
	
	public Campus addDepartamento(Departamento departamento){
		if(departamentos == null){
			departamentos = new ArrayList<>();
		}
		departamentos.add(departamento);
		return this;
	}
	
	public Campus removeDepartamento(Departamento departamento){
		if(departamentos != null){
			departamentos.remove(departamento);
		}
		return this;
	}
	
	public Campus endereco(String endereco){
		this.endereco = endereco;
		return this;
	}
	
	public Campus bairro(String bairro){
		this.bairro = bairro;
		return this;
	}
	
	public Campus cep(String cep){
		this.cep = cep;
		return this;
	}
	
	public Campus cidade(String cidade){
		this.cidade = cidade;
		return this;
	}
	
	public Campus uf(String uf){
		this.uf = uf;
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
	private static DAO<Campus> dao = new DAO<Campus>(Campus.class);
	
	@Override
	public Campus save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}

	public static List<Campus> findByNomeLike(Instituicao instituicao, String nome){
		return dao.findByQuery("SELECT i FROM Campus i WHERE i.instituicao = ?1 AND lower(i.nome) like ?2" ,instituicao, "%"+nome.toLowerCase()+"%");
	}
}
