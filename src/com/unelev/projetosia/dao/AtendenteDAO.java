package com.unelev.projetosia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.Atendente;


public class AtendenteDAO extends BaseDAO{
	
	/**
	 * 
	 * @param atendente
	 * @return
	 */
	public Atendente buscarAtendenteMatricula(Atendente atendente){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Atendente WHERE matAtendente = :matAtendente AND passAtendente = :passAtendente");
		query.setParameter("matAtendente", atendente.getMatAtendente());
		query.setParameter("passAtendente", atendente.getPassAtendente());
		atendente = null;
		List list = query.list();
		session.close();
		
		if (!list.isEmpty())
		   atendente = (Atendente) list.get(0);
        
        return atendente;
	}

}
