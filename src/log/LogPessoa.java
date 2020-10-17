package log;

import java.util.Date;

import dao.GenericDAO;
import model.Pessoa;

public class LogPessoa {
	
	public static void logCadastrarPessoa(Pessoa pessoaQueCadastrou, Pessoa pessoaCadastrada) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcion�rio " + pessoaQueCadastrou.getNome() + " (" + pessoaQueCadastrou.getId() + ") cadastrou o funcion�rio " + pessoaCadastrada.getNome() + " (" + pessoaCadastrada.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarPessoa(Pessoa pessoaQueEditou, Pessoa pessoaEditadaAntiga, Pessoa pessoaEditadaNova) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcion�rio " + pessoaQueEditou.getNome() + " (" + pessoaQueEditou.getId() + ") "
				+ "editou o funcion�rio " + pessoaEditadaAntiga.getNome() + " (" + pessoaEditadaAntiga.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	public static void logEditarPerfil(Pessoa pessoa) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcion�rio " + pessoa.getUsuario() + " (" + pessoa.getId() + ") "
				+ "editou o seu perfil"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	public static void logDeletarPessoa(Pessoa pessoaQueDeletou, Pessoa pessoaDeletada) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcion�rio " + pessoaQueDeletou.getNome() + " (" + pessoaQueDeletou.getId() + ") deletou o funcion�rio " + pessoaDeletada.getNome() + " (" + pessoaDeletada.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
