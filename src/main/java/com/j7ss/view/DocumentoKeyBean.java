package com.j7ss.view;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.j7ss.entity.constraint.DocumentoKey;

@ManagedBean
@ApplicationScoped
public class DocumentoKeyBean {

	public String getUsuario(){
		return DocumentoKey.getUsuario();
	}
	
	public String getAluno(){
		return DocumentoKey.getAluno();
	}
	
	public String getEmpresa(){
		return DocumentoKey.getEmpresa();
	}
	
	public String getVagaEstagio(){
		return DocumentoKey.getVagaEstagio();
	}
	
	public String getInstituicao(){
		return DocumentoKey.getInstituicao();
	}
	
	public String getCampus(){
		return DocumentoKey.getCampus();
	}
	
	public String getDepartamento(){
		return DocumentoKey.getDepartamento();
	}
	
	public String getCurso(){
		return DocumentoKey.getCurso();
	}
}
