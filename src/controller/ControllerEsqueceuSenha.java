package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import auth.AuthEsqueceuSenha;
import view.PanelEsqueceuSenha;
import view.PanelLogin;

public class ControllerEsqueceuSenha {
	
	public ControllerEsqueceuSenha(PanelEsqueceuSenha tela) {
		tela.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerTela.setPanel(new PanelLogin());
				System.gc();
			}
		});
		
		tela.getBtnSolicitar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = tela.getTextFieldUsuario().getText().intern();
				AuthEsqueceuSenha.authUsuario(usuario);
			}
		});
	}
	
}
