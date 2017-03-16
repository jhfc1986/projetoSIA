package com.unelev.projetosia.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ITEM_ATENDIMENTO")
public class ItemAtendimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemAtendimentoPK primaryKey;
	
	@ManyToOne
	@JoinColumn(name = "EQUIP_NUM", referencedColumnName = "EQUIP_NUM")
	private ItemEquipamento itemEquipamento;
	
	@ManyToOne
	@JoinColumn(name = "NUMERO_SS", referencedColumnName = "NUMERO_SS")
	private Atendimento atendimento;

	private Integer quantidadeSubstituida;
	
	private String motivoSubstituicao;
	
	public ItemAtendimento(){
		
	}

	public ItemAtendimentoPK getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ItemAtendimentoPK primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Integer getQuantidadeSubstituida() {
		return quantidadeSubstituida;
	}

	public void setQuantidadeSubstituida(Integer quantidadeSubstituida) {
		this.quantidadeSubstituida = quantidadeSubstituida;
	}

	public String getMotivoSubstituicao() {
		return motivoSubstituicao;
	}

	public void setMotivoSubstituicao(String motivoSubstituicao) {
		this.motivoSubstituicao = motivoSubstituicao;
	}
	
	public ItemEquipamento getItemEquipamento() {
		return itemEquipamento;
	}

	public void setItemEquipamento(ItemEquipamento itemEquipamento) {
		this.itemEquipamento = itemEquipamento;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
    
	
	
	

}
