package app;


import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerTela;
import dao.GenericDAO;
import model.Criptografar;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaINSS;
import tabelasconfig.TabelaIRRF;
import tabelasconfig.ValoresINSS;
import tabelasconfig.ValoresIRRF;

@SuppressWarnings("all")
public class App {

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
//		
//		Pessoa p = new Pessoa("eduardo", "brasileiro", 0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), false, "Administrador", "Mensalista", 40, "admin", Criptografar.criptografar("admin"));
//		GenericDAO.getPdao().persist(p, GenericDAO.getEmf());
		
//		ValoresINSS v1 = new ValoresINSS(0, 1000, 0);
//		ValoresINSS v2 = new ValoresINSS(1001, 2000, 7.5);
//		ValoresINSS v3 = new ValoresINSS(2001, 3000, 9);
//		ValoresINSS v4 = new ValoresINSS(3001, 0, 12);
//		GenericDAO.getVinssdao().persist(v1, GenericDAO.getEmf());
//		GenericDAO.getVinssdao().persist(v2, GenericDAO.getEmf());
//		GenericDAO.getVinssdao().persist(v3, GenericDAO.getEmf());
//		GenericDAO.getVinssdao().persist(v4, GenericDAO.getEmf());
//		
//		TabelaINSS t = new TabelaINSS(FormatarVigencia.formatToDate("10/2020"), new Long(1), new Long(2), new Long(3), new Long(4));
//		GenericDAO.getTinssdao().persist(t, GenericDAO.getEmf());
		
		
//		ValoresIRRF v5 = new ValoresIRRF(0, 1904.98, 0, 0);
//		ValoresIRRF v6 = new ValoresIRRF(1904.99, 2826.65, 7.5, 142.80);
//		ValoresIRRF v7 = new ValoresIRRF(2826.66, 3751.05, 15, 354.80);
//		ValoresIRRF v8 = new ValoresIRRF(3751.06, 4664.68, 22.5, 636.13);
//		ValoresIRRF v9 = new ValoresIRRF(4664.68, 0, 27.5, 869.36);
//		GenericDAO.getVirrfdao().persist(v5, GenericDAO.getEmf());
//		GenericDAO.getVirrfdao().persist(v6, GenericDAO.getEmf());
//		GenericDAO.getVirrfdao().persist(v7, GenericDAO.getEmf());
//		GenericDAO.getVirrfdao().persist(v8, GenericDAO.getEmf());
//		GenericDAO.getVirrfdao().persist(v9, GenericDAO.getEmf());
//		
//		TabelaIRRF t2 = new TabelaIRRF(FormatarVigencia.formatToDate("10/2020"), new Long(1), new Long(2), new Long(3), new Long(4), new Long(5));
//		GenericDAO.getTirrfdao().persist(t2, GenericDAO.getEmf());
		
//		
		ControllerTela.initTela();
		
		
	}
		

}
