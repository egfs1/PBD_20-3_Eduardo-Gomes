package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import auth.AuthCadastrarMesDeReferencia;
import dao.GenericDAO;
import model.Pessoa;
import view.PanelCadastrarMesDeReferencia;

public class ControllerCadastrarMesDeReferencia {
	
	
	public ControllerCadastrarMesDeReferencia(PanelCadastrarMesDeReferencia tela) {
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigenciaString = tela.getTextField().getText().intern();
				
				Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
				
				AuthCadastrarMesDeReferencia.authMesDeReferencia(vigenciaString, pessoa);
			}
		});
		
	}
}
