package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import controller.ControllerCadastrarMesDeReferencia;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCadastrarMesDeReferencia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JButton btnSalvar;
	
	private Long UserId;

	public PanelCadastrarMesDeReferencia(Long UserId) {
		this.UserId = UserId;
		
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Gerar M\u00EAs de Refer\u00EAncia");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblTitulo.setBackground(SystemColor.textHighlight);
		lblTitulo.setBounds(0, 0, 800, 60);
		add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(245, 179, 310, 209);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Vig\u00EAncia");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(100, 32, 71, 30);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 73, 110, 30);
		panel.add(textField);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(110, 141, 89, 30);
		panel.add(btnSalvar);
		
		new ControllerCadastrarMesDeReferencia(this);
	}

	public JTextField getTextField() {
		return textField;
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
