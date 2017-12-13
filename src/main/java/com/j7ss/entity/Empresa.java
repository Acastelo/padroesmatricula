package com.j7ss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa extends BaseEntity<Integer>{

	private String nome;
	
	@Column(length=80)
	private String email;
	
	@Column(length=20)
	private String telefone;
	
	@Column(length=20)
	private String fax;
	
	@Column(length=20)
	private String cnpj;
	
	private String site;
	
	private String ramoAtividade;
	
	private String endereco;
	
	@Column(length=10)
	private String numero;
	
	private String bairro;
	
	@Column(length=10)
	private String cep;
	
	@Column(length=2)
	private String uf;
	
	private String cidade;
	
	@OneToMany(mappedBy="empresa")
	private List<VagaEstagio> vagaEstagios;
	
	@OneToMany(mappedBy="empresa")
	private List<EmpresaSupervisor> empresaSupervisors;
		
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
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

	public List<VagaEstagio> getVagaEstagios() {
		return vagaEstagios;
	}

	public void setVagaEstagios(List<VagaEstagio> vagaEstagios) {
		this.vagaEstagios = vagaEstagios;
	}

	public List<EmpresaSupervisor> getEmpresaSupervisors() {
		return empresaSupervisors;
	}

	public void setEmpresaSupervisors(List<EmpresaSupervisor> empresaSupervisors) {
		this.empresaSupervisors = empresaSupervisors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((empresaSupervisors == null) ? 0 : empresaSupervisors.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (empresaSupervisors == null) {
			if (other.empresaSupervisors != null)
				return false;
		} else if (!empresaSupervisors.equals(other.empresaSupervisors))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", fax=" + fax + ", cnpj="
				+ cnpj + ", site=" + site + ", ramoAtividade=" + ramoAtividade + ", endereco=" + endereco + ", numero="
				+ numero + ", bairro=" + bairro + ", cep=" + cep + ", uf=" + uf + ", cidade=" + cidade
				+ ", vagaEstagios=" + vagaEstagios + ", empresaSupervisors=" + empresaSupervisors + "]";
	}

}
