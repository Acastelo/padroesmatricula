package com.j7ss.entity.constraint;

public enum AlunoStatus {

	// Quando o aluno se cadastra, seu status é 'NOVO'
	NOVO("label-primary", "Novo"), 		
	
	// Após concluir todo o wizard de cadastro, seu status passa a ser 'VERIFICAR'
	VERIFICAR("label-warning", "Verificar"),	
	
	// Um funcionário, deve verificar se os dados deste aluno está correto, caso ok, seu status será 'VALIDO'
	VALIDO("label-success", "Válido"), 			
	
	// Se durante a validação do cadastro do aluno, o funcionário detectar algum erro, seu status será 'INVALIDO'
	INVALIDO("label-danger", "Inválido");		
	
	private String color; 
	private String title;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private AlunoStatus(String color, String title) {
		this.color = color;
		this.title = title;
	}
}
