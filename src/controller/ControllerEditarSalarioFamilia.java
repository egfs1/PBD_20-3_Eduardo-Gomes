package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import auth.authEditarSalarioFamilia;
import dao.GenericDAO;
import view.PanelEditarSalarioFamilia;

public class ControllerEditarSalarioFamilia {
	
	public ControllerEditarSalarioFamilia(PanelEditarSalarioFamilia tela) {
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vigência do salario família?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					GenericDAO.getTsfdao().remove(tela.getTabela(), GenericDAO.getEmf());
					JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
				}
			}
		});
		
		tela.getBtnAtualizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar essa vigência do salario família?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					Long id = tela.getTabela().getId();
					Date vigencia = tela.getTabela().getVigencia();
					String remuneracao = tela.getTextFieldRemuneracao().getText().intern();
					String valor = tela.getTextFieldValor().getText().intern();
					
					authEditarSalarioFamilia.authSalarioFamilia(id, vigencia, remuneracao, valor);
					
				}
				
			}
		});
	}
	
	
	
	
}
