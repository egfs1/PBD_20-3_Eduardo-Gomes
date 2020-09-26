package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tabelasconfig.TabelaINSS;
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
			Query query = em.createNamedQuery("TabelaIRRF.findByVigencia", TabelaINSS.class);
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
	
}
