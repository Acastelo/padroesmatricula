package com.j7ss.view.admin;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.Messages;
import com.j7ss.dao.AlunoDao;
import com.j7ss.entity.Aluno;

@ManagedBean
@ViewScoped
public class AdminAlunoBean {
	private static final long serialVersionUID = 1L;
	
	public Aluno entity;
	public List<Aluno> entities;
	public AlunoDao alunoDao = new AlunoDao();
	
//******************************************************************************************************************************
//## Growl Messages
	public void onRemove(Aluno entity) {
		Messages.showGrowlInfo("Aluno", "Aluno <strong>{0}</strong> removido com sucesso!", entity.getUsuario().getNome());
	}
	
	
//******************************************************************************************************************************
//## Getters Setters
	public Aluno getEntity() {
		return entity == null ? entity = new Aluno() : entity;
	}
	
	public List<Aluno> getEntitys() {
		return entities == null ? entities = alunoDao.findAll() : entities;
	}
}
