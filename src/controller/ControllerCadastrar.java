package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.lang3.RandomStringUtils;

import dao.GenericDAO;
import model.Pessoa;
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
				String charactersSenha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
				
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
						String senhaGerada = RandomStringUtils.random( 8, charactersSenha );
						validarPessoaUsuario(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString, usuario, senhaGerada, tela);
					}
					else {
						validarPessoaComum(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString, tela);
					}
				}
			}
		});
		
		
	}
	
	private void validarPessoaUsuario(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, String usuario,
			String senha, PanelCadastro tela) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		if (nome=="" || naturalidade == "" || usuario=="" || qntFilhos=="" || !(dataNascimento.length()==10) || horasSemanaisContratadas=="") {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Date newDataNascimento = null;
		int newQntFilhos;
		int newHorasSemanais;
		try {
			newQntFilhos = Integer.parseInt(qntFilhos);
			newHorasSemanais = Integer.parseInt(horasSemanaisContratadas);
			newDataNascimento = DateFor.parse(dataNascimento);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (dataAdmissao.before(newDataNascimento)) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais, usuario, senha);
		GenericDAO.getPdao().persist(p, GenericDAO.getEmf());
		JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!\n Nome de usuario: " + usuario + "\n Senha: " + senha + "\n certifique-se de copiar a senha antes de apertar OK!");
		limparCampos(tela);
	}
	
	private void validarPessoaComum(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, PanelCadastro tela) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		if (nome=="" || naturalidade == "" || qntFilhos=="" || !(dataNascimento.length()==10) || horasSemanaisContratadas=="") {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Date newDataNascimento = null;
		int newQntFilhos;
		int newHorasSemanais;
		try {
			newQntFilhos = Integer.parseInt(qntFilhos);
			newHorasSemanais = Integer.parseInt(horasSemanaisContratadas);
			newDataNascimento = DateFor.parse(dataNascimento);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (dataAdmissao.before(newDataNascimento)) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais);
		GenericDAO.getPdao().persist(p, GenericDAO.getEmf());
		JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
		limparCampos(tela);
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
