/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@j7ss.com ( http://www.j7ss.com )
 * 
 * @copyright  	Copyright 2010 - 2016 J7 Smart Solutions, all rights reserved.
 * 
 */
package com.j7ss.entity.constraint;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public enum UsuarioType {

	ADMINISTRADOR(
			"perfil", 
			"adminHome", 
			"adminAluno", 
			"adminInstituicao", 
			"adminUsuario", 
			"adminDocumento"), 
				
	INSTITUICAO(
			"perfil", 
			"instituicaoHome",
			"instituicaoAluno",
			"instituicaoDocumento"), 
	
	ALUNO(	
			"perfil", 
			"alunoHome", 
			"alunoCompleteCadastro", 
			"alunoVagaEstagio",
			"alunoAtividadeDiaria",
			"alunoDocumento");
	
	private String[] pages;
	
	private UsuarioType(String...pages) {
		this.pages = pages;
	}
	
	public String[] getPages() {
		return pages;
	}
}
