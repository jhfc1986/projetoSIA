package com.unelev.projetosia.business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.unelev.projetosia.dao.AtendenteDAO;
import com.unelev.projetosia.entity.Atendente;

public class ControleAcesso {
	
	/**
	 * 
	 * @param atendente
	 * @return
	 */
	public Atendente buscarAtendenteMatricula(Atendente atendente){
		
		AtendenteDAO dao = new AtendenteDAO();
		atendente.setPassAtendente(criptografarSenha(atendente.getPassAtendente()));
		atendente = dao.buscarAtendenteMatricula(atendente);
		return atendente;
	}
	
	/**
	 * 
	 * @param atendente
	 */
	public void salvarAtendente(Atendente atendente){
	    
		AtendenteDAO dao = new AtendenteDAO();
		atendente.setMatAtendente(atendente.getCpfAtendente());
		atendente.setPassAtendente(criptografarSenha(atendente.getPassAtendente()));
		dao.salvar(atendente);
		
	}
		
	/**
	 * 
	 * @param senha
	 * @return
	 */
	private String criptografarSenha(String senha){
		
		String password = senha;
		 
        MessageDigest md;
		
        try {
			
        	md = MessageDigest.getInstance("SHA-256");
		    md.update(password.getBytes());
 
            byte byteData[] = md.digest();
 
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
 
            password = sb.toString();
        
          } catch (NoSuchAlgorithmException e) {
              e.printStackTrace();
		  }
        
          return password;
	}

}
