package auth;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.Criptografar;
import view.PanelEditarPerfil;

public class AuthEditarPerfil {
	
	private static int newQntFilhos;
	private static Date newDataNascimento;
	
	public static void authPerfil(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			String usuario,	String novaSenha, String novaSenha2, PanelEditarPerfil tela) {
		
		if (!verifyFields(nome, naturalidade, qntFilhos, dataNascimento, dataAdmissao, usuario, novaSenha, novaSenha2))return;
		
		if (!tela.getPessoa().getUsuario().equalsIgnoreCase(usuario) && GenericDAO.getPdao().existeUsuario(usuario, GenericDAO.getEmf())) {
			JOptionPane.showMessageDialog(null, "Esse nome de usuario já existe!");
			return;
		}
		
		tela.getPessoa().setNome(nome);
		tela.getPessoa().setNaturalidade(naturalidade);
		tela.getPessoa().setDataNascimento(newDataNascimento);
		tela.getPessoa().setQntFilhos(newQntFilhos);
		tela.getPessoa().setUsuario(usuario);
		tela.getPessoa().setSenha(Criptografar.criptografar(novaSenha));
		
		GenericDAO.getPdao().merge(tela.getPessoa(), GenericDAO.getEmf());
		
		JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
	}
	
	private static boolean verifyFields(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao, String usuario, String novaSenha, String novaSenha2) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			if (nome=="" || naturalidade == "" || qntFilhos=="" || !(dataNascimento.length()==10) || usuario=="" || novaSenha=="" || novaSenha2=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				return false;
			}
			
			if(novaSenha!=novaSenha2) {
				JOptionPane.showMessageDialog(null, "As senhas estão diferentes!");
				return false;
			}
			
			newQntFilhos = Integer.parseInt(qntFilhos);
			newDataNascimento = DateFor.parse(dataNascimento);
			
			if (dataAdmissao.before(newDataNascimento)) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				return false;
			}
			
			if (novaSenha.length()<6 || novaSenha.length() > 11) {
				JOptionPane.showMessageDialog(null, "A senha precisa ter entre 6 e 11 caracteres!");
				return false;
			}
			
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return false;
		}
	}
	
}
