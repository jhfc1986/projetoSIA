package com.unelev.projetosia.business;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.dao.ClienteEquipamentoDAO;
import com.unelev.projetosia.dao.HibernateUtil;
import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.entity.ClienteEquipamento;
import com.unelev.projetosia.entity.ClienteEquipamentoPK;

public class ClienteEquipamentoBusiness {
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaClienteEquipamentoPorCliente(Cliente cliente) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Atendimento AS at WHERE at.cliente.cnpjCliente =:cnpjCli");
		query.setParameter("cnpjCli", cliente.getCnpjCliente());
		
		List list = query.list();
		session.close();
		
        return list;
	}
	
	/**
	 * 
	 * @param atendente
	 */
	public void salvarClienteEquipamento(ClienteEquipamento cliente){
		ClienteEquipamentoPK pk = new ClienteEquipamentoPK();
		pk.setCliCnpjCliente(cliente.getCliente().getCnpjCliente());
		pk.setEqpNumModelo(cliente.getEquipamento().getNumModelo());
		cliente.setPrimaryKey(pk);
		ClienteEquipamentoDAO dao = new ClienteEquipamentoDAO();
	    dao.salvar(cliente);
	}
	
	/**
	 * 
	 * valida cliente equipamento
	 * 
	 * @return
	 */
	public boolean validateClienteEquipamento(ClienteEquipamento clienteEquipamento){
		boolean retorno = true;
		
		if(clienteEquipamento.getNumParadas() == null || clienteEquipamento.getNumParadas() == 0){
			retorno = false;
		}else if(clienteEquipamento.getQtdEquip() == null || clienteEquipamento.getQtdEquip() == 0 ){
			retorno = false;
		}
		return retorno;
	}

}
