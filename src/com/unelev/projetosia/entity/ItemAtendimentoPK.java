package com.unelev.projetosia.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemAtendimentoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "NUMERO_SS_ATM", insertable = false, updatable = false)
    private Long numeroSsAtm;
	
	
	@Column(name = "ITEM_EQUIP_NUM", insertable = false, updatable = false)
    private Integer itemEquipNum;


	public Long getNumeroSsAtm() {
		return numeroSsAtm;
	}


	public void setNumeroSsAtm(Long numeroSsAtm) {
		this.numeroSsAtm = numeroSsAtm;
	}


	public Integer getItemEquipNum() {
		return itemEquipNum;
	}


	public void setItemEquipNum(Integer itemEquipNum) {
		this.itemEquipNum = itemEquipNum;
	}

    
}
