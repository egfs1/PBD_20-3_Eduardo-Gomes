package view;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerEditar;
import model.Pessoa;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class PanelEditar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldNaturalidade;
	private JFormattedTextField formattedTextFieldFilhos, formattedTextFieldData,formattedTextFieldHoras;
	private JTextField textFieldUsuario;
	private JRadioButton rdbtnTipoMensalista, rdbtnTipoHorista,rdbtnSindicalizadoSim, rdbtnSindicalizadoNao;
	private JButton btnDeletar, btnSalvar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	
	private Pessoa pessoa;
	private Long idUser;
	/**
	 * Create the panel.
	 */
	public PanelEditar(Pessoa pessoa, Long idUser) {
		this.idUser = idUser;
		this.pessoa = pessoa;
		
		setBackground(SystemColor.activeCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblEditar = new JLabel("Editar Funcion\u00E1rio");
		lblEditar.setBackground(SystemColor.textHighlight);
		lblEditar.setOpaque(true);
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblEditar.setForeground(SystemColor.text);
		lblEditar.setBounds(0, 0, 800, 60);
		add(lblEditar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(SystemColor.text);
		lblNome.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNome.setBounds(20, 120, 118, 14);
		add(lblNome);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade");
		lblNaturalidade.setForeground(Color.WHITE);
		lblNaturalidade.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNaturalidade.setBounds(20, 200, 118, 14);
		add(lblNaturalidade);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(SystemColor.desktop);
		lblNewLabel_1.setBounds(398, 71, 2, 486);
		add(lblNewLabel_1);
		
		JLabel lblPessoal = new JLabel("Dados Pessoais");
		lblPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPessoal.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblPessoal.setForeground(SystemColor.text);
		lblPessoal.setBounds(10, 71, 378, 29);
		add(lblPessoal);
		
		textFieldNome = new JTextField(pessoa.getNome());
		textFieldNome.setBounds(20, 150, 368, 30);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNaturalidade = new JTextField(pessoa.getNaturalidade());
		textFieldNaturalidade.setBounds(20, 230, 368, 30);
		add(textFieldNaturalidade);
		textFieldNaturalidade.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setForeground(Color.WHITE);
		lblDataNascimento.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblDataNascimento.setBounds(20, 280, 163, 14);
		add(lblDataNascimento);
		
		JLabel lblQntFilhos = new JLabel("Quantidade de Filhos");
		lblQntFilhos.setForeground(Color.WHITE);
		lblQntFilhos.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblQntFilhos.setBounds(20, 360, 192, 14);
		add(lblQntFilhos);
		
		formattedTextFieldFilhos = new JFormattedTextField();
		formattedTextFieldFilhos.setText(String.valueOf(pessoa.getQntFilhos()));
		formattedTextFieldFilhos.setColumns(10);
		formattedTextFieldFilhos.setBounds(20, 390, 90, 30);
		add(formattedTextFieldFilhos);
		
		
		try {
			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
			String dataString = DateFor.format(pessoa.getDataNascimento());
			
			MaskFormatter maskdate = new MaskFormatter("##/##/####");
			formattedTextFieldData = new JFormattedTextField(maskdate);
			formattedTextFieldData.setText(dataString);
			formattedTextFieldData.setBounds(20, 310, 90, 29);
			maskdate.setValidCharacters("0123456789");
			add(formattedTextFieldData);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblFuncionario = new JLabel("Dados do Funcion\u00E1rio");
		lblFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncionario.setForeground(Color.WHITE);
		lblFuncionario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblFuncionario.setBounds(412, 71, 378, 29);
		add(lblFuncionario);
		
		JLabel lblTipo = new JLabel("Tipo de Contrato");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblTipo.setBounds(410, 120, 170, 14);
		add(lblTipo);
		
		rdbtnTipoHorista = new JRadioButton("Horista");
		buttonGroup_2.add(rdbtnTipoHorista);
		rdbtnTipoHorista.setForeground(Color.WHITE);
		rdbtnTipoHorista.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnTipoHorista.setBackground(SystemColor.activeCaption);
		rdbtnTipoHorista.setBounds(439, 152, 141, 23);
		add(rdbtnTipoHorista);
		
		rdbtnTipoMensalista = new JRadioButton("Mensalista");
		buttonGroup_2.add(rdbtnTipoMensalista);
		rdbtnTipoMensalista.setForeground(Color.WHITE);
		rdbtnTipoMensalista.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnTipoMensalista.setBackground(SystemColor.activeCaption);
		rdbtnTipoMensalista.setBounds(618, 152, 141, 23);
		add(rdbtnTipoMensalista);
		
		JLabel lblHoras = new JLabel("Horas Semanais");
		lblHoras.setForeground(Color.WHITE);
		lblHoras.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblHoras.setBounds(410, 200, 163, 14);
		add(lblHoras);
		
		formattedTextFieldHoras = new JFormattedTextField();
		formattedTextFieldHoras.setText(String.valueOf(pessoa.getHorasSemanaisContratadas()));
		formattedTextFieldHoras.setColumns(10);
		formattedTextFieldHoras.setBounds(410, 230, 90, 30);
		add(formattedTextFieldHoras);
		if (pessoa.getTipo().equalsIgnoreCase("Horista"))rdbtnTipoHorista.setSelected(true);
		else {
			rdbtnTipoMensalista.setSelected(true);
			formattedTextFieldHoras.setEnabled(false);
		}
		
		JLabel lblUsuario = new JLabel("Nome de Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblUsuario.setBounds(410, 280, 192, 14);
		add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(410, 309, 368, 30);
		add(textFieldUsuario);
		
		if (pessoa.getUsuario()!=null)textFieldUsuario.setText(pessoa.getUsuario());
		else textFieldUsuario.setEnabled(false);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.setBounds(449, 485, 120, 40);
		add(btnDeletar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(618, 485, 120, 40);
		add(btnSalvar);
		
		JLabel lblSindicalizado = new JLabel("Sindicalizado");
		lblSindicalizado.setForeground(Color.WHITE);
		lblSindicalizado.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblSindicalizado.setBounds(20, 448, 192, 14);
		add(lblSindicalizado);
		
		rdbtnSindicalizadoSim = new JRadioButton("Sim");
		buttonGroup.add(rdbtnSindicalizadoSim);
		rdbtnSindicalizadoSim.setForeground(Color.WHITE);
		rdbtnSindicalizadoSim.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnSindicalizadoSim.setBackground(SystemColor.activeCaption);
		rdbtnSindicalizadoSim.setBounds(42, 485, 141, 23);
		add(rdbtnSindicalizadoSim);
		
		rdbtnSindicalizadoNao = new JRadioButton("N\u00E3o");
		buttonGroup.add(rdbtnSindicalizadoNao);
		rdbtnSindicalizadoNao.setForeground(Color.WHITE);
		rdbtnSindicalizadoNao.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnSindicalizadoNao.setBackground(SystemColor.activeCaption);
		rdbtnSindicalizadoNao.setBounds(251, 485, 141, 23);
		add(rdbtnSindicalizadoNao);
		
		if (pessoa.isSindicalizado())rdbtnSindicalizadoSim.setSelected(true);
		else rdbtnSindicalizadoNao.setSelected(true);
		
		new ControllerEditar(this);
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldNaturalidade() {
		return textFieldNaturalidade;
	}

	public JFormattedTextField getFormattedTextFieldFilhos() {
		return formattedTextFieldFilhos;
	}

	public JFormattedTextField getFormattedTextFieldData() {
		return formattedTextFieldData;
	}

	public JFormattedTextField getFormattedTextFieldHoras() {
		return formattedTextFieldHoras;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public JRadioButton getRdbtnTipoMensalista() {
		return rdbtnTipoMensalista;
	}

	public JRadioButton getRdbtnTipoHorista() {
		return rdbtnTipoHorista;
	}

	public JRadioButton getRdbtnSindicalizadoSim() {
		return rdbtnSindicalizadoSim;
	}

	public JRadioButton getRdbtnSindicalizadoNao() {
		return rdbtnSindicalizadoNao;
	}


	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Long getIdUser() {
		return idUser;
	}
	
	
	
	
}
