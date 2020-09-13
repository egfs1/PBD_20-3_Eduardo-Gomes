package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PanelDashboardAdministrador;
import view.PanelLogin;

public class ControllerDashboardAdministrador {
	
	private PanelDashboardAdministrador tela;

	public ControllerDashboardAdministrador(PanelDashboardAdministrador tela) {
		this.tela = tela;
		
		tela.getMntmSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		tela.getMntmDeslogar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerTela.setPanel(new PanelLogin());
			}
		});
		
	}
	
	
	
	
	
}
