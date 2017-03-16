package com.unelev.projetosia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;

public class ClienteEquipamentoDAO extends BaseDAO {
	
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento>  pesquisaClienteEquipamentoPorCliente(Cliente cliente) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Atendimento AS at WHERE at.cliente.cnpjCliente =:cnpjCli");
		query.setParameter("cnpjCli", cliente.getCnpjCliente());
		
		List list = query.list();
		session.close();
		
        return list;
	}

}
