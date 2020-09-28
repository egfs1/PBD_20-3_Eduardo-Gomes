package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ControllerCadastrarIRRF;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCadastrarIRRF extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldVigencia;
	private JTextField textFieldValorMinimo1;
	private JButton btnSalvar;
	private JTextField textFieldValorMaximo1;
	private JTextField textFieldAliquota1;
	private JTextField textFieldValorDeduzir1;
	private JTextField textFieldValorMinimo2;
	private JTextField textFieldValorMaximo2;
	private JTextField textFieldAliquota2;
	private JTextField textFieldValorDeduzir2;
	private JTextField textFieldValorMinimo3;
	private JTextField textFieldValorMaximo3;
	private JTextField textFieldAliquota3;
	private JTextField textFieldValorDeduzir3;
	private JTextField textFieldValorMinimo4;
	private JTextField textFieldValorMaximo4;
	private JTextField textFieldAliquota4;
	private JTextField textFieldValorDeduzir4;
	private JTextField textFieldValorMinimo5;
	private JTextField textFieldValorMaximo5;
	private JTextField textFieldAliquota5;
	private JTextField textFieldValorDeduzir5;
	

	/**
	 * Create the panel.
	 */
	public PanelCadastrarIRRF() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Vig\u00EAncia do INSS");
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
		
		panel.setBounds(10, 71, 780, 486);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Vig\u00EAncia");
		lblNewLabel_1.setBounds(10, 11, 71, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldVigencia = new JTextField();
		textFieldVigencia.setBounds(10, 52, 110, 30);
		panel.add(textFieldVigencia);
		textFieldVigencia.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1.setBounds(10, 93, 110, 30);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldValorMinimo1 = new JTextField();
		textFieldValorMinimo1.setBounds(10, 134, 136, 30);
		panel.add(textFieldValorMinimo1);
		textFieldValorMinimo1.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(648, 445, 89, 30);
		panel.add(btnSalvar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 175, 110, 30);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldValorMaximo1 = new JTextField();
		textFieldValorMaximo1.setColumns(10);
		textFieldValorMaximo1.setBounds(10, 220, 136, 30);
		panel.add(textFieldValorMaximo1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 261, 110, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		textFieldAliquota1 = new JTextField();
		textFieldAliquota1.setColumns(10);
		textFieldAliquota1.setBounds(10, 306, 136, 30);
		panel.add(textFieldAliquota1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(156, 105, 2, 334);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("Valor \u00E0 Deduzir");
		lblNewLabel_1_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_4.setBounds(10, 347, 136, 30);
		panel.add(lblNewLabel_1_1_1_1_4);
		
		textFieldValorDeduzir1 = new JTextField();
		textFieldValorDeduzir1.setColumns(10);
		textFieldValorDeduzir1.setBounds(10, 392, 136, 30);
		panel.add(textFieldValorDeduzir1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("New label");
		lblNewLabel_1_2_1.setOpaque(true);
		lblNewLabel_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1.setBounds(312, 105, 2, 334);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("New label");
		lblNewLabel_1_2_2.setOpaque(true);
		lblNewLabel_1_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2.setBounds(468, 105, 2, 334);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("New label");
		lblNewLabel_1_2_3.setOpaque(true);
		lblNewLabel_1_2_3.setBackground(Color.BLACK);
		lblNewLabel_1_2_3.setBounds(624, 105, 2, 334);
		panel.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(168, 93, 110, 30);
		panel.add(lblNewLabel_1_1_2);
		
		textFieldValorMinimo2 = new JTextField();
		textFieldValorMinimo2.setColumns(10);
		textFieldValorMinimo2.setBounds(168, 134, 136, 30);
		panel.add(textFieldValorMinimo2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(168, 175, 110, 30);
		panel.add(lblNewLabel_1_1_1_2);
		
		textFieldValorMaximo2 = new JTextField();
		textFieldValorMaximo2.setColumns(10);
		textFieldValorMaximo2.setBounds(168, 220, 136, 30);
		panel.add(textFieldValorMaximo2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(168, 261, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textFieldAliquota2 = new JTextField();
		textFieldAliquota2.setColumns(10);
		textFieldAliquota2.setBounds(168, 306, 136, 30);
		panel.add(textFieldAliquota2);
		
		textFieldValorDeduzir2 = new JTextField();
		textFieldValorDeduzir2.setColumns(10);
		textFieldValorDeduzir2.setBounds(168, 392, 136, 30);
		panel.add(textFieldValorDeduzir2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(324, 93, 110, 30);
		panel.add(lblNewLabel_1_1_3);
		
		textFieldValorMinimo3 = new JTextField();
		textFieldValorMinimo3.setColumns(10);
		textFieldValorMinimo3.setBounds(324, 134, 136, 30);
		panel.add(textFieldValorMinimo3);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_3.setBounds(324, 175, 110, 30);
		panel.add(lblNewLabel_1_1_1_3);
		
		textFieldValorMaximo3 = new JTextField();
		textFieldValorMaximo3.setColumns(10);
		textFieldValorMaximo3.setBounds(324, 220, 136, 30);
		panel.add(textFieldValorMaximo3);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2.setBounds(324, 261, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		textFieldAliquota3 = new JTextField();
		textFieldAliquota3.setColumns(10);
		textFieldAliquota3.setBounds(324, 306, 136, 30);
		panel.add(textFieldAliquota3);
		
		textFieldValorDeduzir3 = new JTextField();
		textFieldValorDeduzir3.setColumns(10);
		textFieldValorDeduzir3.setBounds(324, 392, 136, 30);
		panel.add(textFieldValorDeduzir3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_4.setBounds(478, 93, 110, 30);
		panel.add(lblNewLabel_1_1_4);
		
		textFieldValorMinimo4 = new JTextField();
		textFieldValorMinimo4.setColumns(10);
		textFieldValorMinimo4.setBounds(478, 134, 136, 30);
		panel.add(textFieldValorMinimo4);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_4.setBounds(478, 175, 110, 30);
		panel.add(lblNewLabel_1_1_1_4);
		
		textFieldValorMaximo4 = new JTextField();
		textFieldValorMaximo4.setColumns(10);
		textFieldValorMaximo4.setBounds(478, 220, 136, 30);
		panel.add(textFieldValorMaximo4);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_3.setBounds(478, 261, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_3);
		
		textFieldAliquota4 = new JTextField();
		textFieldAliquota4.setColumns(10);
		textFieldAliquota4.setBounds(478, 306, 136, 30);
		panel.add(textFieldAliquota4);
		
		textFieldValorDeduzir4 = new JTextField();
		textFieldValorDeduzir4.setColumns(10);
		textFieldValorDeduzir4.setBounds(478, 392, 136, 30);
		panel.add(textFieldValorDeduzir4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_5.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_5.setBounds(634, 93, 110, 30);
		panel.add(lblNewLabel_1_1_5);
		
		textFieldValorMinimo5 = new JTextField();
		textFieldValorMinimo5.setColumns(10);
		textFieldValorMinimo5.setBounds(634, 134, 136, 30);
		panel.add(textFieldValorMinimo5);
		
		JLabel lblNewLabel_1_1_1_5 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_5.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_5.setBounds(634, 175, 110, 30);
		panel.add(lblNewLabel_1_1_1_5);
		
		textFieldValorMaximo5 = new JTextField();
		textFieldValorMaximo5.setColumns(10);
		textFieldValorMaximo5.setBounds(634, 220, 136, 30);
		panel.add(textFieldValorMaximo5);
		
		JLabel lblNewLabel_1_1_1_1_5 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_5.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_5.setBounds(634, 261, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_5);
		
		textFieldAliquota5 = new JTextField();
		textFieldAliquota5.setColumns(10);
		textFieldAliquota5.setBounds(634, 306, 136, 30);
		panel.add(textFieldAliquota5);
		
		textFieldValorDeduzir5 = new JTextField();
		textFieldValorDeduzir5.setColumns(10);
		textFieldValorDeduzir5.setBounds(634, 392, 136, 30);
		panel.add(textFieldValorDeduzir5);
		
		JLabel lblNewLabel_1_1_1_1_4_1 = new JLabel("Valor \u00E0 Deduzir");
		lblNewLabel_1_1_1_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_4_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_4_1.setBounds(166, 347, 136, 30);
		panel.add(lblNewLabel_1_1_1_1_4_1);
		
		JLabel lblNewLabel_1_1_1_1_4_2 = new JLabel("Valor \u00E0 Deduzir");
		lblNewLabel_1_1_1_1_4_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_4_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_4_2.setBounds(322, 347, 136, 30);
		panel.add(lblNewLabel_1_1_1_1_4_2);
		
		JLabel lblNewLabel_1_1_1_1_4_3 = new JLabel("Valor \u00E0 Deduzir");
		lblNewLabel_1_1_1_1_4_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_4_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_4_3.setBounds(478, 347, 136, 30);
		panel.add(lblNewLabel_1_1_1_1_4_3);
		
		JLabel lblNewLabel_1_1_1_1_4_4 = new JLabel("Valor \u00E0 Deduzir");
		lblNewLabel_1_1_1_1_4_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_4_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_4_4.setBounds(634, 347, 136, 30);
		panel.add(lblNewLabel_1_1_1_1_4_4);
		
		new ControllerCadastrarIRRF(this);
	}


	public JTextField getTextFieldVigencia() {
		return textFieldVigencia;
	}


	public JTextField getTextFieldValorMinimo1() {
		return textFieldValorMinimo1;
	}


	public JButton getBtnSalvar() {
		return btnSalvar;
	}


	public JTextField getTextFieldValorMaximo1() {
		return textFieldValorMaximo1;
	}


	public JTextField getTextFieldAliquota1() {
		return textFieldAliquota1;
	}


	public JTextField getTextFieldValorDeduzir1() {
		return textFieldValorDeduzir1;
	}


	public JTextField getTextFieldValorMinimo2() {
		return textFieldValorMinimo2;
	}


	public JTextField getTextFieldValorMaximo2() {
		return textFieldValorMaximo2;
	}


	public JTextField getTextFieldAliquota2() {
		return textFieldAliquota2;
	}


	public JTextField getTextFieldValorDeduzir2() {
		return textFieldValorDeduzir2;
	}


	public JTextField getTextFieldValorMinimo3() {
		return textFieldValorMinimo3;
	}


	public JTextField getTextFieldValorMaximo3() {
		return textFieldValorMaximo3;
	}


	public JTextField getTextFieldAliquota3() {
		return textFieldAliquota3;
	}


	public JTextField getTextFieldValorDeduzir3() {
		return textFieldValorDeduzir3;
	}


	public JTextField getTextFieldValorMinimo4() {
		return textFieldValorMinimo4;
	}


	public JTextField getTextFieldValorMaximo4() {
		return textFieldValorMaximo4;
	}


	public JTextField getTextFieldAliquota4() {
		return textFieldAliquota4;
	}


	public JTextField getTextFieldValorDeduzir4() {
		return textFieldValorDeduzir4;
	}


	public JTextField getTextFieldValorMinimo5() {
		return textFieldValorMinimo5;
	}


	public JTextField getTextFieldValorMaximo5() {
		return textFieldValorMaximo5;
	}


	public JTextField getTextFieldAliquota5() {
		return textFieldAliquota5;
	}


	public JTextField getTextFieldValorDeduzir5() {
		return textFieldValorDeduzir5;
	}

	

	
	



	
	
}
