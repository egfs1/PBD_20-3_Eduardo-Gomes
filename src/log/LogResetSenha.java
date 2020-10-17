package log;

import java.util.Date;

import dao.GenericDAO;
import model.Pessoa;

public class LogResetSenha {
	
	public static void logSolicitarResetSenha(Pessoa pessoaQueSolicitou) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoaQueSolicitou.getUsuario() + " (" + pessoaQueSolicitou.getId() + ") solicitou o reset da senha"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
	public static void logFazerResetSenha(Pessoa pessoaQueFez, Pessoa pessoaQueSolicitou) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoaQueFez.getUsuario() + " (" + pessoaQueFez.getId() + ") fez o reset da senha do usuario " + pessoaQueSolicitou.getUsuario() + " (" + pessoaQueSolicitou.getId() + ")"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
