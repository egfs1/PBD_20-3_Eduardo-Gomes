package log;

import java.util.Date;

import dao.GenericDAO;
import model.Pessoa;

public class LogPessoa {
	
	public static void logCadastrarPessoa(Pessoa pessoaQueCadastrou, Pessoa pessoaCadastrada) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcionário " + pessoaQueCadastrou.getNome() + " (" + pessoaQueCadastrou.getId() + ") cadastrou o funcionário " + pessoaCadastrada.getNome() + " (" + pessoaCadastrada.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logEditarPessoa(Pessoa pessoaQueEditou, Pessoa pessoaEditadaAntiga, Pessoa pessoaEditadaNova) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcionário " + pessoaQueEditou.getNome() + " (" + pessoaQueEditou.getId() + ") "
				+ "editou o funcionário " + pessoaEditadaAntiga.getNome() + " (" + pessoaEditadaAntiga.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	public static void logEditarPerfil(Pessoa pessoa) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcionário " + pessoa.getUsuario() + " (" + pessoa.getId() + ") "
				+ "editou o seu perfil"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
	}
	
	public static void logDeletarPessoa(Pessoa pessoaQueDeletou, Pessoa pessoaDeletada) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Funcionário " + pessoaQueDeletou.getNome() + " (" + pessoaQueDeletou.getId() + ") deletou o funcionário " + pessoaDeletada.getNome() + " (" + pessoaDeletada.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
