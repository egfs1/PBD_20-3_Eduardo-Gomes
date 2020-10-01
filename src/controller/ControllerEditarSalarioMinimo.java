package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import auth.authEditarSalarioMinimo;
import dao.GenericDAO;
import view.PanelEditarSalarioMinimo;

public class ControllerEditarSalarioMinimo {
	
	public ControllerEditarSalarioMinimo(PanelEditarSalarioMinimo tela) {
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vig�ncia do salario m�nimo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					GenericDAO.getTsmdao().remove(tela.getTabela(), GenericDAO.getEmf());
					JOptionPane.showMessageDialog(null, "Vig�ncia deletada com sucesso!");
				}
			}
		});
		
		tela.getBtnAtualizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar essa vig�ncia do salario m�nimo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					Long id = tela.getTabela().getId();
					Date vigencia = tela.getTabela().getVigencia();
					String valor = tela.getTextFieldValor().getText().intern();
					
					authEditarSalarioMinimo.authSalarioMinimo(id, vigencia, valor);
					
				}
				
			}
		});
	}
	
	
	
	
}
