package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import auth.AuthCadastrarSalarioFamilia;
import dao.GenericDAO;
import model.Pessoa;
import view.PanelCadastrarSalarioFamilia;

public class ControllerCadastrarSalarioFamilia {
	
	public ControllerCadastrarSalarioFamilia(PanelCadastrarSalarioFamilia tela) {
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigencia = tela.getTextFieldVigencia().getText().intern();
				String valor = tela.getTextFieldValor().getText().intern();
				String remuneracao = tela.getTextFieldRemuneracao().getText().intern();
				
				Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
				
				if (AuthCadastrarSalarioFamilia.authSalarioFamilia(vigencia, remuneracao, valor, pessoa)) {
					limparCampos(tela);
				}
				
			}
		});
		
	}
	
	private void limparCampos(PanelCadastrarSalarioFamilia tela) {
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
