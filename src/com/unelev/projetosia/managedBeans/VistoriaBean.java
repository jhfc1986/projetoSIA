package com.unelev.projetosia.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.entity.Vistoria;

@ManagedBean(name = "vistoriaBean")
@ViewScoped
public class VistoriaBean extends BeanRoot {
	
	
	private Cliente cliente;
	
	private Vistoria vistoria;
    
	private String input;
	
	private Date periodoFinal;

	private List<Vistoria> vistorias = new ArrayList<Vistoria>();
	
	private List<String> result=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String load(){
		return "success";
	}
	
	/**
	 * 
	 * @param query
	 */
	public void search(String query) {
    	result=new ArrayList<String>();
		result.add("Teste");
	
	}
	
	public void reset(AjaxBehaviorEvent event) {
		 result=new ArrayList<String>();
	}
	
	/**
	 * 
	 * carrega os dados do cliente da vistoria
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
		
		return null;
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

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public List<Vistoria> getVistorias() {
		return vistorias;
	}

	public void setVistorias(List<Vistoria> vistorias) {
		this.vistorias = vistorias;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}
	
	

}
