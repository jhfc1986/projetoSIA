package com.unelev.projetosia.managedBeans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.unelev.projetosia.business.ControleAcesso;
import com.unelev.projetosia.entity.Atendente;

public class BeanRoot implements Serializable {
	
	protected String name;
	protected String password;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getResourceBundle(FacesContext context, String resource){
		String text="";
		
		try {
		    ResourceBundle bundle = ResourceBundle.getBundle("com.unelev.projetosia.resources.messages", context.getViewRoot().getLocale());
		    text = bundle.getString(resource);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return text;
	}
	
	public String login(){
		
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		ControleAcesso controle = new ControleAcesso();
		
		Object user = session.getAttribute("currentUser");
		
		if(user == null){
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
		 }else{
	    	return "success";
	     }
		
	     return "loginPage";
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
