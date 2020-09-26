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
	
	public boolean persist(Pessoa p, EntityManagerFactory emf) {
		try{ 
			if (!existeUsuario(p.getUsuario(), emf)) {
				this.em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(p);
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
			return false;
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
	
	public Pessoa findID(Long id, EntityManagerFactory emf) {
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
	
	public List<Pessoa> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("Pessoa.findAll", Pessoa.class);
			@SuppressWarnings("unchecked")
			List<Pessoa> list = query.getResultList();
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
	
	public Pessoa verificarLogin(String usuario, String senha, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("Pessoa.findByUsuarioANDSenha", Pessoa.class);
			query.setParameter("usuario", usuario);
			query.setParameter("senha", senha);
			Pessoa pessoa = (Pessoa) query.getSingleResult();
			em.close();
			return pessoa;	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario/Senha inválidos!");
		}
		em.close();
		return null;
	}
	
	public boolean existeUsuario(String usuario, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("Pessoa.findUsuario", Pessoa.class);
			query.setParameter("usuario", usuario);
			boolean existe = query.getResultList().size() > 0;
			em.close();
			return existe;
		}
		catch (Exception e) {
			em.close();
		}
		em.close();
		return false;
	}
	
	
	public Pessoa findUsuarioORID(String input, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("Pessoa.findUsuarioORID", Pessoa.class);
			
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
		}
		em.close();
		return null;
	}
	
}