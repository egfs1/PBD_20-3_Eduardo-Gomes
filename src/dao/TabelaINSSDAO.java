package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tabelasconfig.TabelaINSS;
import tabelasconfig.ValoresINSS;

public class TabelaINSSDAO {
	
	private EntityManager em;
	
	public boolean persist(TabelaINSS t, EntityManagerFactory emf) {
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
	
	public void merge(TabelaINSS t, EntityManagerFactory emf) {
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
	
	public void remove(TabelaINSS t, EntityManagerFactory emf) {
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
	
	public boolean existeVigencia(TabelaINSS t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("TabelaINSS.findByVigencia", TabelaINSS.class);
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
	
	public ValoresINSS[][] getAllValues(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("TabelaINSS.findAll", TabelaINSS.class);
			@SuppressWarnings("unchecked")
			List<TabelaINSS> list = query.getResultList();
			
			ValoresINSS[][]tabelas = new ValoresINSS[list.size()][4];
			
			for (int i = 0; i < list.size(); i++) {
				
				for (int j = 0; j < 4; j++) {
					switch (j) {
					case 0:
						tabelas[i][j] = GenericDAO.getVinssdao().findID(list.get(i).getIdValorINSS1(), emf);
						break;
						
					case 1:
						tabelas[i][j] = GenericDAO.getVinssdao().findID(list.get(i).getIdValorINSS2(), emf);
						break;
						
					case 2:
						tabelas[i][j] = GenericDAO.getVinssdao().findID(list.get(i).getIdValorINSS3(), emf);
						break;
						
					case 3:
						tabelas[i][j] = GenericDAO.getVinssdao().findID(list.get(i).getIdValorINSS4(), emf);
						break;
					}
				}
			}
			em.close();
			return tabelas;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	public List<Object> findAll(EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("TabelaINSS.findAll", TabelaINSS.class);
			@SuppressWarnings("unchecked")
			List<Object> list = query.getResultList();
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
