package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.ControllerEsqueceuSenha;
import controller.ControllerLogin;

public class PanelEsqueceuSenha extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JButton btnSolicitar, btnVoltar;

	/**
	 * Create the panel.
	 */
	public PanelEsqueceuSenha() {
		setBorder(null);
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 180, 209), 10, true));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(250, 100, 300, 400);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Esqueceu a senha");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setBackground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 300, 60);
		panel.add(lblTitulo);
		
		JLabel lblEsqueceuSenha = new JLabel("Digite seu nome de usuario");
		lblEsqueceuSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsqueceuSenha.setForeground(SystemColor.text);
		lblEsqueceuSenha.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblEsqueceuSenha.setBounds(10, 153, 280, 21);
		panel.add(lblEsqueceuSenha);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		textFieldUsuario.setBounds(10, 185, 280, 30);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBackground(Color.WHITE);
		btnSolicitar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnSolicitar.setBounds(10, 301, 120, 40);
		panel.add(btnSolicitar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnVoltar.setBounds(170, 301, 120, 40);
		panel.add(btnVoltar);
		
		
		new ControllerEsqueceuSenha(this);
		setVisible(true);
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public JButton getBtnSolicitar() {
		return btnSolicitar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	
}
