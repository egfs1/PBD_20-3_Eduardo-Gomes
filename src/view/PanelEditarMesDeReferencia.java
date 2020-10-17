package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import controller.ControllerEditarMesDeReferencia;
import model.FormatarVigencia;
import tabelasconfig.MesDeReferencia;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelEditarMesDeReferencia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnDeletar;
	private MesDeReferencia mes;
	private Long UserId;

	public PanelEditarMesDeReferencia(MesDeReferencia mes, Long UserId) {
		this.UserId = UserId;
		this.mes = mes;
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
		
		textField = new JTextField(FormatarVigencia.dateToFormat(mes.getVigencia()));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(100, 73, 110, 30);
		panel.add(textField);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(110, 146, 89, 30);
		panel.add(btnDeletar);
		
		new ControllerEditarMesDeReferencia(this);
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnSalvar() {
		return btnDeletar;
	}

	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public MesDeReferencia getMes() {
		return mes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getUserId() {
		return UserId;
	}
	
	
}
