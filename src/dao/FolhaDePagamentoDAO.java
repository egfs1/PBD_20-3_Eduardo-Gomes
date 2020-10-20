package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import folhadepagamento.FolhaDePagamento;

public class FolhaDePagamentoDAO {
	
	private EntityManager em;
	
	public boolean persist(FolhaDePagamento folha, EntityManagerFactory emf) {
		
		if (!existeFolha(folha, emf)) {
			try{ 
				this.em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(folha);
				em.getTransaction().commit();
				em.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(null, "Já existe uma folha de pagamento para esse funcionário nessa vigência");
			return false;
		}
	}
	
	public void merge(FolhaDePagamento folha, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(folha);
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void remove(FolhaDePagamento folha, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.remove(em.merge(folha));
			em.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public FolhaDePagamento findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			FolhaDePagamento pessoa = em.find(FolhaDePagamento.class, id);
			em.close();
			return pessoa;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	
	public boolean existeFolha(FolhaDePagamento folha, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("FolhaDePagamento.findByUserIdAndVigencia", FolhaDePagamento.class);
			query.setParameter("user_id", folha.getUser_id());
			query.setParameter("vigencia", folha.getVigencia());
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
	
	public FolhaDePagamento findByUserIdAndVigencia(Long user_id, Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("FolhaDePagamento.findByUserIdAndVigencia", FolhaDePagamento.class);
			query.setParameter("user_id", user_id);
			query.setParameter("vigencia", vigencia);
			FolhaDePagamento folha = (FolhaDePagamento) query.getSingleResult();
			em.close();
			return folha;
		}
		catch (Exception e) {
			em.close();
		}
		em.close();
		return null;
	}
	
	public List<FolhaDePagamento> findAll(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("FolhaDePagamento.findAll", FolhaDePagamento.class);
			@SuppressWarnings("unchecked")
			List<FolhaDePagamento> list = query.getResultList();
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
	
}
