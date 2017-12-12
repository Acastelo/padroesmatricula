package com.j7ss.view.instituicao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.BasicView;
import com.j7ss.entity.DocumentoVagaEstagio;

@ManagedBean
@ViewScoped
public class InstituicaoHomeBean extends BasicView<DocumentoVagaEstagio> {
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
//		try {
//			new MailApi().to("alexandre@gmail.com", "Luiz Alexandre").subject("titulo").content("message").send();
//		} catch (MailApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	

}
