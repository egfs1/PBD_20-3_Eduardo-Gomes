package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import tabelasconfig.TabelaSalarioMinimo;

public class authEditarSalarioMinimo {
	
	public static void authSalarioMinimo(Long id, Date vigencia, String valor) {
		
		try {
			double newValor = Double.parseDouble(valor);
			
			TabelaSalarioMinimo tabela = new TabelaSalarioMinimo(vigencia, newValor);
			tabela.setId(id);
			
			GenericDAO.getTsmdao().merge(tabela, GenericDAO.getEmf());
			
			JOptionPane.showMessageDialog(null, "Tabela Atualizada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
