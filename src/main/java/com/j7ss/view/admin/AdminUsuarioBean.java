package com.j7ss.view.admin;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.entity.Instituicao;

@ManagedBean
@ViewScoped
public class AdminUsuarioBean {
	private static final long serialVersionUID = 1L;
	
	private List<Instituicao> instituicaos;

	
}
