package com.j7ss.view.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

import com.j7ss.core.DAOException;
import com.j7ss.core.Messages;
import com.j7ss.entity.Campus;
import com.j7ss.entity.Curso;
import com.j7ss.entity.Departamento;
import com.j7ss.entity.Documento;
import com.j7ss.entity.Instituicao;

@ManagedBean
@ViewScoped
public class AdminInstituicaoBean {
	private static final long serialVersionUID = 1L;
	
	private TreeNode root;
	private TreeNode selectedNode;

	private Campus campus;
	private Departamento departamento;
	private Curso curso;
	
	private boolean showCampus;
	private boolean showDepartamento;
	private boolean showCurso;
	
	private List<Documento> documentos;
	private DualListModel<Documento> pickListDocumentos;
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public boolean isShowCampus() {
		return showCampus;
	}

	public void setShowCampus(boolean showCampus) {
		this.showCampus = showCampus;
	}

	public boolean isShowDepartamento() {
		return showDepartamento;
	}

	public void setShowDepartamento(boolean showDepartamento) {
		this.showDepartamento = showDepartamento;
	}

	public boolean isShowCurso() {
		return showCurso;
	}

	public void setShowCurso(boolean showCurso) {
		this.showCurso = showCurso;
	}

	public DualListModel<Documento> getPickListDocumentos() {
		return pickListDocumentos;
	}

	public void setPickListDocumentos(DualListModel<Documento> pickListDocumentos) {
		this.pickListDocumentos = pickListDocumentos;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

}
