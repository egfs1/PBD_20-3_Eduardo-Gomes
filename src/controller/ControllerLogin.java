package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import dao.GenericDAO;
import model.Criptografar;
import view.PanelDashboardAdministrador;
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
				String senha = tela.getTextFieldSenha().getText().intern();
				
				Long id = GenericDAO.getPdao().verificarLogin(usuario, Criptografar.criptografar(senha), GenericDAO.getEmf());
				if (id!=0) {
					ControllerTela.setPanel(new PanelDashboardAdministrador(id));
					System.gc();
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
