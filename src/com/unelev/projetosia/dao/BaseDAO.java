package com.unelev.projetosia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
	
	/**
	 * 
	 * método responsavel por persistir objeto da base
	 * 
	 * @param obj
	 * @return
	 */
	public void salvar(Object obj) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.save(obj);
	     
		session.getTransaction().commit();
		
		session.close();

	}
    
	/**
	 *
	 * método responsavel por atualizar objeto da base
	 * 
	 * @param obj
	 * @return
	 */
	public void update(Object obj) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.merge(obj);
		
		session.getTransaction().commit();
		
		session.close();
		

	}

	/**
	 * 
	 * método responsavel por excluir objeto da base
	 * 
	 * @param obj
	 */
	public void delete(Object obj) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.delete(obj);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
