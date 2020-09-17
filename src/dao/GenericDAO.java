package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaEniatus");
//	private static FuncionarioDAO fdao = new FuncionarioDAO();
	private static PessoaDAO pdao = new PessoaDAO();
//	private static UsuarioDAO udao = new UsuarioDAO();
	
//	public static void persist(Object o) {
//		
//		switch (o.getClass().getSimpleName()) {
//		case "Pessoa":
//			pdao.persist((Pessoa)o, emf);
//			break;
//
//		case "Funcionario":
//			fdao.persist((Funcionario)o, emf);
//			break;
//		
//		case "Usuario":
//			udao.persist((Usuario)o, emf);
//			break;
//		}
//	}
//	
//	public static void merge(Object o) {
//		
//		switch (o.getClass().getSimpleName()) {
//		case "Pessoa":
//			pdao.merge((Pessoa)o, emf);
//			break;
//
//		case "Funcionario":
//			fdao.merge((Funcionario)o, emf);
//			break;
//		
//		case "Usuario":
//			udao.merge((Usuario)o, emf);
//			break;
//		}
//	}
//	
//	public static void remove(Object o) {
//		
//		switch (o.getClass().getSimpleName()) {
//		case "Pessoa":
//			pdao.remove((Pessoa)o, emf);
//			break;
//
//		case "Funcionario":
//			fdao.remove((Funcionario)o, emf);
//			break;
//		
//		case "Usuario":
//			udao.remove((Usuario)o, emf);
//			break;
//		}
//	}
//	
//	public static Object find(String nameClass, int id) {
//		
//		switch (nameClass) {
//		case "Pessoa":
//			return pdao.find(id, emf);
//
//		case "Funcionario":
//			return fdao.find(id, emf);
//		
//		case "Usuario":
//			return udao.find(id, emf);
//		}
//		return null;
//	}
//		
//	public static List<Object> findAll(String nameClass) {
//		
//		switch (nameClass) {
//		case "Pessoa":
//			return pdao.findAll( emf);
//
//		case "Funcionario":
//			return fdao.findAll(emf);
//		
//		case "Usuario":
//			return udao.findAll(emf);
//		}
//		return null;
//	}
	

	public static EntityManagerFactory getEmf() {
		return emf;
	}

//	public static FuncionarioDAO getFdao() {
//		return fdao;
//	}

	public static PessoaDAO getPdao() {
		return pdao;
	}

//	public static UsuarioDAO getUdao() {
//		return udao;
//	}
	
	
	
}
