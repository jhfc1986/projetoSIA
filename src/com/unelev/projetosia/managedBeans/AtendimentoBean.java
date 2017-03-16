package com.unelev.projetosia.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.unelev.projetosia.business.AtendimentoBusiness;
import com.unelev.projetosia.business.ClienteBusiness;
import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.util.Constantes;

@ManagedBean(name = "atendimentoBean")
@SessionScoped
public class AtendimentoBean extends BeanRoot {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Atendimento atendimento;
	
	private Cliente cliente;

	private String input;
	
	private List<Atendimento> chamados = new ArrayList<Atendimento>();
	
	private List<String> result=null;
	
	public AtendimentoBean() {
	   atendimento = new Atendimento();
	   cliente = new Cliente();
	}
	
	/**
	 * carrega o nome do cliente digitado na pesquisa e se houver
	 * chamados estes serão carregados
	 */
	
	public void pesquisarNomeCliente(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    ClienteBusiness clienteBusiness = new ClienteBusiness();
	    
	    cliente = new Cliente();
	    cliente.setNomeCliente(input);
	    
	    cliente = clienteBusiness.pesquisaClienteNome(cliente);
	    
	    if(cliente == null){
	       chamados = new ArrayList<Atendimento>();
           context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.CLIENTE_NAO_ENCONTRADO), null));
	    }else{
	    	AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
			chamados = atendimentoBusiness.pesquisaAtendimentoAbertosCliente(cliente);
			
			if(chamados.isEmpty()){
		        context.addMessage("msgs", 
						   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.ATENDIMENTO_CHAMADOS_NAO_ENCONTRADOS), null));
			}
	    }
	     
	 }
	
	/**
	 * 
	 * muda valor do radio button na aplicação
	 * 
	 * @param event
	 */
    public void setSelectedItem(AjaxBehaviorEvent event) { 
		
       UIComponent item = event.getComponent();
       List<UIComponent> chd = item.getChildren();
       UISelectItem itema = (UISelectItem) chd.get(0);
       Long value = (Long) itema.getItemValue();
       atendimento.setNumeroSS(value);
    
    }
	
	 /**
	  * 
	  * metodo responsavel por pesquisar os chamados 
	  * conforme o periodo de tempo selecionado pelo usuario
	  * 
	  */
	 public void pesquisarPorPeriodo(){
		 
		 FacesContext context = FacesContext.getCurrentInstance();
			
		 AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
			
		 String retorno = null;
		    
	     retorno = atendimentoBusiness.validatePeriodoInicialFinalPesquisaAtm(atendimento);
		 
		 if(cliente != null && (!input.trim().equals(""))
				 && (atendimento.getDataAbertura()!= null || atendimento.getDataFechamento()!= null)){
			  
			 ClienteBusiness clienteBusiness = new ClienteBusiness();
			 
			 cliente.setNomeCliente(input);
				
			 cliente = clienteBusiness.pesquisaClienteNome(cliente);
			
			 if(retorno == null){
			   chamados = atendimentoBusiness.pesquisaAtendimentoPorDataSSListAtendimentoCliente(cliente,atendimento);
			   if(chamados.isEmpty()){
				   context.addMessage("msgs", 
						   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.ATENDIMENTO_CHAMADOS_NAO_ENCONTRADOS ), null));
			   }
			}else{
			   atendimento.setDataAbertura(null);
			   atendimento.setDataFechamento(null);
			   context.addMessage("msgs", 
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, retorno), null));
			}
		  }else{
			  if(retorno == null && (atendimento.getDataAbertura()!= null || atendimento.getDataFechamento()!=null) ){
				   chamados = atendimentoBusiness. pesquisaAtendimentoPorDataSSListAtendimento(atendimento);
				   if(chamados.isEmpty()){
					   context.addMessage("msgs", 
							   new FacesMessage(FacesMessage.SEVERITY_WARN, getResourceBundle(context, Constantes.ATENDIMENTO_CHAMADOS_NAO_ENCONTRADOS ), null));
				   }
			  }else if(input.trim().equals("") && atendimento.getDataAbertura()== null && atendimento.getDataFechamento()==null){ 
				  retorno = "Preencher pelo menos um parâmetro de pesquisa";
				  atendimento.setDataAbertura(null);
				  atendimento.setDataFechamento(null);
				  context.addMessage("msgs", 
								 new FacesMessage(FacesMessage.SEVERITY_ERROR, retorno, null));
			  }else{
				   atendimento.setDataAbertura(null);
				   atendimento.setDataFechamento(null);
				   context.addMessage("msgs", 
								 new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, retorno), null));
				} 
		  }
	}
	
	public String load(){
		
		atendimento = new Atendimento();
		cliente = new Cliente();
        input ="";
		chamados = new ArrayList<Atendimento>();
		result=null;
		input="";
		
		return "success";
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
	
	
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
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

	public List<Atendimento> getChamados() {
		return chamados;
	}
    
	public void setChamados(List<Atendimento> chamados) {
		this.chamados = chamados;
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
		   
}
