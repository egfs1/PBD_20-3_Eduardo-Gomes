package dao;

import java.util.Date;
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
			
			ValoresINSS v1 = GenericDAO.getVinssdao().findID(t.getIdValorINSS1(), GenericDAO.getEmf());
			ValoresINSS v2 = GenericDAO.getVinssdao().findID(t.getIdValorINSS2(), GenericDAO.getEmf());
			ValoresINSS v3 = GenericDAO.getVinssdao().findID(t.getIdValorINSS3(), GenericDAO.getEmf());
			ValoresINSS v4 = GenericDAO.getVinssdao().findID(t.getIdValorINSS4(), GenericDAO.getEmf());
			
			GenericDAO.getVinssdao().remove(v1, emf);
			GenericDAO.getVinssdao().remove(v2, emf);
			GenericDAO.getVinssdao().remove(v3, emf);
			GenericDAO.getVinssdao().remove(v4, emf);
			
			
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
	
	public TabelaINSS findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			TabelaINSS tabela = em.find(TabelaINSS.class, id);
			em.close();
			return tabela;
	
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
	
	public TabelaINSS findByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("TabelaINSS.findByVigencia", TabelaINSS.class);
			query.setParameter("vigencia", vigencia);
			TabelaINSS tabela = (TabelaINSS) query.getSingleResult();
			em.close();
			return tabela;
		}
		catch (Exception e) {
		}
		em.close();
		return null;
	}
	
	public Long findIdByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("TabelaINSS.findIdByVigencia", Long.class);
			query.setParameter("vigencia", vigencia);
			Long id = (Long) query.getSingleResult();
			em.close();
			return id;
		}
		catch (Exception e) {
		}
		em.close();
		return null;
	}
}
