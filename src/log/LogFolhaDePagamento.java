package log;

import java.util.Date;

import dao.GenericDAO;
import folhadepagamento.FolhaDePagamento;
import model.FormatarVigencia;
import model.Pessoa;

public class LogFolhaDePagamento {
	
	public static void logGerarFolha(Pessoa pessoaQueGerou, FolhaDePagamento folha, Pessoa funcionarioDaFolha) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoaQueGerou.getUsuario() + " (" + pessoaQueGerou.getId() + ") gerou a folha de pagamento da vigencia " + FormatarVigencia.dateToFormat(folha.getVigencia()) + " do funcionário " + funcionarioDaFolha.getNome() + "(" + funcionarioDaFolha.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarFolha(Pessoa pessoaQueGerou, FolhaDePagamento folha, Pessoa funcionarioDaFolha) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoaQueGerou.getUsuario() + " (" + pessoaQueGerou.getId() + ") editou a folha de pagamento da vigencia " + FormatarVigencia.dateToFormat(folha.getVigencia()) + " do funcionário " + funcionarioDaFolha.getNome() + "(" + funcionarioDaFolha.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	
	public static void logDeletarFolha(Pessoa pessoaQueGerou, FolhaDePagamento folha, Pessoa funcionarioDaFolha) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoaQueGerou.getUsuario() + " (" + pessoaQueGerou.getId() + ") deletou a folha de pagamento da vigencia " + FormatarVigencia.dateToFormat(folha.getVigencia()) + " do funcionário " + funcionarioDaFolha.getNome() + "(" + funcionarioDaFolha.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
}
