package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogMesDeReferencia;
import model.Pessoa;
import view.PanelEditarMesDeReferencia;

public class ControllerEditarMesDeReferencia {
	
	
	public ControllerEditarMesDeReferencia(PanelEditarMesDeReferencia tela) {
		
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vig�ncia do IRRF?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					GenericDAO.getMdrdao().remove(tela.getMes(), GenericDAO.getEmf());
					
					Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
					LogMesDeReferencia.logDeletarMesDeReferencia(pessoa, tela.getMes());
					
					JOptionPane.showMessageDialog(null, "Vig�ncia do m�s de refer�ncia deletado com sucesso!");
					
				}
				
			}
		});
		
	}
}
