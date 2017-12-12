package com.j7ss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;

@Entity
@Table(name = "instituicao")
public class Instituicao implements IGenericEntity<Instituicao>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
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

	//******************************************************************************************************************************
//## Builder
	public Instituicao id(Integer id){
		this.id = id;
		return this;
	}
	
	public Instituicao nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public Instituicao email(String email){
		this.email = email;
		return this;
	}
	
	public Instituicao telefone(String telefone){
		this.telefone = telefone;
		return this;
	}
	
	public Instituicao responsavel(String responsavel){
		this.responsavel = responsavel;
		return this;
	}
	
	public Instituicao addCampus(Campus campu){
		if(campus == null){
			campus = new  ArrayList<>();
		}
		campus.add(campu);
		return this;
	}
	
	public Instituicao removeCampus(Campus campu){
		if(campus != null){
			campus.remove(campu);
		}
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
	private static DAO<Instituicao> dao = new DAO<Instituicao>(Instituicao.class);
	
	@Override
	public Instituicao save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static List<Instituicao> findAll(){
		return dao.findByQuery("SELECT i FROM Instituicao i"); //JOIN FETCH i.campus c
	}
	
	public static Instituicao findById(Integer idInstituicao){
		return dao.findOne(idInstituicao);
	}
	
	public static List<Instituicao> findByNomeLike(String nome){
		return dao.findByQuery("SELECT i FROM Instituicao i WHERE lower(i.nome) like ?1" , "%"+nome.toLowerCase()+"%");
	}
	
	public static List<Instituicao> findByNome(String nome){
		return dao.findByQuery("SELECT i FROM Instituicao i WHERE i.nome = ?1" , nome);
	}
	
	public static Instituicao findByIdUsuario(Integer idUsuario){
		return dao.findOneByQuery("SELECT i FROM Instituicao i WHERE i.idUsuario = ?1" , idUsuario);
	}

}
