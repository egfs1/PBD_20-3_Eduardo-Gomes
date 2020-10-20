package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import auth.AuthGerarFolhaDePagamento;
import dao.GenericDAO;
import model.Pessoa;
import view.PanelGerarFolhaDePagamento;

public class ControllerGerarFolhaDePagamento {
	
	public ControllerGerarFolhaDePagamento(PanelGerarFolhaDePagamento tela) {
		
		tela.getBtnGerar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigencia = tela.getTextFieldVigencia().getText().intern();
				String usuario = tela.getTextFieldUsuario().getText().intern();
				String auxilioAlimentacao = tela.getTextFieldAuxilioAlimentacao().getText().intern();
				String horaExtra = tela.getTextFieldHoraExtra().getText().intern();
				String acrescimoValor = tela.getTextFieldAcrescimoValor().getText().intern();
				String acrescimoDescricao = tela.getTextFieldAcrescimoDescricao().getText().intern();
				String contribuicaoSindical = tela.getTextFieldContribuicaoSindical().getText().intern();
				String faltas = tela.getTextFieldFaltas().getText().intern();
				String descontoValor = tela.getTextFieldDescontoValor().getText().intern();
				String descontoDescricao = tela.getTextFieldDescontoDescricao().getText().intern();
				
				Pessoa pessoaQueGerou = GenericDAO.getPdao().findID(tela.getUserId(), GenericDAO.getEmf());
				
				AuthGerarFolhaDePagamento.authGerarFolhaDePagamento(vigencia, usuario, auxilioAlimentacao, horaExtra, acrescimoValor, acrescimoDescricao, contribuicaoSindical, faltas, descontoValor, descontoDescricao, pessoaQueGerou);
				
			}
		});
		
	}
	
}
