package app;

import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerTela;
import dao.GenericDAO;
import model.Pessoa;
import model.Usuario;

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
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Pessoa p = new Pessoa("Eduardo", "Brasileiro", 0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
		GenericDAO.persist(p);
		Usuario u = new Usuario("admin", "admin", 0, true);
		GenericDAO.persist(u);
		
		ControllerTela.initTela();
		
		
	}
		

}
