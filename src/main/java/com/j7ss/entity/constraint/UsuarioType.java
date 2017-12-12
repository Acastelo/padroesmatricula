package com.j7ss.entity.constraint;

public enum UsuarioType {

	ADMINISTRADOR(
			Page.PERFIL,
			Page.ADMIN_HOME,
			Page.ADMIN_ALUNO,
			Page.ADMIN_INSTITUICAO,
			Page.ADMIN_USUARIO,
			Page.ADMIN_DOCUMENTO
			), 	
	INSTITUICAO(
			Page.PERFIL,
			Page.INSTITUICAO_HOME,
			Page.INSTITUICAO_ALUNO,
			Page.INSTITUICAO_DOCUMENTO,
			Page.INSTITUICAO_DOCUMENTO_CONCLUIR
			), 
	ALUNO(	
			Page.PERFIL,
			Page.ALUNO_HOME,
			Page.ALUNO_COMPLETE_CADASTRO
			);
	
	private String[] pages;
	
	public String[] getPages() {
		return pages;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
	}

	private UsuarioType(String...pages) {
		this.pages = pages;
	}
}
