package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.Pessoa;
import view.PanelEsqueceuSenha;
import view.PanelLogin;

public class ControllerEsqueceuSenha {
	
	public ControllerEsqueceuSenha(PanelEsqueceuSenha tela) {
		tela.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerTela.setPanel(new PanelLogin());
				System.gc();
			}
		});
		
		tela.getBtnSolicitar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = tela.getTextFieldUsuario().getText().intern();
				validarPessoa(usuario);
				
			}
		});
	}
	
	private void validarPessoa(String usuario) {
		
		if (usuario=="") {
			JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!");
			return;
		}
		
		Pessoa p = GenericDAO.getPdao().findUsuarioORID(usuario, GenericDAO.getEmf());
		if (p!=null) {
			if (GenericDAO.getRdao().persist(p.getId(), GenericDAO.getEmf())) {
				JOptionPane.showMessageDialog(null, "Reset da senha solicitado com sucesso!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "Você já solicitou o reset da senha!");
				return;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario não foi encontrado!");
			return;
		}
		
	}
	
}
