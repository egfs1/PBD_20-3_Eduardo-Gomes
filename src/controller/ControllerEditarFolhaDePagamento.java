package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import auth.AuthEditarFolhaDePagamento;
import dao.GenericDAO;
import folhadepagamento.FolhaDePagamento;
import log.LogFolhaDePagamento;
import model.Pessoa;
import view.PanelEditarFolhaDePagamento;

public class ControllerEditarFolhaDePagamento {
	
	public ControllerEditarFolhaDePagamento(PanelEditarFolhaDePagamento tela) {
		
		tela.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = tela.getTextFieldUsuario().getText().intern();
				String vigencia = tela.getTextFieldVigencia().getText().intern();
				
				AuthEditarFolhaDePagamento.authBuscar(vigencia, usuario, tela);
			}
		});
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa folha de pagamento?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					GenericDAO.getFpdao().remove(tela.getFolha(), GenericDAO.getEmf());
					
					Pessoa pessoa = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
					LogFolhaDePagamento.logDeletarFolha(pessoa, tela.getFolha(), tela.getUsuario());
					
					JOptionPane.showMessageDialog(null, "Folha de pagamento deletada com sucesso!");
				}
				
			}
		});
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String auxilioAlimentacao = tela.getTextFieldAuxilioAlimentacao().getText().intern();
				String horaExtra = tela.getTextFieldHoraExtra().getText().intern();
				String acrescimoValor = tela.getTextFieldAcrescimoValor().getText().intern();
				String acrescimoDescricao = tela.getTextFieldAcrescimoDescricao().getText().intern();
				String contribuicaoSindical = tela.getTextFieldContribuicaoSindical().getText().intern();
				String faltas = tela.getTextFieldFaltas().getText().intern();
				String descontoValor = tela.getTextFieldDescontoValor().getText().intern();
				String descontoDescricao = tela.getTextFieldDescontoDescricao().getText().intern();
				
				Pessoa pessoaQueGerou = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
				Pessoa funcionario = tela.getUsuario();
				FolhaDePagamento folha = tela.getFolha();
				
				AuthEditarFolhaDePagamento.authEditarFolhaDePagamento(auxilioAlimentacao, horaExtra, acrescimoValor, acrescimoDescricao, contribuicaoSindical, faltas, descontoValor, descontoDescricao, pessoaQueGerou, funcionario, folha);
				
				
			}
		});
		
	}
	
}
