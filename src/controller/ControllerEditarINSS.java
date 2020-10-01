package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import auth.AuthEditarINSS;
import dao.GenericDAO;
import view.PanelEditarINSS;

public class ControllerEditarINSS {
	
	public ControllerEditarINSS(PanelEditarINSS tela) {
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vigência do INSS?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					GenericDAO.getTinssdao().remove(tela.getTabela(), GenericDAO.getEmf());
					JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
				}
			}
		});
		
		tela.getBtnAtualizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa vigência do INSS?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					
					
					String valorMinimo1 = tela.getTextFieldValorMinimo1().getText().intern();
					String valorMaximo1 = tela.getTextFieldValorMaximo1().getText().intern();
					String aliquota1 = tela.getTextFieldAliquota1().getText().intern();
					
					String valorMinimo2 = tela.getTextFieldValorMinimo2().getText().intern();
					String valorMaximo2 = tela.getTextFieldValorMaximo2().getText().intern();
					String aliquota2 = tela.getTextFieldAliquota2().getText().intern();
					
					String valorMinimo3 = tela.getTextFieldValorMinimo3().getText().intern();
					String valorMaximo3 = tela.getTextFieldValorMaximo3().getText().intern();
					String aliquota3 = tela.getTextFieldAliquota3().getText().intern();
					
					String valorMinimo4 = tela.getTextFieldValorMinimo4().getText().intern();
					String valorMaximo4 = tela.getTextFieldValorMaximo4().getText().intern();
					String aliquota4 = tela.getTextFieldAliquota4().getText().intern();
					
					AuthEditarINSS.authINSS(tela.getTabela(), valorMinimo1, valorMaximo1, aliquota1, valorMinimo2, valorMaximo2, aliquota2, valorMinimo3, valorMaximo3, aliquota3, valorMinimo4, valorMaximo4, aliquota4);
				
				}
			}
		});
	}
	
}
