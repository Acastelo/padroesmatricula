package com.j7ss.view.aluno;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.j7ss.entity.VagaEstagio;
import com.j7ss.view.LoginBean;

@ManagedBean
@ViewScoped
public class AlunoCompleteCadastroBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private VagaEstagio vagaEstagio;
	

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public void setVagaEstagio(VagaEstagio vagaEstagio) {
		this.vagaEstagio = vagaEstagio;
	}

	/*public void concluir(){
		try {
			if(!loginBean.getUsuario().getAluno().getStatus().equals(AlunoStatus.VALIDO)){
				loginBean.getUsuario().getAluno().setStatus(AlunoStatus.VERIFICAR).save();
			}
			WebContext.redirect(Page.ALUNO_HOME);
		} catch (Exception e) {
			Messages.showGrowlErro("Cadastro de Aluno", e.getMessage());
		}
	}
	
	public String onFlowProcess(FlowEvent event) {
		try {
			// Aluno/Usuario informacoes gerais
			if(event.getOldStep().equals("aluno") || event.getOldStep().equals("endereco")){
				loginBean.getUsuario().getAluno().save();
				
			// Vaga de estagio	
			}else if(event.getOldStep().equals("vagaEstagio") || event.getOldStep().equals("vagaEstagioConcluir")){
				if(loginBean.getUsuario().getAluno().getVagasEstagio().size() == 0){
					loginBean.getUsuario().getAluno().addVagaEstagio(vagaEstagio);
				}else{
					vagaEstagio.save();
				}
			
			// Empresa
			}else if(event.getOldStep().equals("empresa")){
				vagaEstagio.getEmpresa().save();
				vagaEstagio.empresa(vagaEstagio.getEmpresa()).save();
				
			// Empresa Supervisor
			}else if(event.getOldStep().equals("empresaSupervisor")){
				vagaEstagio.getEmpresaSupervisor().empresa(vagaEstagio.getEmpresa()).save();	
				vagaEstagio.empresaSupervisor(vagaEstagio.getEmpresaSupervisor()).save();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event.getNewStep(); 
    }
	
//******************************************************************************************************************************
//## Getters Setters
	public Aluno getAluno(){
		return loginBean.getUsuario().getAluno();
	}
	
	public VagaEstagio getVagaEstagio() {
		if(vagaEstagio != null){
			return vagaEstagio;
		}else{
			if(loginBean.getUsuario().getAluno().getVagasEstagio().size() == 0){
				vagaEstagio = new VagaEstagio();
			}else{
				vagaEstagio = loginBean.getUsuario().getAluno().getVagasEstagio().get(0);
			}
			return vagaEstagio;
		}
	}*/

}
