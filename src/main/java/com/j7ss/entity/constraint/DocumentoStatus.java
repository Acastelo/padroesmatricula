package com.j7ss.entity.constraint;

public enum DocumentoStatus {

	// Documento não disponível para submeter
	INDISPONIVEL("fa-times","", "Não Disponível"), 
	
	// Disponível para edição e submissão
	DISPONIVEL("fa-check", "blue", "Disponível"), 
	
	// Aguardando verificação/Validação do setor de estágios do IFCE
	AGUARDANDO_VERIFICACAO("fa-clock-o", "yellow", "Aguardando verificação da instituição"), 
	
	// Setor de estágios está verificando este documento
	VERIFICANDO("fa-play-circle-o", "purple", "Verificando"), 
	
	// Após verificação do setor de estágio, foi detectado erros
	VERIFICADO_COM_ERRO("fa-warning", "red", "Verificado com erros"), 
	
	// Disponível para downloads e assinaturas
	DISPONIVEL_DOWNLOAD("fa-download", "green", "Disponível para Download"),
	
	// Documento concluído
	CONCLUIDO("fa-check-circle", "", "Concluído");

	
	private String icon;
	private String titulo;
	private String cor;
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	private DocumentoStatus(String icon, String cor, String titulo) {
		this.icon = icon;
		this.cor = cor;
		this.titulo = titulo;
	}
}
