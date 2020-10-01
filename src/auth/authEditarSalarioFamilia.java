package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import tabelasconfig.TabelaSalarioFamilia;

public class authEditarSalarioFamilia {
	
	public static void authSalarioFamilia(Long id, Date vigencia,String remuneracao, String valor) {
		
		try {
			double newRemuneracao = Double.parseDouble(remuneracao);
			double newValor = Double.parseDouble(valor);
			
			TabelaSalarioFamilia tabela = new TabelaSalarioFamilia(vigencia, newRemuneracao, newValor);
			tabela.setId(id);
			
			GenericDAO.getTsfdao().merge(tabela, GenericDAO.getEmf());
			
			JOptionPane.showMessageDialog(null, "Tabela Atualizada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
