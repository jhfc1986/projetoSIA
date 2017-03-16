package com.unelev.projetosia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.ItemEquipamento;

public class ItemEquipamentoDAO extends BaseDAO {
	
	/**
	 * 
	 * @param itemEquipamento
	 * @return
	 */
	public ItemEquipamento buscarItemPeloNome(ItemEquipamento itemEquipamento) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		Query query = session.createQuery("SELECT itm FROM ItemEquipamento itm WHERE lower(itm.nomeItem) LIKE lower(:nomeItem)");
		query.setParameter("nomeItem", itemEquipamento.getNomeItem());
		
		itemEquipamento = null;
		List list = query.list();
		session.close();
		
		if (!list.isEmpty())
		   itemEquipamento = (ItemEquipamento) list.get(0);
        
        return itemEquipamento;
	}

}
