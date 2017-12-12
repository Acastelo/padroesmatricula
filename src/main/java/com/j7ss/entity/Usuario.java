package com.j7ss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.j7ss.core.DAO;
import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;
import com.j7ss.core.MD5;
import com.j7ss.entity.constraint.UsuarioType;

@Entity
@Table(name = "usuario")
public class Usuario implements IGenericEntity<Usuario>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@Column(unique=true, length=80)
	private String email;
	
	private String senha;
	
	private UsuarioType tipoUsuario;
	
	private Boolean emailValido = false;
	
	private Boolean ativo = true;
	
	private String instituicaoFilter;
	
	@OneToOne
	private Instituicao instituicao;
	
	@OneToOne
	private Aluno aluno;
	
	
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioType getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioType tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getEmailValido() {
		return emailValido;
	}

	public void setEmailValido(Boolean emailValido) {
		this.emailValido = emailValido;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getInstituicaoFilter() {
		return instituicaoFilter;
	}

	public void setInstituicaoFilter(String instituicaoFilter) {
		this.instituicaoFilter = instituicaoFilter;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	//******************************************************************************************************************************
//## Builder
	public Usuario id(Integer id){
		this.id = id;
		return this;
	}
	
	public Usuario nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public Usuario email(String email){
		this.email = email;
		return this;
	}
	
	public Usuario senha(String senha){
		this.senha = senha;
		return this;
	}
	
	public Usuario senhaMD5(String senha){
		this.senha = MD5.md5(senha);
		return this;
	}
	
	public Usuario tipoUsuario(UsuarioType tipoUsuario){
		this.tipoUsuario = tipoUsuario;
		return this;
	}
	
	public Usuario emailValido(Boolean emailValido){
		this.emailValido = emailValido;
		return this;
	}
	
	public Usuario ativo(Boolean ativo){
		this.ativo = ativo;
		return this;
	}
	
	public Usuario aluno(Aluno aluno){
		this.aluno = aluno;
		return this;
	}
	
	public Usuario instituicao(Instituicao instituicao){
		this.instituicao = instituicao;
		return this;
	}

	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public boolean isNew() {
		return id == null;
	}
	
	public boolean isTypeAluno() {
		return tipoUsuario.equals(UsuarioType.ALUNO);
	}
	
	public boolean isTypeInstituicao() {
		return tipoUsuario.equals(UsuarioType.INSTITUICAO);
	}
	
	public boolean isTypeAdmin() {
		return tipoUsuario.equals(UsuarioType.ADMINISTRADOR);
	}
	
	public Aluno getAluno() {
		return aluno == null ? aluno = new Aluno() : aluno;
	}
	
	public Instituicao getInstituicao() {
		return instituicao == null ? instituicao = new Instituicao() : instituicao;
	}
	
	
//******************************************************************************************************************************
//## DAO
	private static DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
	
	@Override
	public Usuario save() throws DAOException{
		return isNew() ? dao.add(this) : dao.update(this);
	}

	@Override
	public boolean remove() throws DAOException {
		return dao.remove(this);
	}
	
	public static List<Usuario> findAllMinusAluno(){
		return dao.findByQuery("SELECT u FROM Usuario u WHERE u.tipoUsuario != ?1", UsuarioType.ALUNO);
	}
	
	public static List<Usuario> findByEmailAndSenha(String email, String senha){
		return dao.findByQuery("SELECT u FROM Usuario u WHERE u.email = ?1 and u.senha = ?2", email, senha);
	}
	
}
