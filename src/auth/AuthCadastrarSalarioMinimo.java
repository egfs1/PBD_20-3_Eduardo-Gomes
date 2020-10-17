package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogSalarioMinimo;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaSalarioMinimo;

public class AuthCadastrarSalarioMinimo {
	
	public static boolean authSalarioMinimo(String vigencia, String valor, Pessoa pessoa) {
		
		try {
			
			if (vigencia.length()!=7 || valor=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				return false;			
			}
			
			Date newVigencia = FormatarVigencia.formatToDate(vigencia);
			double newValor = Double.parseDouble(valor);
			
			TabelaSalarioMinimo tabela = new TabelaSalarioMinimo(newVigencia, newValor);
			
			if (GenericDAO.getTsmdao().persist(tabela, GenericDAO.getEmf())) {
				
				LogSalarioMinimo.logCadastrarSalarioMinimo(pessoa, tabela);
				
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
