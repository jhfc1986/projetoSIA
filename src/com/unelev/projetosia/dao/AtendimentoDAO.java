package com.unelev.projetosia.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.util.Constantes;

public class AtendimentoDAO extends BaseDAO{
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorDataSSListAtendimentoCliente(Cliente cliente,Atendimento atendimento) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = null;
        String queryText = "FROM Atendimento AS at WHERE at.cliente.cnpjCliente =:cnpjCli";
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		
		param.put("cnpjCli", cliente.getCnpjCliente());
		
		if(atendimento.getNumeroSS()!= null && atendimento.getNumeroSS()!= 0 ){
		   
			queryText +=" AND at.numeroSS =:numeroSS"; 
		    param.put("numeroSS", atendimento.getNumeroSS());
		    
		    if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
				
				queryText +=" AND at.dataAbertura =:dtIni"; 
			    param.put("dtIni", atendimento.getDataAbertura());
			
			}else if(atendimento.getDataFechamento()!= null && atendimento.getDataAbertura()== null){
			 
			    queryText +=" AND at.dataAbertura =:dataFechamento"; 
			    param.put("dataFechamento", atendimento.getDataFechamento());
			
			}else if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
			   
			    queryText +=" AND at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
			    param.put("dataAbertura", atendimento.getDataAbertura());
			    param.put("dataFechamento", atendimento.getDataFechamento());
			
			}
		    
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0) 
				&& atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
			
			queryText +=" AND at.dataAbertura >=:dtIni"; 
		    param.put("dtIni", atendimento.getDataAbertura());
		    
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0)
				&& atendimento.getDataAbertura()== null && atendimento.getDataFechamento()!= null){
			
			queryText +=" AND at.dataAbertura <=:dataFechamento"; 
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0) 
				&& atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
			
			queryText +=" AND at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
		    param.put("dataAbertura", atendimento.getDataAbertura());
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}
		
		query = session.createQuery(queryText);
		query.setProperties(param);
		
		List list = query.list();
		session.close();
		
        return list;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorDataSSListAtendimento(Atendimento atendimento) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = null;
		String queryText = "FROM Atendimento AS at WHERE";
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		
		
		if(atendimento.getNumeroSS()!= null && atendimento.getNumeroSS()!= 0 ){
		   
			queryText +=" at.numeroSS =:numeroSS"; 
		    param.put("numeroSS", atendimento.getNumeroSS());
		    
		    if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
				
				queryText +=" AND at.dataAbertura >=:dtIni"; 
			    param.put("dtIni", atendimento.getDataAbertura());
			
			}else if(atendimento.getDataFechamento()!= null && atendimento.getDataAbertura()== null){
			 
			    queryText +=" AND at.dataAbertura <=:dataFechamento"; 
			    param.put("dataFechamento", atendimento.getDataFechamento());
			
			}else if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
			   
			    queryText +=" AND at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
			    param.put("dataAbertura", atendimento.getDataAbertura());
			    param.put("dataFechamento", atendimento.getDataFechamento());
			
			}
		    
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0) 
				&& atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
			
			queryText +=" at.dataAbertura >=:dtIni"; 
		    param.put("dtIni", atendimento.getDataAbertura());
		    
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0)
				&& atendimento.getDataAbertura()== null && atendimento.getDataFechamento()!= null){
			
			queryText +=" at.dataAbertura <=:dataFechamento"; 
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0) 
				&& atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
			
			queryText +=" at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
		    param.put("dataAbertura", atendimento.getDataAbertura());
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}
		
		query = session.createQuery(queryText);
		query.setProperties(param);
		
		List list = query.list();
		session.close();
		
        return list;
	}
	
		
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorDataSS(Atendimento atendimento) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = null;
		String queryText = "FROM Atendimento AS at WHERE";
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		
		
		if(atendimento.getNumeroSS()!= null && atendimento.getNumeroSS()!= 0 ){
		   
			queryText +=" at.numeroSS =:numeroSS"; 
		    param.put("numeroSS", atendimento.getNumeroSS());
		    
		    if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
				
				queryText +=" AND at.dataAbertura =:dtIni"; 
			    param.put("dtIni", atendimento.getDataAbertura());
			
			}else if(atendimento.getDataFechamento()!= null && atendimento.getDataAbertura()== null){
			 
			    queryText +=" AND at.dataAbertura =:dataFechamento"; 
			    param.put("dataFechamento", atendimento.getDataFechamento());
			
			}else if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
			   
			    queryText +=" AND at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
			    param.put("dataAbertura", atendimento.getDataAbertura());
			    param.put("dataFechamento", atendimento.getDataFechamento());
			
			}
		    
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0) 
				&& atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
			
			queryText +=" at.dataAbertura =:dtIni"; 
		    param.put("dtIni", atendimento.getDataAbertura());
		    
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0)
				&& atendimento.getDataAbertura()== null && atendimento.getDataFechamento()!= null){
			
			queryText +=" at.dataAbertura =:dataFechamento"; 
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}else if((atendimento.getNumeroSS()== null || atendimento.getNumeroSS()== 0) 
				&& atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
			
			queryText +=" at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
		    param.put("dataAbertura", atendimento.getDataAbertura());
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}
		
		query = session.createQuery(queryText);
		query.setProperties(param);
		
		List list = query.list();
		session.close();
		
        return list;
	}
	
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoAtivos() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Atendimento AS at WHERE at.statusPendencia =:stAtm ");
		query.setParameter("stAtm", Constantes.STATUS_ABERTO);
		
		List list = query.list();
		session.close();
		
        return list;
	}
    
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorCliente(Cliente cliente) {
		
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
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoPorClienteDataSS(Cliente cliente,Atendimento atendimento) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = null;
		String queryText = "FROM Atendimento AS at WHERE at.cliente.cnpjCliente =:cnpjCli";
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		
		param.put("cnpjCli", cliente.getCnpjCliente());
		
		if(atendimento.getNumeroSS()!= null && atendimento.getNumeroSS()!= 0 ){
		   
			queryText +=" AND at.numeroSS =:numeroSS"; 
		    param.put("numeroSS", atendimento.getNumeroSS());
		
		}else if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()== null){
		
			queryText +=" AND at.dataAbertura =:dtIni"; 
		    param.put("dtIni", atendimento.getDataAbertura());
		
		}else if(atendimento.getDataFechamento()!= null && atendimento.getDataAbertura()== null){
		 
		    queryText +=" AND at.dataAbertura =:dataFechamento"; 
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}else if(atendimento.getDataAbertura()!= null && atendimento.getDataFechamento()!= null){
		   
		    queryText +=" AND at.dataAbertura BETWEEN :dataAbertura AND :dataFechamento)";
		    param.put("dataAbertura", atendimento.getDataAbertura());
		    param.put("dataFechamento", atendimento.getDataFechamento());
		
		}
		
		query = session.createQuery(queryText);
		query.setProperties(param);
		
		List list = query.list();
		session.close();
		
        return list;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Atendimento> pesquisaAtendimentoAbertoCliente(Cliente cliente) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Atendimento AS at WHERE at.cliente.cnpjCliente =:cnpjCli ");
		query.setParameter("cnpjCli", cliente.getCnpjCliente());
				
		List list = query.list();
		session.close();
		
        return list;
	}

}
