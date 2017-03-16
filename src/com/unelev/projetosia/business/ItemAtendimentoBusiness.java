package com.unelev.projetosia.business;

import java.util.List;

import com.unelev.projetosia.dao.ItemAtendimentoDAO;
import com.unelev.projetosia.entity.ItemAtendimento;
import com.unelev.projetosia.entity.ItemAtendimentoPK;

public class ItemAtendimentoBusiness {
	
	
    /**
     * 
     * @param item
     */
	public void salvarItemAtendimento(ItemAtendimento item){
	    
		ItemAtendimentoDAO dao = new ItemAtendimentoDAO();
		ItemAtendimentoPK pk = new ItemAtendimentoPK();
		pk.setNumeroSsAtm(item.getAtendimento().getNumeroSS());
		pk.setItemEquipNum(new Integer(item.getItemEquipamento().getEquipNum().toString()));
		item.setPrimaryKey(pk);
	    dao.salvar(item);
	}
	
	
	 /**
     * 
     * @param item
     */
	public List<ItemAtendimento> buscarItemPeloNumeroSSAtendimento(ItemAtendimento item){
	    
		ItemAtendimentoDAO dao = new ItemAtendimentoDAO();
		
	    return dao.buscarItemPeloNumeroSSAtendimento(item);
	}

}
