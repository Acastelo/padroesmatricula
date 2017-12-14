package com.j7ss.view.aluno;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.MD5;
import com.j7ss.core.Messages;
import com.j7ss.core.WebContext;
import com.j7ss.dao.AlunoDao;
import com.j7ss.entity.Aluno;
import com.j7ss.entity.constraint.Page;

@ManagedBean
@ViewScoped
public class AlunoCadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Aluno aluno;
	private AlunoDao alunoDao = new AlunoDao();
	
	public void save(){
		try {
			String password = aluno.getSenha();
			
			aluno.setSenha(MD5.md5(password));
			alunoDao.save(aluno);
			
			Messages.showGrowlInfo("Cadastro de Alunos", "Cadastrado com sucesso!");
			WebContext.redirect(Page.INDEX);
			
		} catch (Exception e) {
			Messages.showGrowlErro("Cadastro de Alunos", e.getMessage());
		}
	}
	
//******************************************************************************************************************************
//## Getters Setters
	public Aluno getAluno() {
		return aluno == null ? aluno = new Aluno() : aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
