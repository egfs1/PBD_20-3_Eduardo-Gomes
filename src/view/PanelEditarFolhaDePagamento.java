package view;

import java.awt.SystemColor;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import controller.ControllerEditarFolhaDePagamento;
import folhadepagamento.FolhaDePagamento;
import model.Pessoa;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelEditarFolhaDePagamento extends JPanel {


	private static final long serialVersionUID = 1L;
	
	private Long UserId;
	private JTextField textFieldVigencia;
	private JTextField textFieldUsuario;
	private JTextField textFieldAuxilioAlimentacao;
	private JTextField textFieldHoraExtra;
	private JTextField textFieldAcrescimoValor;
	private JTextField textFieldAcrescimoDescricao;
	private JTextField textFieldContribuicaoSindical;
	private JTextField textFieldFaltas;
	private JTextField textFieldDescontoValor;
	private JTextField textFieldDescontoDescricao;

	private JButton btnSalvar;

	private JButton btnDeletar;

	private JButton btnBuscar;
	
	FolhaDePagamento folha;
	Pessoa Usuario;

	public PanelEditarFolhaDePagamento(Long UserId) {
		
	this.UserId = UserId;
		
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Gerar Folha de Pagamento");
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
		panel.setBounds(10, 71, 780, 486);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Vig\u00EAncia");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 11, 71, 30);
		panel.add(lblNewLabel_1);
		
		textFieldVigencia = new JTextField();
		textFieldVigencia.setColumns(10);
		textFieldVigencia.setBounds(77, 13, 110, 30);
		panel.add(textFieldVigencia);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID/Usuario");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(236, 11, 110, 30);
		panel.add(lblNewLabel_1_1);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(317, 13, 110, 30);
		panel.add(textFieldUsuario);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(681, 445, 89, 30);
		panel.add(btnSalvar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor Auxilio Alimenta\u00E7\u00E3o");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 175, 291, 30);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldAuxilioAlimentacao = new JTextField();
		textFieldAuxilioAlimentacao.setEnabled(false);
		textFieldAuxilioAlimentacao.setColumns(10);
		textFieldAuxilioAlimentacao.setBounds(10, 216, 369, 30);
		panel.add(textFieldAuxilioAlimentacao);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Horas Extras");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 93, 133, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		textFieldHoraExtra = new JTextField();
		textFieldHoraExtra.setEnabled(false);
		textFieldHoraExtra.setColumns(10);
		textFieldHoraExtra.setBounds(10, 134, 369, 30);
		panel.add(textFieldHoraExtra);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(389, 54, 2, 421);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel = new JLabel("Proventos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(0, 52, 389, 43);
		panel.add(lblNewLabel);
		
		JLabel lblDescontos = new JLabel("Dedu\u00E7\u00F5es");
		lblDescontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescontos.setForeground(Color.WHITE);
		lblDescontos.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));
		lblDescontos.setBounds(391, 54, 389, 43);
		panel.add(lblDescontos);
		
		JLabel lblAcrscimos = new JLabel("Outros Acr\u00E9scimos");
		lblAcrscimos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcrscimos.setForeground(Color.WHITE);
		lblAcrscimos.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblAcrscimos.setBounds(0, 257, 389, 43);
		panel.add(lblAcrscimos);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Valor");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 311, 54, 30);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textFieldAcrescimoValor = new JTextField();
		textFieldAcrescimoValor.setEnabled(false);
		textFieldAcrescimoValor.setColumns(10);
		textFieldAcrescimoValor.setBounds(95, 313, 284, 30);
		panel.add(textFieldAcrescimoValor);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 366, 89, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		textFieldAcrescimoDescricao = new JTextField();
		textFieldAcrescimoDescricao.setEnabled(false);
		textFieldAcrescimoDescricao.setColumns(10);
		textFieldAcrescimoDescricao.setBounds(95, 373, 284, 61);
		panel.add(textFieldAcrescimoDescricao);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Contribui\u00E7\u00E3o Sindical (%)");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2.setBounds(401, 93, 369, 30);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		textFieldContribuicaoSindical = new JTextField();
		textFieldContribuicaoSindical.setEnabled(false);
		textFieldContribuicaoSindical.setText("3.33");
		textFieldContribuicaoSindical.setColumns(10);
		textFieldContribuicaoSindical.setBounds(401, 134, 369, 30);
		panel.add(textFieldContribuicaoSindical);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("N\u00FAmero de Faltas");
		lblNewLabel_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_3.setBounds(401, 175, 133, 30);
		panel.add(lblNewLabel_1_1_1_1_3);
		
		textFieldFaltas = new JTextField();
		textFieldFaltas.setEnabled(false);
		textFieldFaltas.setColumns(10);
		textFieldFaltas.setBounds(401, 216, 369, 30);
		panel.add(textFieldFaltas);
		
		JLabel lblOutrosDescontos = new JLabel("Outros Descontos");
		lblOutrosDescontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutrosDescontos.setForeground(Color.WHITE);
		lblOutrosDescontos.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblOutrosDescontos.setBounds(391, 257, 389, 43);
		panel.add(lblOutrosDescontos);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Valor");
		lblNewLabel_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2.setBounds(401, 311, 54, 30);
		panel.add(lblNewLabel_1_1_1_1_1_2);
		
		textFieldDescontoValor = new JTextField();
		textFieldDescontoValor.setEnabled(false);
		textFieldDescontoValor.setColumns(10);
		textFieldDescontoValor.setBounds(486, 313, 284, 30);
		panel.add(textFieldDescontoValor);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(401, 366, 89, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		textFieldDescontoDescricao = new JTextField();
		textFieldDescontoDescricao.setEnabled(false);
		textFieldDescontoDescricao.setColumns(10);
		textFieldDescontoDescricao.setBounds(486, 373, 284, 61);
		panel.add(textFieldDescontoDescricao);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(576, 445, 89, 30);
		panel.add(btnDeletar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(459, 13, 89, 30);
		panel.add(btnBuscar);
		
		new ControllerEditarFolhaDePagamento(this);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getUserId() {
		return UserId;
	}

	public JTextField getTextFieldVigencia() {
		return textFieldVigencia;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public JTextField getTextFieldAuxilioAlimentacao() {
		return textFieldAuxilioAlimentacao;
	}

	public JTextField getTextFieldHoraExtra() {
		return textFieldHoraExtra;
	}

	public JTextField getTextFieldAcrescimoValor() {
		return textFieldAcrescimoValor;
	}

	public JTextField getTextFieldAcrescimoDescricao() {
		return textFieldAcrescimoDescricao;
	}

	public JTextField getTextFieldContribuicaoSindical() {
		return textFieldContribuicaoSindical;
	}

	public JTextField getTextFieldFaltas() {
		return textFieldFaltas;
	}

	public JTextField getTextFieldDescontoValor() {
		return textFieldDescontoValor;
	}

	public JTextField getTextFieldDescontoDescricao() {
		return textFieldDescontoDescricao;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public FolhaDePagamento getFolha() {
		return folha;
	}

	public void setFolha(FolhaDePagamento folha) {
		this.folha = folha;
	}

	public Pessoa getUsuario() {
		return Usuario;
	}

	public void setUsuario(Pessoa usuario) {
		Usuario = usuario;
	}
	
	
	
}
