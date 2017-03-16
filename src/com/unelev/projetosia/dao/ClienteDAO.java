package com.unelev.projetosia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;

public class ClienteDAO extends BaseDAO {
	
	/**
	 * 
	 * @param atendimento
	 * @return
	 */
	public Cliente pesquisarClientePorAtendimento(Atendimento atendimento){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT atm FROM Atendimento atm INNER JOIN FETCH atm.cliente WHERE atm.numeroSS = :numSS");
	    
		query.setParameter("numSS", atendimento.getNumeroSS());

		Cliente cliente = null;
		List list = query.list();
		session.close();
		
		if (!list.isEmpty())
		   atendimento = (Atendimento) list.get(0);
        
		cliente = atendimento.getCliente();
		
        return cliente;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Cliente> pesquisarClientesParteNome(Cliente cliente){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT cli FROM Cliente cli WHERE cli.nomeCliente LIKE '%"+cliente.getNomeCliente()+"%'");
		
		cliente = null;
		List list = query.list();
		session.close();
		
		return list;
		
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public Cliente pesquisaClienteNome(Cliente cliente){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		Query query = session.createQuery("SELECT cli FROM Cliente cli WHERE lower(cli.nomeCliente) LIKE lower(:nomeCliente)");
		query.setParameter("nomeCliente", cliente.getNomeCliente());
		
		cliente = null;
		List list = query.list();
		session.close();
		
		if (!list.isEmpty())
		   cliente = (Cliente) list.get(0);
        
        return cliente;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
    public Cliente pesquisaClienteCnpj(Cliente cliente){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
				
		Query query = session.createQuery("FROM Cliente AS cli WHERE cli.cnpjCliente =:cnpjCli");
		query.setParameter("cnpjCli", cliente.getCnpjCliente());

		cliente = null;
		List list = query.list();
		session.close();
		
		if (!list.isEmpty())
		   cliente = (Cliente) list.get(0);
        
        return cliente;
	}

}
