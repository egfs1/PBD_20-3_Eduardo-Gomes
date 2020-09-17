package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;
	
	public PessoaDAO() {
	}
	
	public void persist(Pessoa p, EntityManagerFactory emf) {
		try{
			this.em = emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de negï¿½cio de persistï¿½ncia aqui
	
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
			em.remove(em.merge(p));
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Pessoa findID(int id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			Pessoa pessoa = em.find(Pessoa.class, id);
			em.close();
			return pessoa;
	
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
			@SuppressWarnings("unchecked")
			List<Object> list = query.getResultList();
			em.close();
			return list;	
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
			Query query = em.createNamedQuery("Pessoa.findUsuarioSenha", Pessoa.class);
			query.setParameter("usuario", usuario);
			query.setParameter("senha", senha);
			Pessoa p = (Pessoa) query.getSingleResult();
			em.close();
			return true;	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario/Senha inválidos!");
			e.printStackTrace();
		}
		em.close();
		return false;
	}
	
	public Pessoa findUsuario(String usuario, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("Pessoa.findUsuario", Pessoa.class);
			query.setParameter("usuario", usuario);
			Pessoa pessoa = (Pessoa) query.getSingleResult();
			em.close();
			return pessoa;	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	
	public Pessoa findUsuarioID(String input, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("Pessoa.findUsuarioID", Pessoa.class);
			
			Long inputID=(long) 0;
			try {
				inputID = Long.parseLong(input);
			}catch (Exception e) {}
			
			query.setParameter("usuario", input);
			query.setParameter("id", inputID);
			
			Pessoa pessoa = (Pessoa) query.getSingleResult();
			em.close();
			return pessoa;	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
}