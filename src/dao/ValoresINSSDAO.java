package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import tabelasconfig.ValoresINSS;

public class ValoresINSSDAO {
	
	private EntityManager em;
	
	public boolean persist(ValoresINSS t, EntityManagerFactory emf) {
		try{
			this.em = emf.createEntityManager(); 
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}
	
	public void merge(ValoresINSS t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void remove(ValoresINSS t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.remove(em.merge(t));
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public ValoresINSS findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			ValoresINSS valores = em.find(ValoresINSS.class, id);
			em.close();
			return valores;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
}
