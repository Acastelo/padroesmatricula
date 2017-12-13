package com.j7ss.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.j7ss.core.DAOException;
import com.j7ss.core.MD5;
import com.j7ss.core.Messages;
import com.j7ss.dao.UsuarioDao;
import com.j7ss.entity.Usuario;

@ManagedBean
@ViewScoped
public class MudarSenhaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String senhaAtual = "";
	private String novaSenha = "";
	private String confirmSenha = "";
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public String getSenhaAtual() {
		return senhaAtual;
	}



	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}



	public String getNovaSenha() {
		return novaSenha;
	}



	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}



	public String getConfirmSenha() {
		return confirmSenha;
	}



	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}



	public LoginBean getLoginBean() {
		return loginBean;
	}



	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}



	public void mudarSenha() throws DAOException{
		if(!senhaAtual.equals("") && MD5.md5(senhaAtual).equals(loginBean.getUsuario().getSenha())){
			if(!novaSenha.equals("") && !confirmSenha.equals("") && novaSenha.equals(confirmSenha)){
				loginBean.getUsuario().getSenha(MD5.md5(novaSenha));
				Messages.showGrowlInfo("Mudar Senha", "Senha alterada com sucesso!");
				RequestContext.getCurrentInstance().execute("PF('modalMudarSenha').hide();");
			}else{
				Messages.showGrowlWarn("Mudar senha", "<strong>Nova Senha</strong> deve ser igual ao <strong>Confirme Senha</strong>");
			}
		}else{
			Messages.showGrowlWarn("Mudar senha", "<strong>Senha Atual</strong> informada esta incorreta!");
		}
	}
}