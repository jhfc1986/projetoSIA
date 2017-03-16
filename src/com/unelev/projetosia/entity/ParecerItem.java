package com.unelev.projetosia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PARECER_ITEM")
@SequenceGenerator(name = "seq_pa_it", sequenceName = "seq_pa_it")
public class ParecerItem  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id      
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pa_it")
	@Column(name = "COD_PAR_IT" , length = 15)
	private Long codParIt;
	
	@Column(name = "COM_PARECER", length = 80)
	private String comParecer;
	
	public ParecerItem(){
		
	}

	public Long getCodParIt() {
		return codParIt;
	}

	public void setCodParIt(Long codParIt) {
		this.codParIt = codParIt;
	}

	public String getComParecer() {
		return comParecer;
	}

	public void setComParecer(String comParecer) {
		this.comParecer = comParecer;
	}

	
	

}
