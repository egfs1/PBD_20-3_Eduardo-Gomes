package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaEniatus");
	private static PessoaDAO pdao = new PessoaDAO();
	private static RequestResetSenhaDAO rdao = new RequestResetSenhaDAO();
	
	

	public static EntityManagerFactory getEmf() {
		return emf;
	}


	public static PessoaDAO getPdao() {
		return pdao;
	}


	public static RequestResetSenhaDAO getRdao() {
		return rdao;
	}
	

	
}
