package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import dao.GenericDAO;
import model.Criptografar;
import view.PanelEditarPerfil;

public class ControllerEditarPerfil {
	
	private PanelEditarPerfil tela;
	
	public ControllerEditarPerfil(PanelEditarPerfil tela) {
		this.tela = tela;

		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar essas alterações?", "", JOptionPane.YES_NO_OPTION);
				if (input!=0)return;
				
				String nome = tela.getTextFieldNome().getText().intern();
				
				String naturalidade = tela.getTextFieldNaturalidade().getText().intern();
				
				String dataNascimentoString = tela.getFormattedTextFieldData().getText().intern();
				
				Date dataAdmissao = tela.getPessoa().getDataAdmissao();
				
				String qntFilhosString =tela.getFormattedTextFieldFilhos().getText().intern();
				
				String usuario = tela.getTextFieldUsuario().getText().intern();
				
				String novaSenha = tela.getTextFieldSenha().getText().intern();
				
				String novaSenha2 = tela.getTextFieldSenha2().getText().intern();
				
				validarPessoaUsuario(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, usuario, novaSenha, novaSenha2);
			}
		});
		
		
	}
	
	private void validarPessoaUsuario(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			String usuario,	String novaSenha, String novaSenha2) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		if (nome=="" || naturalidade == "" || usuario=="" || qntFilhos=="" || !(dataNascimento.length()==10)) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Date newDataNascimento = null;
		int newQntFilhos;
		try {
			newQntFilhos = Integer.parseInt(qntFilhos);
			newDataNascimento = DateFor.parse(dataNascimento);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (dataAdmissao.before(newDataNascimento)) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (!tela.getPessoa().getUsuario().equalsIgnoreCase(usuario) && GenericDAO.getPdao().existeUsuario(usuario, GenericDAO.getEmf())) {
			JOptionPane.showMessageDialog(null, "Esse nome de usuario já existe!");
			return;
		}
		
		if (novaSenha!="" || novaSenha2!="") {
			if(novaSenha!=novaSenha2) {
				JOptionPane.showMessageDialog(null, "As senhas estão diferentes!");
				return;
			}
		}
		
		if (novaSenha.length()<6 || novaSenha.length() > 11) {
			JOptionPane.showMessageDialog(null, "A senha precisa ter entre 6 e 11 caracteres!");
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
	
}
