package com.unelev.projetosia.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_EQUIPAMENTO")
public class ItemEquipamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "EQUIP_NUM")
	private Long equipNum;
    
	@Column(name = "NOME_ITEM", length = 40)
	private String nomeItem;
	
	@Column(name = "DESCRICAO_ITEM", length = 80)
	private String descricaoItem;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "COD_SITUACAO")
	private Integer codSituacao;
	
	@Column(name = "DESC_SIT_EQUIP", length = 60)
	private String desSitEqip;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SUBSISTEMA", nullable = false)
	private Subsistema subsistema;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_MODELO", nullable = false)
	private Equipamento equipamento;
	
	private HashSet<ItemAtendimento> itemAtendimento = new HashSet<ItemAtendimento>(0);

	
	public ItemEquipamento(){
		
	}
	
	public Integer getCodSituacao() {
		return codSituacao;
	}

	public void setCodSituacao(Integer codSituacao) {
		this.codSituacao = codSituacao;
	}

	public String getDesSitEqip() {
		return desSitEqip;
	}

	public void setDesSitEqip(String desSitEqip) {
		this.desSitEqip = desSitEqip;
	}

	public Long getEquipNum() {
		return equipNum;
	}

	public void setEquipNum(Long equipNum) {
		this.equipNum = equipNum;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	
	public Subsistema getSubsistema() {
		return subsistema;
	}

	public void setSubsistema(Subsistema subsistema) {
		this.subsistema = subsistema;
	}
	
	
    public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public HashSet<ItemAtendimento> getItemAtendimento() {
		return itemAtendimento;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,targetEntity=ClienteEquipamento.class)
    public void setItemAtendimento(HashSet<ItemAtendimento> itemAtendimento) {
		this.itemAtendimento = itemAtendimento;
	}
	
	
}
