package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tabelasconfig.ValoresIRRF;

public class ValoresIRRFDAO {
	
	private EntityManager em;
	
	public boolean persist(ValoresIRRF t, EntityManagerFactory emf) {
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
	
	public void merge(ValoresIRRF t, EntityManagerFactory emf) {
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
	
	public void remove(ValoresIRRF t, EntityManagerFactory emf) {
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
	
	public ValoresIRRF findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			ValoresIRRF valores = em.find(ValoresIRRF.class, id);
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
