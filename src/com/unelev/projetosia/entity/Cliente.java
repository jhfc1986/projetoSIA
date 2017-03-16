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
@Table(name = "CLIENTE")
public class Cliente implements Serializable  {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CNPJ_CLIENTE", length = 14)
	private Long cnpjCliente;
	
	@Column(name = "NOME_CLIENTE", length = 60)
	private String nomeCliente;
	
	@Column(name = "ENDERECO_CLIENTE", length = 40)
	private String enderecoCliente;
	
	@Column(name = "NUM_END", length = 8)
	private Integer numEnd;

	@Column(name = "COMPL_CLIENTE" , length = 15)
	private String complCliente;
	
	@Column(name = "RESP_CLIENTE", length = 50)
	private String respCliente;
	
	@Column(name = "DDD_TEL_CLIENTE")
	private Integer dddTelCliente;
	
	@Column(name = "NUM_TEL_CLIENTE")
	private Long numTelCliente;
	
	@Column(name = "DDD_CEL_CLIENTE")
	private Integer dddCelCliente;
	
	@Column(name = "CEL_CLIENTE")
	private Long celCliente;
	
	private HashSet<Atendimento> atendimentos = new HashSet<Atendimento>(0);
	
	private HashSet<Vistoria> vistorias = new HashSet<Vistoria>(0);
	
	private HashSet<ClienteEquipamento> clienteEquipamento = new HashSet<ClienteEquipamento>(0);
	
	public Cliente(){
		
	}

	public Long getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(Long cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getComplCliente() {
		return complCliente;
	}

	public void setComplCliente(String complCliente) {
		this.complCliente = complCliente;
	}

	public String getRespCliente() {
		return respCliente;
	}

	public void setRespCliente(String respCliente) {
		this.respCliente = respCliente;
	}

	public Integer getDddTelCliente() {
		return dddTelCliente;
	}

	public void setDddTelCliente(Integer dddTelCliente) {
		this.dddTelCliente = dddTelCliente;
	}

	public Long getNumTelCliente() {
		return numTelCliente;
	}

	public void setNumTelCliente(Long numTelCliente) {
		this.numTelCliente = numTelCliente;
	}

	public Integer getDddCelCliente() {
		return dddCelCliente;
	}

	public void setDddCelCliente(Integer dddCelCliente) {
		this.dddCelCliente = dddCelCliente;
	}

	public Long getCelCliente() {
		return celCliente;
	}

	public void setCelCliente(Long celCliente) {
		this.celCliente = celCliente;
	}
	
	public Integer getNumEnd() {
		return numEnd;
	}

	public void setNumEnd(Integer numEnd) {
		this.numEnd = numEnd;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public HashSet<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(HashSet<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public HashSet<Vistoria> getVistorias() {
		return vistorias;
	}

	public void setVistorias(HashSet<Vistoria> vistorias) {
		this.vistorias = vistorias;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,targetEntity=ClienteEquipamento.class)
	public HashSet<ClienteEquipamento> getClienteEquipamento() {
		return clienteEquipamento;
	}

	public void setClienteEquipamento(HashSet<ClienteEquipamento> clienteEquipamento) {
		this.clienteEquipamento = clienteEquipamento;
	}

	
	
}
