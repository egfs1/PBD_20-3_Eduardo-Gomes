package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import dao.PessoaDAO;
import model.Pessoa;

public class App {
	
//	public static synchronized void getConnectionInstance() {
//        try {
//
//        	Connection conexao = DriverManager.getConnection(
//        			"jdbc:postgresql://localhost:5433/SistemaEniatus",
//                    "postgres",
//                    "postgres"
//            );
//        	System.out.println("deu certo");
//                
//        } catch (SQLException ex) {
//        	System.out.println("deu errado");
//            ex.printStackTrace();
//        }
//
//    }

	public static void main(String[] args) {
		Pessoa p = new Pessoa("Eduardo", "Brasileiro", 0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
		PessoaDAO dao = new PessoaDAO();
		dao.persist(p);
		
		
	}
		

}
