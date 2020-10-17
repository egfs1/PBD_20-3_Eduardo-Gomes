package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import auth.AuthCadastrarIRRF;
import dao.GenericDAO;
import model.Pessoa;
import view.PanelCadastrarIRRF;

public class ControllerCadastrarIRRF {
	
	public ControllerCadastrarIRRF(PanelCadastrarIRRF tela) {
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigencia = tela.getTextFieldVigencia().getText().intern();
				
				String valorMinimo1 = tela.getTextFieldValorMinimo1().getText().intern();
				String valorMaximo1 = tela.getTextFieldValorMaximo1().getText().intern();
				String aliquota1 = tela.getTextFieldAliquota1().getText().intern();
				String valorDeduzir1 = tela.getTextFieldValorDeduzir1().getText().intern();
				
				String valorMinimo2 = tela.getTextFieldValorMinimo2().getText().intern();
				String valorMaximo2 = tela.getTextFieldValorMaximo2().getText().intern();
				String aliquota2 = tela.getTextFieldAliquota2().getText().intern();
				String valorDeduzir2 = tela.getTextFieldValorDeduzir2().getText().intern();
				
				String valorMinimo3 = tela.getTextFieldValorMinimo3().getText().intern();
				String valorMaximo3 = tela.getTextFieldValorMaximo3().getText().intern();
				String aliquota3 = tela.getTextFieldAliquota3().getText().intern();
				String valorDeduzir3 = tela.getTextFieldValorDeduzir3().getText().intern();
				
				String valorMinimo4 = tela.getTextFieldValorMinimo4().getText().intern();
				String valorMaximo4 = tela.getTextFieldValorMaximo4().getText().intern();
				String aliquota4 = tela.getTextFieldAliquota4().getText().intern();
				String valorDeduzir4 = tela.getTextFieldValorDeduzir4().getText().intern();
				
				String valorMinimo5 = tela.getTextFieldValorMinimo5().getText().intern();
				String valorMaximo5 = tela.getTextFieldValorMaximo5().getText().intern();
				String aliquota5 = tela.getTextFieldAliquota5().getText().intern();
				String valorDeduzir5 = tela.getTextFieldValorDeduzir5().getText().intern();
				
				Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
				
				if (AuthCadastrarIRRF.authIRRF(vigencia, valorMinimo1, valorMaximo1, aliquota1, valorDeduzir1, 
						valorMinimo2, valorMaximo2, aliquota2, valorDeduzir2, 
						valorMinimo3, valorMaximo3, aliquota3, valorDeduzir3, 
						valorMinimo4, valorMaximo4, aliquota4, valorDeduzir4, 
						valorMinimo5, valorMaximo5, aliquota5, valorDeduzir5, pessoa)) {
					limparCampos(tela);
				}
				
			}
		});
		
	}
	
	private void limparCampos(PanelCadastrarIRRF tela) {
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
