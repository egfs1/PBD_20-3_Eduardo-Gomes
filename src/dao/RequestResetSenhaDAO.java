package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.RequestResetSenha;

public class RequestResetSenhaDAO {
	
	private EntityManager em;
	
	public RequestResetSenhaDAO() {
	}
	
	public boolean persist(Long idPessoa, EntityManagerFactory emf) {
		try{ 
			if (findRequest(idPessoa, emf)==null) {
				this.em = emf.createEntityManager();
				RequestResetSenha r = new RequestResetSenha(idPessoa, new Date(System.currentTimeMillis()));
				em.getTransaction().begin();
				em.persist(r);
				em.getTransaction().commit();
				em.close();
				return true;
			}
			return false;
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}
	
	public boolean remove(Long idPessoa, EntityManagerFactory emf) {
		try {
			RequestResetSenha r = findRequest(idPessoa, emf);
			if (r!=null) {
				this.em = emf.createEntityManager();
				em.getTransaction().begin();
				em.remove(em.merge(r));
				em.getTransaction().commit();
				em.close();
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}
	
	public List<Object> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("RequestResetSenha.findAll");
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
	
	public RequestResetSenha findRequest(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("RequestResetSenha.findByIDPessoa", RequestResetSenha.class);
			query.setParameter("idpessoa", id);
			RequestResetSenha request = (RequestResetSenha) query.getSingleResult();
			em.close();
			return request;
		}
		catch (Exception e) {
			em.close();
			return null;
		}
	}
	
	
}