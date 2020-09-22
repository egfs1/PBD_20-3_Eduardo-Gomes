package auth;

import javax.swing.JOptionPane;

import dao.GenericDAO;
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
				JOptionPane.showMessageDialog(null, "Reset da senha solicitado com sucesso!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "Voc� j� solicitou o reset da senha!");
				return;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario n�o foi encontrado!");
			return;
		}
		
	}
	
}
