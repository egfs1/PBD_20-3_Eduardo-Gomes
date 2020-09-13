package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Funcionario;

public class FuncionarioDAO {
	
	private EntityManager em;
	
	public FuncionarioDAO() {
	}
	
	public void persist(Funcionario f, EntityManagerFactory emf) {
		try{
			this.em = emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de neg�cio de persist�ncia aqui
	
			em.persist(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close(); 
		}
	}
	
	public void merge(Funcionario f, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(f);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void remove(Funcionario f, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.remove(f);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Funcionario find(int id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			Funcionario funcionario = em.find(Funcionario.class, id);
			if (funcionario!=null) {
				em.close();
				return funcionario;
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
			
			Query query = em.createNamedQuery("Usuario.findAll");
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
