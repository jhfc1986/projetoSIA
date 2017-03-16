package com.unelev.projetosia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClienteEquipamentoPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CLI_CNPJ_CLIENTE", insertable = false, updatable = false)
    private Long cliCnpjCliente;
	
	@Column(name = "EQP_NUM_MODELO", insertable = false, updatable = false)
    private Integer eqpNumModelo;


	public Long getCliCnpjCliente() {
		return cliCnpjCliente;
	}

	public void setCliCnpjCliente(Long cliCnpjCliente) {
		this.cliCnpjCliente = cliCnpjCliente;
	}

	public Integer getEqpNumModelo() {
		return eqpNumModelo;
	}

	public void setEqpNumModelo(Integer eqpNumModelo) {
		this.eqpNumModelo = eqpNumModelo;
	}
	
	
	
	
}
