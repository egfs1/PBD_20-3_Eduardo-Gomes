package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import auth.authEditarSalarioFamilia;
import dao.GenericDAO;
import log.LogSalarioFamilia;
import model.Pessoa;
import view.PanelEditarSalarioFamilia;

public class ControllerEditarSalarioFamilia {
	
	public ControllerEditarSalarioFamilia(PanelEditarSalarioFamilia tela) {
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vig�ncia do salario fam�lia?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					GenericDAO.getTsfdao().remove(tela.getTabela(), GenericDAO.getEmf());
					
					Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
					LogSalarioFamilia.logDeletarSalarioFamilia(pessoa, tela.getTabela());
					
					JOptionPane.showMessageDialog(null, "Vig�ncia do salario familia deletado com sucesso!");
				}
			}
		});
		
		tela.getBtnAtualizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar essa vig�ncia do salario fam�lia?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					Long id = tela.getTabela().getId();
					Date vigencia = tela.getTabela().getVigencia();
					String remuneracao = tela.getTextFieldRemuneracao().getText().intern();
					String valor = tela.getTextFieldValor().getText().intern();
					
					Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
					
					authEditarSalarioFamilia.authSalarioFamilia(id, vigencia, remuneracao, valor, pessoa);
					
				}
				
			}
		});
	}
	
	
	
	
}
