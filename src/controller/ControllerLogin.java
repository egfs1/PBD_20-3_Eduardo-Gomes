package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.GenericDAO;
import view.PanelDashboardAdministrador;
import view.PanelLogin;

public class ControllerLogin {
	
	public ControllerLogin(PanelLogin tela) {
		tela.getBtnSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		tela.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = tela.getTextFieldUsuario().getText().intern();
				String senha = tela.getTextFieldSenha().getText().intern();
				
				if (GenericDAO.getPdao().verificarLogin(usuario, senha, GenericDAO.getEmf())) {
					ControllerTela.setPanel(new PanelDashboardAdministrador());
					System.gc();
				}
			}
		});
	}
	
}
