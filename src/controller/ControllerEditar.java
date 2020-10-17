package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

import auth.AuthEditarPessoa;
import dao.GenericDAO;
import log.LogPessoa;
import model.Pessoa;
import view.PanelEditar;

public class ControllerEditar {
	
	public ControllerEditar(PanelEditar tela) {
		
		tela.getRdbtnTipoHorista().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getFormattedTextFieldHoras().setText("");
				tela.getFormattedTextFieldHoras().setEnabled(true);
				
			}
		});
		
		tela.getRdbtnTipoMensalista().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getFormattedTextFieldHoras().setText("40");
				tela.getFormattedTextFieldHoras().setEnabled(false);
			}
		});
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar esse funcionário da base de dados?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					if (!(tela.getPessoa().getId()==tela.getIdUser())) {
						GenericDAO.getPdao().remove(tela.getPessoa(), GenericDAO.getEmf());
						JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
						
						Pessoa user = GenericDAO.getPdao().findID(tela.getIdUser(), GenericDAO.getEmf());
						LogPessoa.logDeletarPessoa(user, tela.getPessoa());
					}else {
						JOptionPane.showMessageDialog(null, "Você não pode deletar o usuario que está usando!");
					}
				}
			}
		});
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = tela.getTextFieldNome().getText().intern();
				
				String naturalidade = tela.getTextFieldNaturalidade().getText().intern();
				
				String dataNascimentoString = tela.getFormattedTextFieldData().getText().intern();
				
				Date dataAdmissao = tela.getPessoa().getDataAdmissao();
				
				String qntFilhosString =tela.getFormattedTextFieldFilhos().getText().intern();
				
				boolean sindicalizado = false;
				if (tela.getRdbtnSindicalizadoSim().isSelected())sindicalizado = true;
				else if(tela.getRdbtnSindicalizadoNao().isSelected()) sindicalizado = false;
				
				String funcao = tela.getPessoa().getFuncao();
				
				String tipo = null;
				if (tela.getRdbtnTipoMensalista().isSelected())tipo = "Mensalista";
				else if(tela.getRdbtnTipoHorista().isSelected())tipo = "Horista";
				
				String horasSemanaisString = tela.getFormattedTextFieldHoras().getText().intern();
				
				String usuario = tela.getTextFieldUsuario().getText().intern();
				
				String senha = tela.getPessoa().getSenha();
				
				if (funcao!="Comum") {
					AuthEditarPessoa.authPessoaUsuario(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString, usuario, senha, tela);
				}
				else {
					AuthEditarPessoa.authPessoaComum(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString, tela);
				}
			}
		});
	}
}
