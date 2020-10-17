package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ControllerCadastrarSalarioMinimo;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCadastrarSalarioMinimo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldVigencia;
	private JTextField textFieldValor;
	private JButton btnSalvar;
	
	private Long UserId;
	

	/**
	 * Create the panel.
	 */
	public PanelCadastrarSalarioMinimo(Long UserId) {
		this.UserId = UserId;
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Vig\u00EAncia do Salario Fam\u00EDlia");
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
		
		panel.setBounds(245, 144, 310, 280);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Vig\u00EAncia");
		lblNewLabel_1.setBounds(100, 32, 71, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldVigencia = new JTextField();
		textFieldVigencia.setBounds(100, 73, 110, 30);
		panel.add(textFieldVigencia);
		textFieldVigencia.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor");
		lblNewLabel_1_1.setBounds(100, 114, 71, 30);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(100, 155, 110, 30);
		panel.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(110, 228, 89, 30);
		panel.add(btnSalvar);
		
		new ControllerCadastrarSalarioMinimo(this);
	}


	public JTextField getTextFieldVigencia() {
		return textFieldVigencia;
	}


	public JTextField getTextFieldValor() {
		return textFieldValor;
	}


	public JButton getBtnSalvar() {
		return btnSalvar;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getUserId() {
		return UserId;
	}
	
	
}
