package com.j7ss.view.convert;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.j7ss.entity.Instituicao;
import com.j7ss.view.admin.AdminUsuarioBean;

@ManagedBean
@ViewScoped
public class InstituicaoUsuarioConverter implements Converter, Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{adminUsuarioBean}")
	private AdminUsuarioBean adminUsuarioBean;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return adminUsuarioBean.getInstituicaoByNome(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return (value != null) ? ((Instituicao) value).getNome() : null;
	}

	public void setAdminUsuarioBean(AdminUsuarioBean adminUsuarioBean) {
		this.adminUsuarioBean = adminUsuarioBean;
	}
	

}
