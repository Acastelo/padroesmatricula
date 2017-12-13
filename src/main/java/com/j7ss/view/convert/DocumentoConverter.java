package com.j7ss.view.convert;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.j7ss.entity.Documento;
import com.j7ss.view.admin.AdminInstituicaoBean;

@ManagedBean
@ViewScoped
public class DocumentoConverter implements Converter, Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{adminInstituicaoBean}")
	private AdminInstituicaoBean adminInstituicaoBean;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//return adminInstituicaoBean.getDocumentoByNome(value);
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return (value != null) ? ((Documento) value).getNome() : null;
	}

	public AdminInstituicaoBean getAdminInstituicaoBean() {
		return adminInstituicaoBean;
	}

	public void setAdminInstituicaoBean(AdminInstituicaoBean adminInstituicaoBean) {
		this.adminInstituicaoBean = adminInstituicaoBean;
	}
	

}
