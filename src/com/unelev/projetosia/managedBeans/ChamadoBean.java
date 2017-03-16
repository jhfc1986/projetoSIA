package com.unelev.projetosia.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.unelev.projetosia.business.AtendimentoBusiness;
import com.unelev.projetosia.business.ClienteBusiness;
import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.util.Constantes;
import com.unelev.projetosia.util.Utils;

@ManagedBean(name = "chamadoBean")
@SessionScoped
public class ChamadoBean extends BeanRoot{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private Atendimento atendimento;
	
	private String input;
	
	private boolean cnpjCliCad;
	
	private boolean detalheAtendimento;

	private List<String> result=null;
	
	private List<Atendimento> chamados = new ArrayList<Atendimento>();

	public ChamadoBean() {
		
		cliente = new Cliente();
		atendimento = new Atendimento();
	}
	
	/**
	 * 
	 * metodo responsavel por detalhar chamado 
	 * selecionado na lista de chamados pelo
	 * usuário  
	 * 
	 */
	
	public void detalharChamado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		String itm = context.getExternalContext().getRequestParameterMap().get("codCham");
		
		ClienteBusiness cli = new ClienteBusiness();
		
		Atendimento atm = new Atendimento();
		
		atm.setNumeroSS(new Long(itm));
		
		Cliente clie = cli.pesquisarClientePorAtendimento(atm);
		
		cliente = clie;
		
		AtendimentoBusiness atb = new AtendimentoBusiness();
		
		Atendimento ati = atb.pesquisaAtendimentoPorDataSS(atm).get(0);
		
		atendimento = ati;
		
		this.setCnpjCliCad(true);
		
