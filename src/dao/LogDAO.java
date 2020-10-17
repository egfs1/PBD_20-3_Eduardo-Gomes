package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import log.Log;

public class LogDAO {
	
	private EntityManager em;
	
	public void persist(Log log, EntityManagerFactory emf) {
		try{ 
			this.em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(log);
			em.getTransaction().commit();
			em.close();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return;
		}
	}
	
	public List<Log> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("Log.findAll", Log.class);
			@SuppressWarnings("unchecked")
			List<Log> list = query.getResultList();
			em.close();
			return list;	
		}
		catch (Exception e) {
			em.close();
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	
}
