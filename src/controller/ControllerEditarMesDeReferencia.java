package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import auth.AuthEditarMesDeReferencia;
import view.PanelEditarMesDeReferencia;

public class ControllerEditarMesDeReferencia {
	
	
	public ControllerEditarMesDeReferencia(PanelEditarMesDeReferencia tela) {
		
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vigência do IRRF?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					String vigenciaString = tela.getTextField().getText().intern();
					
					AuthEditarMesDeReferencia.authMesDeReferencia(vigenciaString, tela.getMes());
					
				}
				
			}
		});
		
	}
}
