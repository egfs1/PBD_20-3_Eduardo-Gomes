package log;

import java.util.Date;

import dao.GenericDAO;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaSalarioFamilia;

public class LogSalarioFamilia {
	
	public static void logCadastrarSalarioFamilia(Pessoa pessoa, TabelaSalarioFamilia tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") cadastrou a vig�ncia " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " do sal�rio fam�lia"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarSalarioFamilia(Pessoa pessoa, TabelaSalarioFamilia tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") editou a vig�ncia " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " do sal�rio fam�lia"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	
	public static void logDeletarSalarioFamilia(Pessoa pessoa, TabelaSalarioFamilia tabela) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") deletou a vig�ncia " + FormatarVigencia.dateToFormat(tabela.getVigencia()) + " do sal�rio fam�lia"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
