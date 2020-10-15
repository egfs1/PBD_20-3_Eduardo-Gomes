package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tabelasconfig.TabelaSalarioMinimo;

public class TabelaSalarioMinimoDAO {
	
	private EntityManager em;
	
	public boolean persist(TabelaSalarioMinimo t, EntityManagerFactory emf) {
		try{ 
			if (!existeVigencia(t, emf)) {
				this.em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(t);
				em.getTransaction().commit();
				em.close();
				return true;
			}
			else {
				em.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}
	
	public void merge(TabelaSalarioMinimo t, EntityManagerFactory emf) {
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
	
	public void remove(TabelaSalarioMinimo t, EntityManagerFactory emf) {
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
	
	public boolean existeVigencia(TabelaSalarioMinimo t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("SalarioMinimo.findByVigencia", TabelaSalarioMinimo.class);
			query.setParameter("vigencia", t.getVigencia());
			boolean existe = query.getResultList().size() > 0;
			em.close();
			return existe;
		}
		catch (Exception e) {
		}
		em.close();
		return false;
	}
	
	public TabelaSalarioMinimo findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			TabelaSalarioMinimo tabela = em.find(TabelaSalarioMinimo.class, id);
			em.close();
			return tabela;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	public TabelaSalarioMinimo findByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("SalarioMinimo.findByVigencia", TabelaSalarioMinimo.class);
			query.setParameter("vigencia", vigencia);
			TabelaSalarioMinimo tabela = (TabelaSalarioMinimo) query.getSingleResult();
			em.close();
			return tabela;
		}
		catch (Exception e) {
		}
		em.close();
		return null;
	}
	
	public List<TabelaSalarioMinimo> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("SalarioMinimo.findAll", TabelaSalarioMinimo.class);
			@SuppressWarnings("unchecked")
			List<TabelaSalarioMinimo> list = query.getResultList();
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
	
	public Long findIdByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("SalarioMinimo.findIdByVigencia", Long.class);
			query.setParameter("vigencia", vigencia);
			Long id = (Long) query.getSingleResult();
			em.close();
			return id;
		}
		catch (Exception e) {
		}
		em.close();
		return null;
	}
	
}
