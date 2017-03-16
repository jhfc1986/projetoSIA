package com.unelev.projetosia.business;

import java.util.List;

import com.unelev.projetosia.dao.ClienteDAO;
import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.util.Constantes;

public class ClienteBusiness {
	
	/**
	 * 
	 * @param atendimento
	 * @return
	 */
	public Cliente pesquisarClientePorAtendimento(Atendimento atendimento){
		ClienteDAO dao = new ClienteDAO();
		return dao.pesquisarClientePorAtendimento(atendimento);
	}
	
    /**
     * 
     * @param cliente
     * @return
     */
	public List<Cliente> pesquisarClientesParteNome(Cliente cliente){
		
	    ClienteDAO dao = new ClienteDAO();
		return dao.pesquisarClientesParteNome(cliente);
		
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
    public Cliente pesquisaClienteCnpj(Cliente cliente){
		
	    ClienteDAO dao = new ClienteDAO();
		cliente = dao.pesquisaClienteCnpj(cliente);
		return cliente;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
    public Cliente pesquisaClienteNome(Cliente cliente){
		
	    ClienteDAO dao = new ClienteDAO();
		cliente = dao.pesquisaClienteNome(cliente);
		return cliente;
	}
    
	/**
	 * 
	 * @param atendente
	 */
	public void salvarCliente(Cliente cliente){
		formatDDD(cliente);
		ClienteDAO dao = new ClienteDAO();
	    dao.salvar(cliente);
	}
	
	/**
	 * 
	 * metodo responsavel por validar os dados do cliente
	 * 
	 * @return
	 */
	public boolean validateCliente(Cliente cliente){
		
        boolean validCliente = true;
		
		if(cliente.getCnpjCliente()== null ){
		   validCliente = false;
		}else if(cliente.getEnderecoCliente()== null 
				|| cliente.getEnderecoCliente().trim().equals(Constantes.STRING_BRANCO)){
		   validCliente = false;
		}else if(cliente.getNumEnd()==null){
		   validCliente = false;
		}else if(cliente.getNomeCliente() == null 
				|| cliente.getNomeCliente().trim().equals(Constantes.STRING_BRANCO) ){
		   validCliente = false;
		}else if(cliente.getNumTelCliente() == null){
		   validCliente = false;
		}else if(cliente.getRespCliente()== null 
				|| cliente.getRespCliente().trim().equals(Constantes.STRING_BRANCO) ){
			validCliente = false;
		}
		
		return validCliente;
	}
	
	/**
	 * 
	 * metodo responsavel por formatar o DDD
	 * 
	 */
	private void formatDDD(Cliente cliente){
		if(cliente.getNumTelCliente()!= null && cliente.getNumTelCliente()!= 0){
		   cliente.setDddTelCliente(execFormat(cliente.getNumTelCliente()));	
			
		}
		if(cliente.getCelCliente()!= null && cliente.getCelCliente()!= 0){
		   cliente.setDddTelCliente(execFormat(cliente.getCelCliente()));
		}
	}
	/**
	 * 
	 * formata
	 * 
	 * @param numTel
	 * @return
	 */
	private Integer execFormat(Long numTel){
		
		return new Integer(numTel.toString().substring(0,1));
	}

}
