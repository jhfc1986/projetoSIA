package com.unelev.projetosia.entity;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSISTEMA")
public class Subsistema implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_SUBSISTEMA")
	private Integer codSubsistema;
	
	@Column(name = "NOME_SUBSISTEMA")
	private String nomeSubsistema;
	
	@Column(name = "TP_SUBSISTEMA")
	private Integer tpSubsistema;

	private HashSet<ItemEquipamento> itensEquipamento = new HashSet<ItemEquipamento>(0);
	
	public Subsistema(){
		
	}

	public Integer getCodSubsistema() {
		return codSubsistema;
	}

	public void setCodSubsistema(Integer codSubsistema) {
		this.codSubsistema = codSubsistema;
	}

	public String getNomeSubsistema() {
		return nomeSubsistema;
	}

	public void setNomeSubsistema(String nomeSubsistema) {
		this.nomeSubsistema = nomeSubsistema;
	}
	
	public Integer getTpSubsistema() {
		return tpSubsistema;
	}

	public void setTpSubsistema(Integer tpSubsistema) {
		this.tpSubsistema = tpSubsistema;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subsistema")
	public HashSet<ItemEquipamento> getItensEquipamento() {
		return itensEquipamento;
	}

	public void setItensEquipamento(HashSet<ItemEquipamento> itensEquipamento) {
		this.itensEquipamento = itensEquipamento;
	}
	
	
	
}
