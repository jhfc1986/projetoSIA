package com.unelev.projetosia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_VISTORIA")
@SequenceGenerator(name = "seq_it_vis", sequenceName = "seq_it_vis")
public class ItemVistoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id      
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_it_vis")
	@Column(name = "COD_ITEM_VIS" , length = 12)
	private Long codItemVistoria;
	
	@Column(name = "NOME_ITEM", length = 80)
	private String nomeItemVistoria;
	
	public ItemVistoria(){
		
	}

	public Long getCodItemVistoria() {
		return codItemVistoria;
	}

	public void setCodItemVistoria(Long codItemVistoria) {
		this.codItemVistoria = codItemVistoria;
	}

	public String getNomeItemVistoria() {
		return nomeItemVistoria;
	}

	public void setNomeItemVistoria(String nomeItemVistoria) {
		this.nomeItemVistoria = nomeItemVistoria;
	}
	
	
	
	
	
	
	
	

}
