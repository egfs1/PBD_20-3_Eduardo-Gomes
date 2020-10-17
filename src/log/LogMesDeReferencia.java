package log;

import java.util.Date;

import dao.GenericDAO;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.MesDeReferencia;

public class LogMesDeReferencia {
	
public static void logCadastrarMesDeReferencia(Pessoa pessoa, MesDeReferencia mes) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") cadastrou a vig�ncia " + FormatarVigencia.dateToFormat(mes.getVigencia()) + " do m�s de refer�ncia"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}	
	
	public static void logDeletarMesDeReferencia(Pessoa pessoa, MesDeReferencia mes) {
		
		Date data = new Date(System.currentTimeMillis());
		String texto = "Usuario " + pessoa.getUsuario() + " (" + pessoa.getId() + ") deletou a vig�ncia " + FormatarVigencia.dateToFormat(mes.getVigencia()) + " do m�s de refer�ncia"; 
		
		Log log = new Log(data, texto);
		
		GenericDAO.getLogdao().persist(log, GenericDAO.getEmf());
		
	}
	
}
