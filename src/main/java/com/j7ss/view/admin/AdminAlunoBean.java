package com.j7ss.view.admin;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.BasicView;
import com.j7ss.core.Messages;
import com.j7ss.entity.Aluno;

@ManagedBean
@ViewScoped
public class AdminAlunoBean extends BasicView<Aluno>{
	private static final long serialVersionUID = 1L;
	
	
	
	
	
//******************************************************************************************************************************
//## Growl Messages
	@Override
	public void onRemove(Aluno entity) {
		Messages.showGrowlInfo("Aluno", "Aluno <strong>{0}</strong> removido com sucesso!", entity.getUsuario().getNome());
	}
	
	
//******************************************************************************************************************************
//## Getters Setters
	@Override
	public Aluno getEntity() {
		return entity == null ? entity = new Aluno() : entity;
	}
	
	@Override
	public List<Aluno> getEntitys() {
		return entitys == null ? entitys = Aluno.findAll() : entitys;
	}
}
