package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogSalarioMinimo;
import model.Pessoa;
import tabelasconfig.TabelaSalarioMinimo;

public class authEditarSalarioMinimo {
	
	public static void authSalarioMinimo(Long id, Date vigencia, String valor, Pessoa pessoa) {
		
		try {
			double newValor = Double.parseDouble(valor);
			
			TabelaSalarioMinimo tabela = new TabelaSalarioMinimo(vigencia, newValor);
			tabela.setId(id);
			
			GenericDAO.getTsmdao().merge(tabela, GenericDAO.getEmf());
			
			LogSalarioMinimo.logEditarSalarioMinimo(pessoa, tabela);
			
			JOptionPane.showMessageDialog(null, "Tabela Atualizada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
