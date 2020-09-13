package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;
	
	public UsuarioDAO() {
	}
	
	public void persist(Usuario u, EntityManagerFactory emf) {
		try{
			this.em = emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de neg�cio de persist�ncia aqui
	
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close(); 
		}
	}
	
	public void merge(Usuario u, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
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
	
	public void remove(Usuario u, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
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
	
	public Usuario find(int id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
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
	
	public boolean verificarLogin(String usuario, String senha, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("Usuario.findUsuarioSenha", Usuario.class);
			query.setParameter("usuario", usuario);
			query.setParameter("senha", senha);
			Usuario u = (Usuario) query.getSingleResult();
			if (u.isPermissao()) {
				em.close();
				return true;
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return false;
	}
}
