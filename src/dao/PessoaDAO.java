package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class PessoaDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PessoaDAO() {
		this.emf = Persistence.createEntityManagerFactory("SistemaEniatusPU");

	}
	
	public void persist(Pessoa p) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); 
			//regras de negócio de persistência aqui
	
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("deu certo");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close(); 
		}
	}
}