package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import auth.AuthCadastrarINSS;
import dao.GenericDAO;
import model.Pessoa;
import view.PanelCadastrarINSS;

public class ControllerCadastrarINSS {
	
	public ControllerCadastrarINSS(PanelCadastrarINSS tela) {
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigencia = tela.getTextFieldVigencia().getText().intern();
				
				String valorMinimo1 = tela.getTextFieldValorMinimo1().getText().intern();
				String valorMaximo1 = tela.getTextFieldValorMaximo1().getText().intern();
				String aliquota1 = tela.getTextFieldAliquota1().getText().intern();
				
				String valorMinimo2 = tela.getTextFieldValorMinimo2().getText().intern();
				String valorMaximo2 = tela.getTextFieldValorMaximo2().getText().intern();
				String aliquota2 = tela.getTextFieldAliquota2().getText().intern();
				
				String valorMinimo3 = tela.getTextFieldValorMinimo3().getText().intern();
				String valorMaximo3 = tela.getTextFieldValorMaximo3().getText().intern();
				String aliquota3 = tela.getTextFieldAliquota3().getText().intern();
				
				String valorMinimo4 = tela.getTextFieldValorMinimo4().getText().intern();
				String valorMaximo4 = tela.getTextFieldValorMaximo4().getText().intern();
				String aliquota4 = tela.getTextFieldAliquota4().getText().intern();
				
				Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
				
				if (AuthCadastrarINSS.authINSS(vigencia, valorMinimo1, valorMaximo1, aliquota1, 
						valorMinimo2, valorMaximo2, aliquota2, 
						valorMinimo3, valorMaximo3, aliquota3, 
						valorMinimo4, valorMaximo4, aliquota4, pessoa)) {
					limparCampos(tela);
				}
				
			}
		});
		
	}
	
	private void limparCampos(PanelCadastrarINSS tela) {
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
