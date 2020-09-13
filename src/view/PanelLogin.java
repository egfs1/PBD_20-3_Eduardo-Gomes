package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.ControllerLogin;

public class PanelLogin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JTextField textFieldSenha;
	private JButton btnLogin, btnSair;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setBorder(null);
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 180, 209), 10, true));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(250, 100, 300, 400);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setBackground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 300, 60);
		panel.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(SystemColor.text);
		lblUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblUsuario.setBounds(10, 100, 280, 21);
		panel.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		textFieldUsuario.setBounds(10, 129, 280, 30);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblSenha.setBounds(10, 192, 270, 21);
		panel.add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(10, 224, 280, 30);
		panel.add(textFieldSenha);
		
		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnLogin.setBounds(10, 310, 120, 40);
		panel.add(btnLogin);
		
		btnSair = new JButton("Sair");
		btnSair.setBackground(Color.WHITE);
		btnSair.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnSair.setBounds(160, 310, 120, 40);
		panel.add(btnSair);
		
		new ControllerLogin(this);
		setVisible(true);
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}
	
	
}
