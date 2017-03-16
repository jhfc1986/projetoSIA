package com.unelev.projetosia.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import com.unelev.projetosia.business.ClienteBusiness;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.entity.Vistoria;

@ManagedBean(name = "manutencaoBean")
@SessionScoped
public class ManutencaoBean extends BeanRoot {
	
	private Cliente cliente;
	
	private Vistoria vistoria;
    
	private String input;
	
	private Date periodoFinal;

	private List<Vistoria> vistorias = new ArrayList<Vistoria>();
	
	private List<Vistoria> itemVistoria = new ArrayList<Vistoria>();
	
	private List<String> result= new ArrayList<String>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     
	
	public ManutencaoBean(){
	    
		vistoria = new Vistoria();
		cliente = new Cliente();
		
	}
	/**
	 * 
	 * metodo inicializacao pagina
	 * 
	 * @return
	 */
	public String load(){
		vistoria = new Vistoria();
		cliente = new Cliente();
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
	
	/**
	 * 
	 * metodo responsavel por carregar os dados
	 * do cliente selecionado na lista de clientes
	 * existente
	 * 
	 */
	public void pesquisarNomeCliente(){
		
	}
	
	/**
	 * 
	 * carrega as vistorias pelo periodo selecionado
	 * pelo usuario do sistema
	 * 
	 */
	public void pesquisarPorPeriodo(){
		
	}
	
	/**
	 * 
	 * metodo responsavel por carregar a tela para o cadastro 
	 * de uma nova ficha de vistoria
	 * 
	 * @return
	 */
	public String adicionarNovaFicha(){
		
		
		
		return "success";
	}
	
	/**
	 * 
	 * metodo responsavel por caregar a tela da ficha
	 * de vistoria com a vistoria selecionada pelo
	 * usuario na tela de vistorias
	 * 
	 * @return
	 */
	public String carregaFichaVistoria(){
		
		return null;
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
	
	public Vistoria getVistoria() {
		return vistoria;
	}
	
	public void setVistoria(Vistoria vistoria) {
		this.vistoria = vistoria;
	}
	
	public List<Vistoria> getVistorias() {
		return vistorias;
	}
	
	public void setVistorias(List<Vistoria> vistorias) {
		this.vistorias = vistorias;
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
	
	public Date getPeriodoFinal() {
		return periodoFinal;
	}
	
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	
	public List<Vistoria> getItemVistoria() {
		return itemVistoria;
	}
	
	public void setItemVistoria(List<Vistoria> itemVistoria) {
		this.itemVistoria = itemVistoria;
	}
	
	public void setResult(List<String> result) {
		this.result = result;
	}
	
	
	

}
