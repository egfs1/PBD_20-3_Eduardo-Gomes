package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;
	
	public PessoaDAO() {
	}
	
	public void persist(Pessoa p, EntityManagerFactory emf) {
		try{
			this.em = emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de neg�cio de persist�ncia aqui
	
			em.persist(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close(); 
		}
	}
	
	public void merge(Pessoa p, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void remove(Pessoa p, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Pessoa find(int id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			Pessoa pessoa = em.find(Pessoa.class, id);
			if (pessoa!=null) {
				em.close();
				return pessoa;
			}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	public List<Object> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("Pessoa.findAll");
			List<Object> list = query.getResultList();
			if (list!=null) {
				em.close();
				return list;
			}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
}