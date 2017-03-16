package com.unelev.projetosia.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.unelev.projetosia.dao.AtendimentoDAO;
import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.util.Constantes;
import com.unelev.projetosia.util.Utils;


public class AtendimentoBusiness {
	
	/**
	 * 
	 * @param cliente
	 * @param atendimento
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorDataSSListAtendimentoCliente(Cliente cliente,Atendimento atendimento) {
		 AtendimentoDAO dao = new AtendimentoDAO();
		 List<Atendimento> atendimentos = dao.pesquisaAtendimentoPorDataSSListAtendimentoCliente(cliente,atendimento);
		 return atendimentos;
	}
	
	/**
	 * 
	 * @param atendimento
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorDataSSListAtendimento(Atendimento atendimento){
		 AtendimentoDAO dao = new AtendimentoDAO();
		 List<Atendimento> atendimentos = dao.pesquisaAtendimentoPorDataSSListAtendimento(atendimento);
		 return atendimentos;
	}
	
	/**
	 * 
	 * @param atendimento
	 * @return
	 */
    public List<Atendimento> pesquisaAtendimentoPorDataSS(Atendimento atendimento){
		
	    AtendimentoDAO dao = new AtendimentoDAO();
		List<Atendimento> atendimentos = dao. pesquisaAtendimentoPorDataSS(atendimento);
		return atendimentos;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoAtivos(){
		AtendimentoDAO dao = new AtendimentoDAO();
		List<Atendimento> atendimentos = dao.pesquisaAtendimentoAtivos();
		return atendimentos;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
    public List<Atendimento> pesquisaAtendimentoAbertosCliente(Cliente cliente){
		
	    AtendimentoDAO dao = new AtendimentoDAO();
		List<Atendimento> atendimentos = dao.pesquisaAtendimentoAbertoCliente(cliente);
		return atendimentos;
	}
    

	/**
	 * 
	 * @param cliente
	 * @return
	 */
    public List<Atendimento> pesquisaAtendimentoPorCliente(Cliente cliente){
		
	    AtendimentoDAO dao = new AtendimentoDAO();
		List<Atendimento> atendimentos = dao.pesquisaAtendimentoPorCliente(cliente);
		return atendimentos;
	}
    
	/**
	 * 
	 * @param cliente
	 * @return
	 */
    public List<Atendimento> pesquisaAtendimentoPorClienteDataSS(Cliente cliente,Atendimento atendimento){
		
	    AtendimentoDAO dao = new AtendimentoDAO();
		List<Atendimento> atendimentos = dao.pesquisaAtendimentoPorClienteDataSS(cliente,atendimento);
		return atendimentos;
	}
 
    /**
	 * 
	 * @param atendente
	 */
	public void salvarAtendimento(Atendimento atendimento){
	    
		AtendimentoDAO dao = new AtendimentoDAO();
	    Utils.formataData(atendimento.getDataAbertura());
	    dao.salvar(atendimento);
	}
    
	/**
	 * 
	 * metodo responsável por validar se os campos referentes
	 * aos dados do cliente estao preenchidos corretamente
	 * 
	 * @return
	 */
	public boolean validateAtendimento(Atendimento atendimento){
		
		boolean validAtm = true;
		
		if (atendimento.getDescricaoProblema() == null 
				|| atendimento.getDescricaoProblema().trim().equals(Constantes.STRING_BRANCO)){
			validAtm = false;
		}else if(atendimento.getDataAbertura()== null){
			validAtm = false;
		}else if(atendimento.getStatusPendencia() == null 
				|| atendimento.getStatusPendencia().trim().equals(Constantes.STRING_BRANCO)){
			validAtm = false;
		}
		return validAtm;
		
	}
	
	/**
	 * 
	 * metodo responsavel por validar se os campos da
	 * ficha de atendimento foram devidamente preenchidos
	 * 
	 * @return
	 */
	public boolean validateFichaAtendimento(Atendimento atendimento){
		boolean validAtm = true;
        
		SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy");
        Date menorData;
        try {
		   menorData = sdfSource.parse(Constantes.CHAMADOS_DT_MIN);
        
		   if(atendimento.getDataFechamento() != null && atendimento.getDataFechamento().before(menorData)){
		      return false;
		   }else if(atendimento.getDataFechamento() != null && atendimento.getDataFechamento().after(new Date())){
			  return false;
	 	   }else if(atendimento.getStatusAtPre()== null || atendimento.getStatusAtPre().equals("") ){
			  return false; 
	 	   }else if(atendimento.getStatusAtPos()== null || atendimento.getStatusAtPos().equals("")){
			  return false;
	 	   }		
        } catch (ParseException e) {
			e.printStackTrace();
		}
		
		return validAtm;
	}
	
	/**
	 * 
	 * metodo responsavel por validar a hora digitada 
	 * pelo usuario do sistema
	 * 
	 * @return
	 */
	public boolean validateHora(String hora){
		
		String[] valores = hora.split(":");
		
		boolean retorno = true;
		
		if(hora.equals("")){
			return false;
		}
		else if(new Integer(valores[0]) > 23){
			retorno = false;
		}else if(new Integer(valores[1])> 59){
			retorno = false;
		}
		
		return retorno;
		
	}
	
	/**
	 * 
	 * metodo responsavel por validar periodo de tempo
	 * da pesquisa.
	 * 
	 * @return
	 */
	public String validatePeriodoInicialFinalPesquisaAtm(Atendimento atendimento){
		
		SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy");
        Date menorData;
		
		try {
			menorData = sdfSource.parse(Constantes.CHAMADOS_DT_MIN);
			
			if(atendimento.getDataAbertura() != null && atendimento.getDataAbertura().before(menorData)){
			   return Constantes.DATA_INICIO_INFERIOR;
			}else if(atendimento.getDataAbertura() != null && atendimento.getDataAbertura().after(new Date())){
				   return Constantes.DATA_INICIO_SUPERIOR;
			}else if(atendimento.getDataFechamento() != null && atendimento.getDataFechamento().before(menorData)){
		    	return Constantes.DATA_FINAL_INFERIOR;
		    }else if(atendimento.getDataFechamento() != null && atendimento.getDataFechamento().after(new Date())){
		    	return Constantes.DATA_FINAL_SUPERIOR;
		    }else if(atendimento.getDataFechamento() != null && atendimento.getDataAbertura() != null){
		    	if(atendimento.getDataFechamento().before(atendimento.getDataAbertura())){
		    	   return Constantes.DATA_INICIAL_SUPERIOR_FINAL;
		    	}
		    }
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return null;
	}

}
