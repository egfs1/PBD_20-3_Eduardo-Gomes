package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ControllerEditarSalarioFamilia;
import model.FormatarVigencia;
import tabelasconfig.TabelaSalarioFamilia;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelEditarSalarioFamilia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldVigencia;
	private JTextField textFieldRemuneracao;
	private JButton btnAtualizar;
	private JTextField textFieldValor;
	private JButton btnDeletar;
	
	private TabelaSalarioFamilia tabela;

	/**
	 * Create the panel.
	 */
	public PanelEditarSalarioFamilia(TabelaSalarioFamilia tabela) {
		this.tabela = tabela;
		
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Vig\u00EAncia do Salario Minimo");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 0, 800, 60);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		
		panel.setBounds(245, 144, 310, 340);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Vig\u00EAncia");
		lblNewLabel_1.setBounds(100, 11, 71, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldVigencia = new JTextField(FormatarVigencia.dateToFormat(tabela.getVigencia()));
		textFieldVigencia.setEnabled(false);
		textFieldVigencia.setBounds(100, 52, 110, 30);
		panel.add(textFieldVigencia);
		textFieldVigencia.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Remunera\u00E7\u00E3o Mensal");
		lblNewLabel_1_1.setBounds(100, 93, 180, 30);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldRemuneracao = new JTextField(tabela.getRemuneracaoMensal() + "");
		textFieldRemuneracao.setBounds(100, 134, 110, 30);
		panel.add(textFieldRemuneracao);
		textFieldRemuneracao.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(175, 299, 89, 30);
		panel.add(btnAtualizar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor Unit\u00E1rio");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(100, 175, 110, 30);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldValor = new JTextField(tabela.getValorUnitario() + "");
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(100, 216, 110, 30);
		panel.add(textFieldValor);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(44, 299, 89, 30);
		panel.add(btnDeletar);
		
		new ControllerEditarSalarioFamilia(this);
	}


	public JTextField getTextFieldVigencia() {
		return textFieldVigencia;
	}


	public JTextField getTextFieldRemuneracao() {
		return textFieldRemuneracao;
	}


	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}


	public JTextField getTextFieldValor() {
		return textFieldValor;
	}


	public TabelaSalarioFamilia getTabela() {
		return tabela;
	}


	public JButton getBtnDeletar() {
		return btnDeletar;
	}



	
	
}
