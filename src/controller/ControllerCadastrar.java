package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import auth.AuthCadastrarPessoa;
import view.PanelCadastro;

public class ControllerCadastrar {
	
	public ControllerCadastrar(PanelCadastro tela) {
		
		tela.getRdbtnAdministrador().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getTextFieldUsuario().setEnabled(true);
				
			}
		});
		
		tela.getRdbtnContador().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getTextFieldUsuario().setEnabled(true);
				
			}
		});
		
		tela.getRdbtnComum().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getTextFieldUsuario().setText("");
				tela.getTextFieldUsuario().setEnabled(false);
			}
		});
		
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
		
		tela.getBtnResetar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos(tela);
			}
		});
		
		tela.getBtnCadastrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean allButtonsSelected=true;
				
				
				String nome = tela.getTextFieldNome().getText().intern();
				
				String naturalidade = tela.getTextFieldNaturalidade().getText().intern();
				
				String dataNascimentoString = tela.getFormattedTextFieldData().getText().intern();
				
				Date dataAdmissao = new Date(System.currentTimeMillis());
				
				String qntFilhosString =tela.getFormattedTextFieldFilhos().getText().intern();
				
				boolean sindicalizado = false;
				if (tela.getRdbtnSindicalizadoSim().isSelected())sindicalizado = true;
				else if(tela.getRdbtnSindicalizadoNao().isSelected()) sindicalizado = false;
				else allButtonsSelected=false;
				
				String funcao = null;
				if (tela.getRdbtnAdministrador().isSelected())funcao = "Administrador";
				else if(tela.getRdbtnContador().isSelected())funcao = "Contador";
				else if(tela.getRdbtnComum().isSelected())funcao = "Comum";
				else allButtonsSelected=false;
				
				String tipo = null;
				if (tela.getRdbtnTipoMensalista().isSelected())tipo = "Mensalista";
				else if(tela.getRdbtnTipoHorista().isSelected())tipo = "Horista";
				else allButtonsSelected=false;
				
				String horasSemanaisString = tela.getFormattedTextFieldHoras().getText().intern();
				
				String usuario = tela.getTextFieldUsuario().getText().intern();
				
				
				
				if(allButtonsSelected) {
					if (funcao!="Comum") {
						AuthCadastrarPessoa.authPessoaUsuario(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString, usuario);
					}
					else {
						AuthCadastrarPessoa.authPessoaComum(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString);
					}
					limparCampos(tela);
				}
			}
		});
	}
	
	private void limparCampos(PanelCadastro tela) {
		for (Component component: tela.getComponents()) {
			System.gc();
			
			switch (component.getClass().getSimpleName()) {
			case "JTextField":
				JTextField textfield = (JTextField) component;
				textfield.setText("");
				break;

			case "JFormattedTextField":
				JFormattedTextField ftextfield = (JFormattedTextField) component;
				ftextfield.setText("");
				break;
			
			case "JRadioButton":
				JRadioButton radiob = (JRadioButton) component;
				radiob.setSelected(false);
				break;
			}	
		}
		System.gc();
	}
	
}
