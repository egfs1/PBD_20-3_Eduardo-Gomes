package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.FormatarVigencia;
import tabelasconfig.TabelaSalarioMinimo;

public class AuthCadastrarSalarioMinimo {
	
	public static boolean authSalarioMinimo(String vigencia, String valor) {
		
		try {
			
			if (vigencia.length()!=7 || valor=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				return false;			
			}
			
			Date newVigencia = FormatarVigencia.formatToDate(vigencia);
			double newValor = Double.parseDouble(valor);
			
			TabelaSalarioMinimo s = new TabelaSalarioMinimo(newVigencia, newValor);
			
			if (GenericDAO.getTsmdao().persist(s, GenericDAO.getEmf())) {
				JOptionPane.showMessageDialog(null, "Vigência Cadastrada com sucesso!");
				return true;
			}
			
			return false;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
			return false;
		}
		
	}
	
}
