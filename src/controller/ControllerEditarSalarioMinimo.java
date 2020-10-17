package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import auth.authEditarSalarioMinimo;
import dao.GenericDAO;
import log.LogSalarioMinimo;
import model.Pessoa;
import view.PanelEditarSalarioMinimo;

public class ControllerEditarSalarioMinimo {
	
	public ControllerEditarSalarioMinimo(PanelEditarSalarioMinimo tela) {
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vigência do salario mínimo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					GenericDAO.getTsmdao().remove(tela.getTabela(), GenericDAO.getEmf());
					
					Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
					LogSalarioMinimo.logDeletarSalarioMinimo(pessoa, tela.getTabela());
					
					JOptionPane.showMessageDialog(null, "Vigência do salario minimo deletada com sucesso!");
				}
			}
		});
		
		tela.getBtnAtualizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar essa vigência do salario mínimo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					Long id = tela.getTabela().getId();
					Date vigencia = tela.getTabela().getVigencia();
					String valor = tela.getTextFieldValor().getText().intern();
					
					Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
					authEditarSalarioMinimo.authSalarioMinimo(id, vigencia, valor, pessoa);
					
				}
				
			}
		});
	}
	
	
	
	
}
