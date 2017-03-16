package com.unelev.projetosia.business;

import com.unelev.projetosia.dao.SubsistemaDAO;
import com.unelev.projetosia.entity.Subsistema;

public class SubsistemaBusiness {
	
    /**
     * 
     * @param item
     */
	public void salvarSubsistema(Subsistema subsistema){
	    
		SubsistemaDAO dao = new SubsistemaDAO();
	    dao.salvar(subsistema);
	}

}
