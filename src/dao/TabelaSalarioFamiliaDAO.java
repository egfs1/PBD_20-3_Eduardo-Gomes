package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tabelasconfig.TabelaSalarioFamilia;

public class TabelaSalarioFamiliaDAO {
	
	private EntityManager em;
	
	public boolean persist(TabelaSalarioFamilia t, EntityManagerFactory emf) {
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
	
	public void merge(TabelaSalarioFamilia t, EntityManagerFactory emf) {
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
	
	public void remove(TabelaSalarioFamilia t, EntityManagerFactory emf) {
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
	
	public boolean existeVigencia(TabelaSalarioFamilia t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("SalarioFamilia.findByVigencia", TabelaSalarioFamilia.class);
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
	
	public TabelaSalarioFamilia findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			TabelaSalarioFamilia tabela = em.find(TabelaSalarioFamilia.class, id);
			em.close();
			return tabela;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	public TabelaSalarioFamilia findByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("SalarioFamilia.findByVigencia", TabelaSalarioFamilia.class);
			query.setParameter("vigencia", vigencia);
			TabelaSalarioFamilia tabela = (TabelaSalarioFamilia) query.getSingleResult();
			em.close();
			return tabela;
		}
		catch (Exception e) {
		}
		em.close();
		return null;
	}
	
	public List<TabelaSalarioFamilia> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("SalarioFamilia.findAll", TabelaSalarioFamilia.class);
			@SuppressWarnings("unchecked")
			List<TabelaSalarioFamilia> list = query.getResultList();
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
			Query query = em.createNamedQuery("SalarioFamilia.findIdByVigencia", Long.class);
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
