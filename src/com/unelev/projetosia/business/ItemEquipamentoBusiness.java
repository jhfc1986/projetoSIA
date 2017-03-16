package com.unelev.projetosia.business;

import com.unelev.projetosia.dao.ItemEquipamentoDAO;
import com.unelev.projetosia.entity.ItemEquipamento;

public class ItemEquipamentoBusiness {
	
    /**
     * 
     * @param item
     */
	public void salvarItemEquipamento(ItemEquipamento item){
	    
		ItemEquipamentoDAO dao = new ItemEquipamentoDAO();
	    dao.salvar(item);
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	public ItemEquipamento buscarItemPeloNome(ItemEquipamento item){
		
		ItemEquipamentoDAO dao = new ItemEquipamentoDAO();
		ItemEquipamento itemq = dao.buscarItemPeloNome(item);
		return itemq;
	}

}
