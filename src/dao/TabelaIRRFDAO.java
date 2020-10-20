package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tabelasconfig.TabelaIRRF;
import tabelasconfig.ValoresIRRF;

public class TabelaIRRFDAO {
	
	private EntityManager em;
	
	public boolean persist(TabelaIRRF t, EntityManagerFactory emf) {
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
	
	public void merge(TabelaIRRF t, EntityManagerFactory emf) {
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
	
	public void remove(TabelaIRRF t, EntityManagerFactory emf) {
		try {
			
			ValoresIRRF v1 = GenericDAO.getVirrfdao().findID(t.getIdValorIRRF1(), GenericDAO.getEmf());
			ValoresIRRF v2 = GenericDAO.getVirrfdao().findID(t.getIdValorIRRF2(), GenericDAO.getEmf());
			ValoresIRRF v3 = GenericDAO.getVirrfdao().findID(t.getIdValorIRRF3(), GenericDAO.getEmf());
			ValoresIRRF v4 = GenericDAO.getVirrfdao().findID(t.getIdValorIRRF4(), GenericDAO.getEmf());
			ValoresIRRF v5 = GenericDAO.getVirrfdao().findID(t.getIdValorIRRF5(), GenericDAO.getEmf());
			
			GenericDAO.getVirrfdao().remove(v1, emf);
			GenericDAO.getVirrfdao().remove(v2, emf);
			GenericDAO.getVirrfdao().remove(v3, emf);
			GenericDAO.getVirrfdao().remove(v4, emf);
			GenericDAO.getVirrfdao().remove(v5, emf);
			
			
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
	
	public boolean existeVigencia(TabelaIRRF t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("TabelaIRRF.findByVigencia", TabelaIRRF.class);
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
	
	public ValoresIRRF[][] getAllValues(EntityManagerFactory emf){
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("TabelaIRRF.findAll", TabelaIRRF.class);
			@SuppressWarnings("unchecked")
			List<TabelaIRRF> list = query.getResultList();
			
			ValoresIRRF[][]tabelas = new ValoresIRRF[list.size()][5];
			
			for (int i = 0; i < list.size(); i++) {
				
				for (int j = 0; j < 5; j++) {
					switch (j) {
					case 0:
						tabelas[i][j] = GenericDAO.getVirrfdao().findID(list.get(i).getIdValorIRRF1(), emf);
						break;
						
					case 1:
						tabelas[i][j] = GenericDAO.getVirrfdao().findID(list.get(i).getIdValorIRRF2(), emf);
						break;
						
					case 2:
						tabelas[i][j] = GenericDAO.getVirrfdao().findID(list.get(i).getIdValorIRRF3(), emf);
						break;
						
					case 3:
						tabelas[i][j] = GenericDAO.getVirrfdao().findID(list.get(i).getIdValorIRRF4(), emf);
						break;
						
					case 4:
						tabelas[i][j] = GenericDAO.getVirrfdao().findID(list.get(i).getIdValorIRRF5(), emf);
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
	
	public TabelaIRRF findID(Long id, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			TabelaIRRF tabela = em.find(TabelaIRRF.class, id);
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
			
			Query query = em.createNamedQuery("TabelaIRRF.findAll", TabelaIRRF.class);
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
	
	public TabelaIRRF findByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("TabelaIRRF.findByVigencia", TabelaIRRF.class);
			query.setParameter("vigencia", vigencia);
			TabelaIRRF tabela = (TabelaIRRF) query.getSingleResult();
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
			Query query = em.createNamedQuery("TabelaIRRF.findIdByVigencia", Long.class);
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
