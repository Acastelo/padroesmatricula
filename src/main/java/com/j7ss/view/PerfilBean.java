package com.j7ss.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.DAOException;
import com.j7ss.core.Messages;
import com.j7ss.entity.Usuario;

@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void update(){
		try {
			if(getUsuario().isTypeAluno()){
				getUsuario().getAluno().save();
			}
			loginBean.getUsuario().save();
			Messages.showGrowlInfo("Meu Perfil", "Meu Perfil salvo com sucesso!");
		} catch (DAOException e) {
			Messages.showGrowlInfo("Meu Perfil", e.getMessage());
		}
	}
	
	
//******************************************************************************************************************************
//## Getters Setters
	public Usuario getUsuario(){
		return loginBean.getUsuario();
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
}
