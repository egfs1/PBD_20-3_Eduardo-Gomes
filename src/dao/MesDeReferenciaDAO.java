package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tabelasconfig.MesDeReferencia;
import tabelasconfig.TabelaINSS;
import tabelasconfig.TabelaIRRF;
import tabelasconfig.TabelaSalarioFamilia;
import tabelasconfig.TabelaSalarioMinimo;

public class MesDeReferenciaDAO {

	private EntityManager em;
	
	public boolean persist(MesDeReferencia t, EntityManagerFactory emf) {
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
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;
		}
	}
	
	public void merge(MesDeReferencia t, EntityManagerFactory emf) {
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
	
	public void remove(MesDeReferencia t, EntityManagerFactory emf) {
		try {
			
			TabelaINSS inss = GenericDAO.getTinssdao().findID(t.getIdINSS(), GenericDAO.getEmf());
			TabelaIRRF irrf = GenericDAO.getTirrfdao().findID(t.getIdIRRF(), GenericDAO.getEmf());
			TabelaSalarioFamilia salarioFamilia = GenericDAO.getTsfdao().findID(t.getIdSalarioFamilia(), GenericDAO.getEmf());
			TabelaSalarioMinimo salarioMinimo = GenericDAO.getTsmdao().findID(t.getIdSalarioMinimo(), GenericDAO.getEmf());
			
			GenericDAO.getTinssdao().remove(inss, emf);
			GenericDAO.getTirrfdao().remove(irrf, emf);
			GenericDAO.getTsfdao().remove(salarioFamilia, emf);
			GenericDAO.getTsmdao().remove(salarioMinimo, emf);
			
			
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
	
	public boolean existeVigencia(MesDeReferencia t, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("MesDeReferencia.findByVigencia", MesDeReferencia.class);
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
	
	public MesDeReferencia findByVigencia(Date vigencia, EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			Query query = em.createNamedQuery("MesDeReferencia.findByVigencia", MesDeReferencia.class);
			query.setParameter("vigencia", vigencia);
			MesDeReferencia tabela = (MesDeReferencia) query.getSingleResult();
			em.close();
			return tabela;
		}
		catch (Exception e) {
		}
		em.close();
		return null;
	}
	
	public List<MesDeReferencia> findAll(EntityManagerFactory emf) {
		try {
			this.em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("MesDeReferencia.findAll", MesDeReferencia.class);
			@SuppressWarnings("unchecked")
			List<MesDeReferencia> list = query.getResultList();
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
