package com.unelev.projetosia.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.unelev.projetosia.business.ControleAcesso;
import com.unelev.projetosia.entity.Atendente;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean{

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * efetua login do usuário no sistema armazenando o seus dados 
	 * na sessao
	 * 
	 * @return
	 */
	public String login(){
		
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		ControleAcesso controle = new ControleAcesso();
		
		/*Atendente atendente = new Atendente();
		atendente.setMatAtendente(new Long(getName()));
		atendente.setPassAtendente(getPassword());*/
		
		Atendente atendente = new Atendente();
		atendente.setMatAtendente(new Long("05854283956"));
		atendente.setPassAtendente("filp01fl");
		
		Object currentUser = controle.buscarAtendenteMatricula(atendente);
		
	    if(currentUser != null){
	       session.setAttribute("currentUser", currentUser);
	       return "success";
	    }
		
	    return "loginPage";
		
	}

}
