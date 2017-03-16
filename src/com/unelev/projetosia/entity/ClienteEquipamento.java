package com.unelev.projetosia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE_EQUIPAMENTO")
public class ClienteEquipamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClienteEquipamentoPK primaryKey;
 
	@Column(name = "QTD_EQUIP")
	private Integer qtdEquip;
	
	@Column(name = "NUM_PARADAS")
	private Integer numParadas;
	
	@Column(name = "INF_COMPL", length = 60)
	private String infCompl;
	
	@ManyToOne
	@JoinColumn(name = "CNPJ_CLIENTE", referencedColumnName = "CNPJ_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "NUM_MODELO", referencedColumnName = "NUM_MODELO")
	private Equipamento equipamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SS_VISTORIA")
	private Vistoria vistoria;
	
    
	public ClienteEquipamento(){
		
	}

	public Integer getNumParadas() {
		return numParadas;
	}

	public void setNumParadas(Integer numParadas) {
		this.numParadas = numParadas;
	}

	public String getInfCompl() {
		return infCompl;
	}

	public void setInfCompl(String infCompl) {
		this.infCompl = infCompl;
	}
	
	public Vistoria getVistoria() {
		return vistoria;
	}

	public void setVistoria(Vistoria vistoria) {
		this.vistoria = vistoria;
	}
	
	public ClienteEquipamentoPK getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ClienteEquipamentoPK primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Integer getQtdEquip() {
		return qtdEquip;
	}

	public void setQtdEquip(Integer qtdEquip) {
		this.qtdEquip = qtdEquip;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
