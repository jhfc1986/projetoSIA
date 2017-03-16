package com.unelev.projetosia.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;

import com.unelev.projetosia.entity.ItemEquipamento;
import com.unelev.projetosia.util.Constantes;

public class ItemVistoriaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ItemEquipamento> itemEquipamentos = new ArrayList<ItemEquipamento>();

    private ArrayList<ItemEquipamento> casaDeMaquinas = new ArrayList<ItemEquipamento>(); 
	
	private ArrayList<ItemEquipamento> cabine = new ArrayList<ItemEquipamento>();
	
	private ArrayList<ItemEquipamento> pavimento = new ArrayList<ItemEquipamento>();
	
	private ArrayList<ItemEquipamento> poco = new ArrayList<ItemEquipamento>();
	
	private ArrayList<ItemEquipamento> contraPeso = new ArrayList<ItemEquipamento>();
	
	public ItemVistoriaModel(ArrayList<ItemEquipamento> itemEquipamentos){
		this.itemEquipamentos = itemEquipamentos; 
	}
	
	/**
	 * 
	 * metodo responsavel por popular as sublistas do model.
	 * 
	 */
	public void filtrarItens(){
		
		//Constantes modelo subsistema
		
	    for(ItemEquipamento item: itemEquipamentos){
			if(item.getSubsistema().getTpSubsistema().compareTo(Constantes.ID_CASA_MAQUINAS)==0){
				casaDeMaquinas.add(item);
			}else if(item.getSubsistema().getTpSubsistema().compareTo(Constantes.ID_CABINE)==0){
				cabine.add(item);
			}else if(item.getSubsistema().getTpSubsistema().compareTo(Constantes.ID_PAVIMENTO)==0){
				pavimento.add(item);
			}else if(item.getSubsistema().getTpSubsistema().compareTo(Constantes.ID_POCO)==0){
				poco.add(item);
			}else if(item.getSubsistema().getTpSubsistema().compareTo(Constantes.ID_CONTRA_PESO)==0){
				contraPeso.add(item);
			}
		}
	}
	
	/**
	 * 
	 * metodo responsavel por resetar as sublistas do sistema.
	 * 
	 */
	
	public void reset(){
		
	    itemEquipamentos = new ArrayList<ItemEquipamento>();
        casaDeMaquinas = new ArrayList<ItemEquipamento>(); 
		cabine = new ArrayList<ItemEquipamento>();
		pavimento = new ArrayList<ItemEquipamento>();
		poco = new ArrayList<ItemEquipamento>();
		contraPeso = new ArrayList<ItemEquipamento>();
	
	}
	
	public ArrayList<ItemEquipamento> getItemEquipamentos() {
		return itemEquipamentos;
	}

	public void setItemEquipamentos(ArrayList<ItemEquipamento> itemEquipamentos) {
		this.itemEquipamentos = itemEquipamentos;
	}
	
    public ArrayList<ItemEquipamento> getCasaDeMaquinas() {
		return casaDeMaquinas;
	}
    
	public void setCasaDeMaquinas(ArrayList<ItemEquipamento> casaDeMaquinas) {
		this.casaDeMaquinas = casaDeMaquinas;
	}

	public ArrayList<ItemEquipamento> getCabine() {
		return cabine;
	}

	public void setCabine(ArrayList<ItemEquipamento> cabine) {
		this.cabine = cabine;
	}

	public ArrayList<ItemEquipamento> getPavimento() {
		return pavimento;
	}

	public void setPavimento(ArrayList<ItemEquipamento> pavimento) {
		this.pavimento = pavimento;
	}

	public ArrayList<ItemEquipamento> getPoco() {
		return poco;
	}

	public void setPoco(ArrayList<ItemEquipamento> poco) {
		this.poco = poco;
	}

	public ArrayList<ItemEquipamento> getContraPeso() {
		return contraPeso;
	}

	public void setContraPeso(ArrayList<ItemEquipamento> contraPeso) {
		this.contraPeso = contraPeso;
	}

}
