package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dao.GenericDAO;
import model.Criptografar;
import model.Pessoa;
import view.PanelDashboardAdministrador;
import view.PanelDashboardContador;
import view.PanelEsqueceuSenha;
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
				@SuppressWarnings("deprecation")
				String senha = tela.getTextFieldSenha().getText().intern();
				
				Pessoa pessoa = GenericDAO.getPdao().verificarLogin(usuario, Criptografar.criptografar(senha), GenericDAO.getEmf());
				if (pessoa!=null) {
					if (pessoa.getFuncao().equalsIgnoreCase("Administrador")) {
						ControllerTela.setPanel(new PanelDashboardAdministrador(pessoa.getId()));
						System.gc();
					}
					
					if (pessoa.getFuncao().equalsIgnoreCase("Contador")) {
						ControllerTela.setPanel(new PanelDashboardContador(pessoa.getId()));
					}
				}
			}
		});
		
		tela.getLblEsqueceuSenha().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				ControllerTela.setPanel(new PanelEsqueceuSenha());
				System.gc();

		    }  
		});
	}
	
}
