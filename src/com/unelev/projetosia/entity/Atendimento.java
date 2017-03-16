package com.unelev.projetosia.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
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
@Table(name = "ATENDIMENTO")
@SequenceGenerator(name = "seq_ss", sequenceName = "seq_ss")
public class Atendimento implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id      
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ss") 
	@Column(name = "NUMERO_SS", length = 12)
	private Long numeroSS;
	
	@Type(type = "date") 
	@Column(name = "DATA_ABERTURA")
	private Date dataAbertura;
		
	@Type(type = "date") 
	@Column(name = "DATA_FECHAMENTO")
	private Date dataFechamento;
	
	@Column(name = "HORA_CHEGADA")
	private Date horaChegada;
	
	@Column(name = "HORA_SAIDA")
	private Date horaSaida;

	@Column(name = "DESC_PROBLEMA", length = 80)
	private String descricaoProblema;
	
	@Column(name = "STATUS_PENDENCIA", length = 1)
	private String statusPendencia;
	
	@Column(name = "STATUS_AT_PRE", length = 1)
	private String statusAtPre;
	
	@Column(name = "STATUS_AT_POS", length = 1)
	private String statusAtPos;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CNPJ_CLIENTE", nullable = false)
	private Cliente cliente;
	
    private HashSet<ItemAtendimento> itemAtendimento = new HashSet<ItemAtendimento>(0);

	public Atendimento(){
		
	}
    
    public String getStatusPendencia() {
		return statusPendencia;
	}
    
    public void setStatusPendencia(String statusPendencia) {
		this.statusPendencia = statusPendencia;
	}
    

	public Long getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(Long numeroSS) {
		this.numeroSS = numeroSS;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}
    
	public String getStatusAtPre() {
		return statusAtPre;
	}

	public void setStatusAtPre(String statusAtPre) {
		this.statusAtPre = statusAtPre;
	}

	public String getStatusAtPos() {
		return statusAtPos;
	}

	public void setStatusAtPos(String statusAtPos) {
		this.statusAtPos = statusAtPos;
	}
	
	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}
    
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,targetEntity=ItemAtendimento.class)
    public HashSet<ItemAtendimento> getItemAtendimento() {
		return itemAtendimento;
	}

	public void setItemAtendimento(HashSet<ItemAtendimento> itemAtendimento) {
		this.itemAtendimento = itemAtendimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
