package log;

import java.util.Date;

import dao.GenericDAO;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaSalarioMinimo;

public class LogSalarioMinimo {
	
	public static void logCadastrarSalarioMinimo(Pessoa pessoa, TabelaSalarioMinimo tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") cadastrou a vig�ncia " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " do sal�rio m�nimo"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarSalarioMinimo(Pessoa pessoa, TabelaSalarioMinimo tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") editou a vig�ncia " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " do sal�rio m�nimo"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	
	public static void logDeletarSalarioMinimo(Pessoa pessoa, TabelaSalarioMinimo tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") deletou a vig�ncia " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " do sal�rio m�nimo"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
