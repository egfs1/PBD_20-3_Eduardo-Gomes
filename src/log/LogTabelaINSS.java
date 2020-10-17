package log;

import java.util.Date;

import dao.GenericDAO;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaINSS;

public class LogTabelaINSS {
	
	public static void logCadastrarTabelaINSS(Pessoa pessoa, TabelaINSS tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") cadastrou a vigência " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " da tabela inss"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarTabelaINSS(Pessoa pessoa, TabelaINSS tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") editou a vigência " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " da tabela inss"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	
	public static void logDeletarTabelaINSS(Pessoa pessoa, TabelaINSS tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") deletou a vigência " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " da tabela inss"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
