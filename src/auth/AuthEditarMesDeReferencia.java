package auth;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import tabelasconfig.MesDeReferencia;

public class AuthEditarMesDeReferencia {
	
	public static void authMesDeReferencia(String vigencia, MesDeReferencia mes) {
		
		try {
			
			GenericDAO.getMdrdao().remove(mes, GenericDAO.getEmf());
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
			return;
		}
		
	}
	
}
