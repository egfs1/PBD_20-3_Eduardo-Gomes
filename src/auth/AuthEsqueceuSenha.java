package auth;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogResetSenha;
import model.Pessoa;

public class AuthEsqueceuSenha {
	
	public static void authUsuario(String usuario) {
		
		if (usuario=="") {
			JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!");
			return;
		}
		
		Pessoa p = GenericDAO.getPdao().findUsuarioORID(usuario, GenericDAO.getEmf());
		
		if (p!=null) {
			if (GenericDAO.getRdao().persist(p.getId(), GenericDAO.getEmf())) {
				
				LogResetSenha.logSolicitarResetSenha(p);
				
				JOptionPane.showMessageDialog(null, "Reset da senha solicitado com sucesso!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "Você já solicitou o reset da senha!");
				return;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario não foi encontrado!");
			return;
		}
		
	}
	
}
