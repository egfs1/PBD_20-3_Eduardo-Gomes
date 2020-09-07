package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Funcionario;
import model.Pessoa;

public class FuncionarioDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public FuncionarioDAO() {
		this.emf = Persistence.createEntityManagerFactory("SistemaEniatusPU");

	}
	
	public void persist(Funcionario f) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de negócio de persistência aqui
	
			em.persist(f);
			em.getTransaction().commit();
			System.out.println("deu certo");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close(); 
		}
	}
	
	public void merge(Funcionario f) {
		try {
			this.em = this.emf.createEntityManager();
			
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
	
	public void remove(Funcionario f) {
		try {
			this.em = this.emf.createEntityManager();
			
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
	
	public Funcionario find(int id) {
		try {
			this.em = this.emf.createEntityManager();
			
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
	
//	public ArrayList<> findAll() {
//
//	}
}
