package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

import auth.AuthEditarPerfil;
import view.PanelEditarPerfil;

public class ControllerEditarPerfil {
	
	public ControllerEditarPerfil(PanelEditarPerfil tela) {

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
				
				AuthEditarPerfil.authPerfil(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, usuario, novaSenha, novaSenha2, tela);
			}
		});
		
		
	}
}
