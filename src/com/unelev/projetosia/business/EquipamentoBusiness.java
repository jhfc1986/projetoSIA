package com.unelev.projetosia.business;

import java.util.List;

import com.unelev.projetosia.dao.EquipamentoDAO;
import com.unelev.projetosia.entity.Equipamento;

public class EquipamentoBusiness {
	
	/**
	 * 
	 * @return
	 */
    public List<Equipamento> pesquisarEquipamentos(){
		
    	EquipamentoDAO dao = new EquipamentoDAO();
    	List<Equipamento> equipamentos = dao.pesquisarEquipamentos();
		return equipamentos;
	}
    
    /**
     * 
     * @param equipamento
     * @return
     */
    public List<Equipamento> pesquisarEquipamentosPelaMarca(Equipamento equipamento){
		
    	EquipamentoDAO dao = new EquipamentoDAO();
    	List<Equipamento> equipamentos = dao.pesquisarEquipamentosPelaMarca(equipamento);
		return equipamentos;
	}
    
    /**
     * 
     * @param equipamento
     * @return
     */
    public Equipamento pesquisarEquipamentosPelaMarcaEModelo(Equipamento equipamento){
    	EquipamentoDAO dao = new EquipamentoDAO();
    	Equipamento equipamentor = dao.pesquisarEquipamentosPelaMarcaEModelo(equipamento);
		return equipamentor;
    }
	
    /**
	 * 
	 * @param equipamento
	 */
	public void salvarEquipamento(Equipamento equipamento){
	    
		EquipamentoDAO dao = new EquipamentoDAO();
	    dao.salvar(equipamento);
	}

}
