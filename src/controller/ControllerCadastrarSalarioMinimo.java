package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import auth.AuthCadastrarSalarioMinimo;
import view.PanelCadastrarSalarioMinimo;

public class ControllerCadastrarSalarioMinimo {
	
	public ControllerCadastrarSalarioMinimo(PanelCadastrarSalarioMinimo tela) {
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigencia = tela.getTextFieldVigencia().getText().intern();
				String valor = tela.getTextFieldValor().getText().intern();
				
				if (AuthCadastrarSalarioMinimo.authSalarioMinimo(vigencia, valor)) {
					limparCampos(tela);
				}
				
			}
		});
		
	}
	
	private void limparCampos(PanelCadastrarSalarioMinimo tela) {
		for (Component component: tela.getComponents()) {
			System.gc();
			
			switch (component.getClass().getSimpleName()) {
			case "JTextField":
				JTextField textfield = (JTextField) component;
				textfield.setText("");
				break;

			case "JFormattedTextField":
				JFormattedTextField ftextfield = (JFormattedTextField) component;
				ftextfield.setText("");
				break;
			}	
		}
		System.gc();
	}
}
