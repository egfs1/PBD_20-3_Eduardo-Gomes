package view;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerCadastrar;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class PanelCadastro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldNaturalidade;
	private JFormattedTextField formattedTextFieldFilhos, formattedTextFieldData,formattedTextFieldHoras;
	private JTextField textFieldUsuario;
	private JRadioButton rdbtnTipoMensalista, rdbtnTipoHorista, rdbtnAdministrador, rdbtnContador,rdbtnSindicalizadoSim, rdbtnSindicalizadoNao, rdbtnComum;
	private JButton btnResetar, btnCadastrar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	
	private Long idUser;

	/**
	 * Create the panel.
	 */
	public PanelCadastro(Long idUser) {
		this.idUser = idUser;
		
		setBackground(SystemColor.activeCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastro.setBackground(SystemColor.textHighlight);
		lblCadastro.setOpaque(true);
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblCadastro.setForeground(SystemColor.text);
		lblCadastro.setBounds(0, 0, 800, 60);
		add(lblCadastro);
		
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
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(20, 150, 368, 30);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNaturalidade = new JTextField();
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
		formattedTextFieldFilhos.setColumns(10);
		formattedTextFieldFilhos.setBounds(20, 390, 90, 30);
		add(formattedTextFieldFilhos);
		
		
		try {
			MaskFormatter maskdate = new MaskFormatter("##/##/####");
			formattedTextFieldData = new JFormattedTextField(maskdate);
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
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00F5es do Funcion\u00E1rio");
		lblFuncao.setForeground(Color.WHITE);
		lblFuncao.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblFuncao.setBounds(410, 122, 226, 14);
		add(lblFuncao);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		buttonGroup_1.add(rdbtnAdministrador);
		rdbtnAdministrador.setForeground(SystemColor.text);
		rdbtnAdministrador.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnAdministrador.setBackground(SystemColor.activeCaption);
		rdbtnAdministrador.setBounds(412, 152, 141, 23);
		add(rdbtnAdministrador);
		
		rdbtnContador = new JRadioButton("Contador");
		buttonGroup_1.add(rdbtnContador);
		rdbtnContador.setForeground(SystemColor.text);
		rdbtnContador.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnContador.setBackground(SystemColor.activeCaption);
		rdbtnContador.setBounds(555, 152, 109, 23);
		add(rdbtnContador);
		
		JLabel lblTipo = new JLabel("Tipo de Contrato");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblTipo.setBounds(410, 202, 170, 14);
		add(lblTipo);
		
		rdbtnTipoHorista = new JRadioButton("Horista");
		buttonGroup_2.add(rdbtnTipoHorista);
		rdbtnTipoHorista.setForeground(Color.WHITE);
		rdbtnTipoHorista.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnTipoHorista.setBackground(SystemColor.activeCaption);
		rdbtnTipoHorista.setBounds(439, 234, 141, 23);
		add(rdbtnTipoHorista);
		
		rdbtnTipoMensalista = new JRadioButton("Mensalista");
		buttonGroup_2.add(rdbtnTipoMensalista);
		rdbtnTipoMensalista.setForeground(Color.WHITE);
		rdbtnTipoMensalista.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnTipoMensalista.setBackground(SystemColor.activeCaption);
		rdbtnTipoMensalista.setBounds(630, 234, 141, 23);
		add(rdbtnTipoMensalista);
		
		JLabel lblHoras = new JLabel("Horas Semanais");
		lblHoras.setForeground(Color.WHITE);
		lblHoras.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblHoras.setBounds(410, 280, 163, 14);
		add(lblHoras);
		
		formattedTextFieldHoras = new JFormattedTextField();
		formattedTextFieldHoras.setEnabled(false);
		formattedTextFieldHoras.setColumns(10);
		formattedTextFieldHoras.setBounds(410, 310, 90, 30);
		add(formattedTextFieldHoras);
		
		JLabel lblUsuario = new JLabel("Nome de Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblUsuario.setBounds(410, 362, 192, 14);
		add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setEnabled(false);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(410, 395, 368, 30);
		add(textFieldUsuario);
		
		btnResetar = new JButton("Resetar");
		btnResetar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnResetar.setBackground(Color.WHITE);
		btnResetar.setBounds(453, 485, 120, 40);
		add(btnResetar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(619, 485, 120, 40);
		add(btnCadastrar);
		
		rdbtnComum = new JRadioButton("Comum");
		buttonGroup_1.add(rdbtnComum);
		rdbtnComum.setForeground(Color.WHITE);
		rdbtnComum.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		rdbtnComum.setBackground(SystemColor.activeCaption);
		rdbtnComum.setBounds(666, 152, 109, 23);
		add(rdbtnComum);
		
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
		
		new ControllerCadastrar(this);
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

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public JFormattedTextField getFormattedTextFieldHoras() {
		return formattedTextFieldHoras;
	}

	public void setFormattedTextFieldHoras(JFormattedTextField formattedTextFieldHoras) {
		this.formattedTextFieldHoras = formattedTextFieldHoras;
	}

	public JRadioButton getRdbtnTipoMensalista() {
		return rdbtnTipoMensalista;
	}

	public JRadioButton getRdbtnTipoHorista() {
		return rdbtnTipoHorista;
	}

	public JRadioButton getRdbtnAdministrador() {
		return rdbtnAdministrador;
	}

	public JRadioButton getRdbtnContador() {
		return rdbtnContador;
	}

	public JButton getBtnResetar() {
		return btnResetar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JRadioButton getRdbtnSindicalizadoSim() {
		return rdbtnSindicalizadoSim;
	}

	public JRadioButton getRdbtnSindicalizadoNao() {
		return rdbtnSindicalizadoNao;
	}

	public JRadioButton getRdbtnComum() {
		return rdbtnComum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdUser() {
		return idUser;
	}
	
	
	
	
}
