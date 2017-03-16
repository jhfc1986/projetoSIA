package com.unelev.projetosia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.ItemAtendimento;


public class ItemAtendimentoDAO extends BaseDAO{
	
	
	/**
	 * 
	 * @param itemEquipamento
	 * @return
	 */
	public List<ItemAtendimento> buscarItemPeloNumeroSSAtendimento(ItemAtendimento itema) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		Query query = session.createQuery("SELECT itm FROM ItemAtendimento itm INNER JOIN FETCH itm.itemEquipamento WHERE itm.primaryKey.numeroSsAtm = :numSS");
		query.setParameter("numSS", itema.getAtendimento().getNumeroSS());
		
		
		List list = query.list();
		session.close();
		
		return list;
	}

}
