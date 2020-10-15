package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import auth.AuthCadastrarMesDeReferencia;
import view.PanelCadastrarMesDeReferencia;

public class ControllerCadastrarMesDeReferencia {
	
	
	public ControllerCadastrarMesDeReferencia(PanelCadastrarMesDeReferencia tela) {
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigenciaString = tela.getTextField().getText().intern();
				
				AuthCadastrarMesDeReferencia.authMesDeReferencia(vigenciaString);
			}
		});
		
	}
}
