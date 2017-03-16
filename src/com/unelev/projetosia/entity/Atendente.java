package com.unelev.projetosia.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ATENDENTE")
public class Atendente implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "MAT_ATENDENTE")
    private Long matAtendente;
	
	@Column(name = "NOME_ATENDENTE", length = 60)
	private String nomeAtendente;
	
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;
   
	@Column(name = "DATA_EFETIVACAO")
	private Date dataEfetivacao;
	 
	@Column(name = "CPF_ATENDENTE")
	private Long cpfAtendente;
	 
	@Column(name = "RG_ATENDENTE")
	private Long rgAtendente;
	
	@Column(name = "PASS_ATENDENTE")
	private String passAtendente;
	
	private HashSet<Perfil> perfis = new HashSet<Perfil>(0);

	public Atendente(){
		
	}

	public Long getMatAtendente() {
		return matAtendente;
	}

	public void setMatAtendente(Long matAtendente) {
		this.matAtendente = matAtendente;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(Date dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public Long getCpfAtendente() {
		return cpfAtendente;
	}

	public void setCpfAtendente(Long cpfAtendente) {
		this.cpfAtendente = cpfAtendente;
	}

	public Long getRgAtendente() {
		return rgAtendente;
	}

	public void setRgAtendente(Long rgAtendente) {
		this.rgAtendente = rgAtendente;
	}

	public String getPassAtendente() {
		return passAtendente;
	}

	public void setPassAtendente(String passAtendente) {
		this.passAtendente = passAtendente;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ATENDENTE_PERFIL", joinColumns = { @JoinColumn (name = "MAT_ATENDENTE")}, inverseJoinColumns = { @JoinColumn(name = "COD_PERFIL") })
	public HashSet<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(HashSet<Perfil> perfis) {
		this.perfis = perfis;
	}
    
	
}
