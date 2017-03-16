package com.unelev.projetosia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "VISTORIA")
@SequenceGenerator(name = "seq_ss_vis", sequenceName = "seq_ss_vis")
public class Vistoria implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id      
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ss_vis")
	@Column(name = "SS_VISTORIA" , length = 12)
	private Long ssVistoria;
	
	@Type(type = "date")
	@Column(name = "DT_VISTORIA")
	private Date dtVistoria;
	
	@Column(name = "TP_VISTORIA")
	private Integer tpVis;

	@Column(name = "PARECER", length = 80)
	private String parecer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CNPJ_CLIENTE", nullable = false)
	private Cliente cliente;
	
	private HashSet<ClienteEquipamento> itensEquipamento = new HashSet<ClienteEquipamento>(0);
	
	
	public Vistoria(){
		
	}
	
	public Integer getTpVis() {
		return tpVis;
	}

	public void setTpVis(Integer tpVis) {
		this.tpVis = tpVis;
	}
    
    public Long getSsVistoria() {
		return ssVistoria;
	}
    
    public void setSsVistoria(Long ssVistoria) {
		this.ssVistoria = ssVistoria;
	}
    
    public Date getDtVistoria() {
		return dtVistoria;
	}

	public void setDtVistoria(Date dtVistoria) {
		this.dtVistoria = dtVistoria;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vistoria")
	public HashSet<ClienteEquipamento> getItensEquipamento() {
		return itensEquipamento;
	}

	public void setItensEquipamento(HashSet<ClienteEquipamento> itensEquipamento) {
		this.itensEquipamento = itensEquipamento;
	}
	
	
}
