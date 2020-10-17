package log;

import java.util.Date;

import dao.GenericDAO;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaIRRF;

public class LogTabelaIRRF {
	
public static void logCadastrarTabelaIRRF(Pessoa pessoa, TabelaIRRF tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") cadastrou a vigência " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " da tabela irrf"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarTabelaIRRF(Pessoa pessoa, TabelaIRRF tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") editou a vigência " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " da tabela irrf"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	
	public static void logDeletarTabelaIRRF(Pessoa pessoa, TabelaIRRF tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") deletou a vigência " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " da tabela irrf"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
