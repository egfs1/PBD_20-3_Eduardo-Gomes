package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.FormatarVigencia;
import tabelasconfig.TabelaSalarioFamilia;

public class AuthCadastrarSalarioFamilia {
	
	public static boolean authSalarioFamilia(String vigencia,String remuneracao, String valor) {
		
		try {
			
			if (vigencia.length()!=7 ||remuneracao=="" || valor=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				return false;			
			}
			
			Date newVigencia = FormatarVigencia.formatToDate(vigencia);
			double newRemuneracao = Double.parseDouble(remuneracao);
			double newValor = Double.parseDouble(valor);
			
			TabelaSalarioFamilia s = new TabelaSalarioFamilia(newVigencia,newRemuneracao, newValor);
			
			if (GenericDAO.getTsfdao().persist(s, GenericDAO.getEmf())) {
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
