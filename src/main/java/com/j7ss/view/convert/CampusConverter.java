package com.j7ss.view.convert;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.j7ss.entity.Campus;
import com.j7ss.view.aluno.AlunoCadastroBean;

@ManagedBean
@ViewScoped
public class CampusConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{alunoCadastroBean}")
	private AlunoCadastroBean alunoCadastroBean;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//return alunoCadastroBean.getCampusByNome(value);
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return (value != null) ? ((Campus) value).getNome() : null;
	}

	public AlunoCadastroBean getAlunoCadastroBean() {
		return alunoCadastroBean;
	}

	public void setAlunoCadastroBean(AlunoCadastroBean alunoCadastroBean) {
		this.alunoCadastroBean = alunoCadastroBean;
	}
	
	

}
