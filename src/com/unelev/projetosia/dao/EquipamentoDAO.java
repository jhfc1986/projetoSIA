package com.unelev.projetosia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.Equipamento;

public class EquipamentoDAO extends BaseDAO {
	
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Equipamento> pesquisarEquipamentos() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("SELECT DISTINCT eq.marcaEquipamento FROM Equipamento eq");
		
		List list = query.list();
		
		session.close();
		
		ArrayList<String> array = (ArrayList<String>) list;
		
		ArrayList<Equipamento> ret = new ArrayList<Equipamento>();
		
		for(String str : array){
			Equipamento e = new Equipamento();
			e.setMarcaEquipamento(str);
		    ret.add(e);
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @param equipamento
	 * @return
	 */
    public List<Equipamento> pesquisarEquipamentosPelaMarca(Equipamento equipamento) {
    	
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Equipamento AS eq WHERE lower(eq.marcaEquipamento) LIKE lower(:nomeMod)");
		query.setParameter("nomeMod", equipamento.getMarcaEquipamento());
		
		List list = query.list();
		session.close();
		
        return list;
	}
    
    /**
     * 
     * @param equipamento
     * @return
     */
    public Equipamento pesquisarEquipamentosPelaMarcaEModelo(Equipamento equipamento){
    	
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Equipamento AS eq WHERE eq.numModelo = :numMod");
		query.setParameter("numMod", equipamento.getNumModelo());
		
		List list = query.list();
		session.close();
		
        return (Equipamento) list.get(0);
    }
    
}
