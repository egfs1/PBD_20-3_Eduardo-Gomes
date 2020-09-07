package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;
import model.Usuario;

public class UsuarioDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UsuarioDAO() {
		this.emf = Persistence.createEntityManagerFactory("SistemaEniatusPU");

	}
	
	public void persist(Usuario u) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de negócio de persistência aqui
	
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("deu certo");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close(); 
		}
	}
	
	public void merge(Usuario u) {
		try {
			this.em = this.emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void remove(Usuario u) {
		try {
			this.em = this.emf.createEntityManager();
			
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Usuario find(int id) {
		try {
			this.em = this.emf.createEntityManager();
			
			Usuario usuario = em.find(Usuario.class, id);
			if (usuario!=null) {
				em.close();
				return usuario;
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