		this.setDetalheAtendimento(true);
		
	}
	
	/**
	 * 
	 * abre novo chamado
	 * 
	 */

	public void encaminhar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		ClienteBusiness clienteBusiness = new ClienteBusiness();
		
		if(!Utils.validaCNPJ(cliente.getCnpjCliente().toString())){
		   context.addMessage("msgs", 
			      new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.NUMERO_CNPJ_INVALIDO), null));
		
		}else{ 
		   
		   if(clienteBusiness.validateCliente(cliente)){
		
		      AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
		      atendimento.setCliente(cliente);
		      atendimento.setStatusPendencia(Constantes.STATUS_ABERTO);
		      atendimento.setDataAbertura(new Date());
		      atendimento.setNumeroSS(null);
		   
		      if(atendimentoBusiness.validateAtendimento(atendimento)){
			  
			     Cliente cli = clienteBusiness.pesquisaClienteCnpj(cliente);
              
			     if(cli == null){
            	    
			    	 clienteBusiness.salvarCliente(cliente);
              
			     }else{
            	  
			    	 cliente = cli;
              
			     }
			  
			     atendimentoBusiness.salvarAtendimento(atendimento);
			     atendimento = new Atendimento();
			     context.addMessage("msgs", 
					     new FacesMessage(FacesMessage.SEVERITY_INFO, getResourceBundle(context, Constantes.CHAMADO_SUCCESS), null));
			     pesquisarChamados();
			     this.setCnpjCliCad(true);
			   }else{
			      context.addMessage("msgs", 
					      new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.CHAMADO_DADOS_PROBLEMA), null));
		       }
	       }else{
	    	  context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.CHAMADO_DADOS_CLIENTE), null));
	       }
		}

	}
    
	/**
	 * 
	 * pesquisa os chamados abertos pelo cliente
	 * 
	 */
	
	public void pesquisarChamados(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		ClienteBusiness clienteBusiness = new ClienteBusiness();
		
		if(cliente != null && (!cliente.getNomeCliente().trim().equals(""))){
		  
		   cliente = clienteBusiness.pesquisaClienteNome(cliente);
		   this.setCnpjCliCad(true);
		
		}else if(cliente == null && cliente.getNomeCliente().trim().equals("")){
			
		   this.setCnpjCliCad(false);
		
		}
		
		AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
		
		if((atendimento.getNumeroSS()!= null && (atendimento.getNumeroSS().compareTo(new Long("0")) != 0)) 
				|| atendimento.getDataAbertura()!= null 
				|| atendimento.getDataFechamento()!= null){
			
			String retorno = null;
			
			if(atendimento.getDataAbertura()!= null || atendimento.getDataFechamento()!= null){
			   retorno = atendimentoBusiness.validatePeriodoInicialFinalPesquisaAtm(atendimento);
		    }
			
		    if(retorno == null && cliente != null){
			   chamados = atendimentoBusiness.pesquisaAtendimentoPorClienteDataSS(cliente,atendimento);
			}else if(retorno == null && cliente == null){
				this.setCnpjCliCad(false);
				chamados = atendimentoBusiness.pesquisaAtendimentoPorDataSS(atendimento);
			}else{
			   context.addMessage("msgs", 
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, retorno), null));
			}
		    
		    if(chamados.isEmpty()){
		        context.addMessage("msgs", 
						   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.CHAMADOS_NAO_ENCONTRADOS), null));
			}
		    
		}else{
			chamados = atendimentoBusiness.pesquisaAtendimentoPorCliente(cliente);
			
			if(chamados.isEmpty()){
		        context.addMessage("msgs", 
						   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.CHAMADOS_NAO_ENCONTRADOS), null));
			}
         }
	}
	
	/**
	 * carrega o nome do cliente digitado na pesquisa e se houver
	 * chamados estes serão carregados
	 */
	
	public void pesquisarNomeCliente(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    ClienteBusiness clienteBusiness = new ClienteBusiness();
	    
	    this.setDetalheAtendimento(false);
	    
	    cliente.setNomeCliente(input);
	    
	    cliente = clienteBusiness.pesquisaClienteNome(cliente);
	    
	    if(cliente == null){
           context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.CHAMADO_CLIENTE_NAO_ENCONTRADO), null));
	    }else{
	    	this.setCnpjCliCad(true);
	    	AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
			chamados = atendimentoBusiness.pesquisaAtendimentoAbertosCliente(cliente);
			atendimento = new Atendimento();
	    }
	     
	 }
	
	/**
	 * 
	 * @param query
	 */
	public void search(String query) {
		
		ClienteBusiness buss = new ClienteBusiness();
		
		Cliente clienteNm = new Cliente();
		clienteNm.setNomeCliente(input);
		
		List<Cliente> retorno  = buss.pesquisarClientesParteNome(clienteNm);
    	
		result=new ArrayList<String>();
		
		for(Cliente cli : retorno){
			result.add(cli.getNomeCliente());
    	}
	}
		
    /**
	 * metodo responsavel por retornar o nome docliente na pesquisa
	 * preenchendo o input com o valor selecionado
	 */
	public void pesquisarCliente(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		String param = context.getExternalContext().getRequestParameterMap().get("nomeCli"); 
		
		if(param != null && (!param.trim().equals(""))){
		   input = param;
		   result=new ArrayList<String>();
		}else{
		   result=new ArrayList<String>();
		}
	}
	
		
	/**
	 * 
	 * metodo responsavel por carregar a pagina inicial
	 * 
	 * @return
	 */
	public String load(){
		
		String login = this.login();
		
		if(login.equals("success")){
		   cliente = new Cliente();
		   atendimento = new Atendimento();
		   AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
		   this.setChamados(atendimentoBusiness.pesquisaAtendimentoAtivos());
		   result=new ArrayList<String>();
		   input="";
		   this.setCnpjCliCad(false);
		   this.setDetalheAtendimento(false);
		   return "success";
		 }else{
		   return login;
		 }
	}
	
	public Cliente getCliente() {
		if(cliente == null){
			return new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	public List<String> getResult() {
		return result;
	}
	
	public List<Atendimento> getChamados() {
		return chamados;
	}

	public void setChamados(List<Atendimento> chamados) {
		this.chamados = chamados;
	}

	public boolean isCnpjCliCad() {
		return cnpjCliCad;
	}

	public void setCnpjCliCad(boolean cnpjCliCad) {
		this.cnpjCliCad = cnpjCliCad;
	}
	
	public boolean isDetalheAtendimento() {
		return detalheAtendimento;
	}

	public void setDetalheAtendimento(boolean detalheAtendimento) {
		this.detalheAtendimento = detalheAtendimento;
	}
	
}
