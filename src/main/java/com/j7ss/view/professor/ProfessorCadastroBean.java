package com.j7ss.view.professor;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.Messages;
import com.j7ss.core.WebContext;
import com.j7ss.dao.ProfessorDao;
import com.j7ss.entity.Professor;
import com.j7ss.entity.constraint.Page;

@ManagedBean
@ViewScoped
public class ProfessorCadastroBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	private ProfessorDao professorDao = new ProfessorDao();
	
	public void save(){
		try {
			
			professorDao.save(professor);
			
			Messages.showGrowlInfo("Cadastro de Alunos", "Cadastrado com sucesso!");
			WebContext.redirect(Page.INDEX);
			
		} catch (Exception e) {
			Messages.showGrowlErro("Cadastro de Alunos", e.getMessage());
		}
	}
	
	public Professor getProfessor() {
		return professor == null ? professor = new Professor() : professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	

}
