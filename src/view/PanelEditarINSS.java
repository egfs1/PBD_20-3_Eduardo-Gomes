package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ControllerEditarINSS;
import model.FormatarVigencia;
import tabelasconfig.TabelaINSS;
import tabelasconfig.ValoresINSS;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelEditarINSS extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldVigencia;
	private JTextField textFieldValorMinimo1;
	private JButton btnAtualizar;
	private JTextField textFieldValorMaximo1;
	private JTextField textFieldAliquota1;
	private JTextField textFieldValorMinimo2;
	private JTextField textFieldValorMaximo2;
	private JTextField textFieldAliquota2;
	private JTextField textFieldValorMinimo3;
	private JTextField textFieldValorMaximo3;
	private JTextField textFieldAliquota3;
	private JTextField textFieldValorMinimo4;
	private JTextField textFieldValorMaximo4;
	private JTextField textFieldAliquota4;
	private JButton btnDeletar;
	
	private TabelaINSS tabela;
	

	/**
	 * Create the panel.
	 */
	public PanelEditarINSS(TabelaINSS tabela,ValoresINSS valor1, ValoresINSS valor2, ValoresINSS valor3, ValoresINSS valor4) {
		this.tabela = tabela;
		
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
		
		panel.setBounds(10, 102, 780, 443);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Vig\u00EAncia");
		lblNewLabel_1.setBounds(10, 11, 71, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldVigencia = new JTextField(FormatarVigencia.dateToFormat(tabela.getVigencia()));
		textFieldVigencia.setEnabled(false);
		textFieldVigencia.setBounds(10, 52, 110, 30);
		panel.add(textFieldVigencia);
		textFieldVigencia.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1.setBounds(10, 111, 110, 30);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		
		textFieldValorMinimo1 = new JTextField(valor1.getValorMinimo() + "");
		textFieldValorMinimo1.setBounds(10, 152, 175, 30);
		panel.add(textFieldValorMinimo1);
		textFieldValorMinimo1.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(681, 406, 89, 30);
		panel.add(btnAtualizar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 193, 110, 30);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldValorMaximo1 = new JTextField(valor1.getValorMaximo() + "");
		textFieldValorMaximo1.setColumns(10);
		textFieldValorMaximo1.setBounds(10, 238, 175, 30);
		panel.add(textFieldValorMaximo1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 279, 110, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		textFieldAliquota1 = new JTextField(valor1.getAliquota() + "");
		textFieldAliquota1.setColumns(10);
		textFieldAliquota1.setBounds(10, 324, 175, 30);
		panel.add(textFieldAliquota1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(195, 105, 2, 299);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setOpaque(true);
		lblNewLabel_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_3.setBounds(390, 105, 2, 299);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setOpaque(true);
		lblNewLabel_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_4.setBounds(585, 105, 2, 299);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(205, 111, 110, 30);
		panel.add(lblNewLabel_1_1_2);
		
		textFieldValorMinimo2 = new JTextField(valor2.getValorMinimo() + "");
		textFieldValorMinimo2.setColumns(10);
		textFieldValorMinimo2.setBounds(205, 152, 175, 30);
		panel.add(textFieldValorMinimo2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(205, 193, 110, 30);
		panel.add(lblNewLabel_1_1_1_2);
		
		textFieldValorMaximo2 = new JTextField(valor2.getValorMaximo() + "");
		textFieldValorMaximo2.setColumns(10);
		textFieldValorMaximo2.setBounds(205, 238, 175, 30);
		panel.add(textFieldValorMaximo2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(205, 279, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textFieldAliquota2 = new JTextField(valor2.getAliquota() + "");
		textFieldAliquota2.setColumns(10);
		textFieldAliquota2.setBounds(205, 324, 175, 30);
		panel.add(textFieldAliquota2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(400, 111, 110, 30);
		panel.add(lblNewLabel_1_1_3);
		
		textFieldValorMinimo3 = new JTextField(valor3.getValorMinimo() + "");
		textFieldValorMinimo3.setColumns(10);
		textFieldValorMinimo3.setBounds(400, 152, 175, 30);
		panel.add(textFieldValorMinimo3);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_3.setBounds(400, 193, 110, 30);
		panel.add(lblNewLabel_1_1_1_3);
		
		textFieldValorMaximo3 = new JTextField(valor3.getValorMaximo() + "");
		textFieldValorMaximo3.setColumns(10);
		textFieldValorMaximo3.setBounds(400, 238, 175, 30);
		panel.add(textFieldValorMaximo3);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2.setBounds(400, 279, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		textFieldAliquota3 = new JTextField(valor3.getAliquota() + "");
		textFieldAliquota3.setColumns(10);
		textFieldAliquota3.setBounds(400, 324, 175, 30);
		panel.add(textFieldAliquota3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Valor M\u00EDnimo");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_4.setBounds(595, 111, 110, 30);
		panel.add(lblNewLabel_1_1_4);
		
		textFieldValorMinimo4 = new JTextField(valor4.getValorMinimo() + "");
		textFieldValorMinimo4.setColumns(10);
		textFieldValorMinimo4.setBounds(595, 152, 175, 30);
		panel.add(textFieldValorMinimo4);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Valor M\u00E1ximo");
		lblNewLabel_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_4.setBounds(595, 193, 110, 30);
		panel.add(lblNewLabel_1_1_1_4);
		
		textFieldValorMaximo4 = new JTextField(valor4.getValorMaximo() + "");
		textFieldValorMaximo4.setColumns(10);
		textFieldValorMaximo4.setBounds(595, 238, 175, 30);
		panel.add(textFieldValorMaximo4);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Al\u00EDquota");
		lblNewLabel_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_3.setBounds(595, 279, 110, 30);
		panel.add(lblNewLabel_1_1_1_1_3);
		
		textFieldAliquota4 = new JTextField(valor4.getAliquota() + "");
		textFieldAliquota4.setColumns(10);
		textFieldAliquota4.setBounds(595, 324, 175, 30);
		panel.add(textFieldAliquota4);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(582, 406, 89, 30);
		panel.add(btnDeletar);
		
		new ControllerEditarINSS(this);
	}


	public JTextField getTextFieldVigencia() {
		return textFieldVigencia;
	}


	public JTextField getTextFieldValorMinimo1() {
		return textFieldValorMinimo1;
	}


	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}


	public JTextField getTextFieldValorMaximo1() {
		return textFieldValorMaximo1;
	}


	public JTextField getTextFieldAliquota1() {
		return textFieldAliquota1;
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


	public JTextField getTextFieldValorMinimo3() {
		return textFieldValorMinimo3;
	}


	public JTextField getTextFieldValorMaximo3() {
		return textFieldValorMaximo3;
	}


	public JTextField getTextFieldAliquota3() {
		return textFieldAliquota3;
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


	public JButton getBtnDeletar() {
		return btnDeletar;
	}


	public TabelaINSS getTabela() {
		return tabela;
	}

	
	



	
	
}
