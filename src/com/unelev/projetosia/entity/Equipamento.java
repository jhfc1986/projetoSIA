package com.unelev.projetosia.entity;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPAMENTO")
public class Equipamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_MODELO")
	private Integer numModelo;
	
	@Column(name = "MARCA_EQUIPAMENTO" , length = 30)
	private String marcaEquipamento;
	
	@Column(name = "NOME_MODELO" , length = 30)
	private String nomeModelo;
	
	private HashSet<ItemEquipamento> itensEquipamento = new HashSet<ItemEquipamento>(0);
	
	private HashSet<ClienteEquipamento> clienteEquipamento = new HashSet<ClienteEquipamento>(0);
	
	public Equipamento(){
		
	}

	public Integer getNumModelo() {
		return numModelo;
	}

	public void setNumModelo(Integer numModelo) {
		this.numModelo = numModelo;
	}

	public String getMarcaEquipamento() {
		return marcaEquipamento;
	}

	public void setMarcaEquipamento(String marcaEquipamento) {
		this.marcaEquipamento = marcaEquipamento;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipamento")
	public HashSet<ItemEquipamento> getItensEquipamento() {
		return itensEquipamento;
	}

	public void setItensEquipamento(HashSet<ItemEquipamento> itensEquipamento) {
		this.itensEquipamento = itensEquipamento;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,targetEntity=ClienteEquipamento.class)
	public HashSet<ClienteEquipamento> getClienteEquipamento() {
		return clienteEquipamento;
	}

	public void setClienteEquipamento(HashSet<ClienteEquipamento> clienteEquipamento) {
		this.clienteEquipamento = clienteEquipamento;
	}

	
	

}
