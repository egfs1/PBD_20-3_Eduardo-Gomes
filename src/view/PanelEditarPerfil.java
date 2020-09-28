package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerEditarPerfil;
import model.Pessoa;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class PanelEditarPerfil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldNaturalidade;
	private JFormattedTextField formattedTextFieldFilhos, formattedTextFieldData;
	private JTextField textFieldUsuario;
	private JButton btnSalvar;
	
	private Pessoa pessoa;
	private JPasswordField textFieldSenha;
	private JPasswordField textFieldSenha2;

	public PanelEditarPerfil(Pessoa pessoa) {
		this.pessoa = pessoa;
		
		setBackground(SystemColor.activeCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setOpaque(true);
		lblPerfil.setBackground(SystemColor.textHighlight);
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblPerfil.setForeground(SystemColor.text);
		lblPerfil.setBounds(0, 0, 800, 60);
		add(lblPerfil);
		
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
		
		MaskFormatter masknumber;
		try {
			masknumber = new MaskFormatter("##");
			formattedTextFieldFilhos = new JFormattedTextField(masknumber);
			formattedTextFieldFilhos.setText(String.valueOf(pessoa.getQntFilhos()));
			masknumber.setValidCharacters("0123456789");
			formattedTextFieldFilhos.setColumns(10);
			formattedTextFieldFilhos.setBounds(20, 390, 90, 30);
			add(formattedTextFieldFilhos);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
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
		
		JLabel lblDadosUsuario = new JLabel("Dados do Usuario");
		lblDadosUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosUsuario.setForeground(Color.WHITE);
		lblDadosUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblDadosUsuario.setBounds(412, 71, 378, 29);
		add(lblDadosUsuario);
		
		try {
			masknumber = new MaskFormatter("##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblUsuario = new JLabel("Nome de Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblUsuario.setBounds(410, 120, 192, 14);
		add(lblUsuario);
		
		textFieldUsuario = new JTextField(pessoa.getUsuario());
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(410, 150, 368, 30);
		add(textFieldUsuario);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(529, 484, 120, 40);
		add(btnSalvar);
		
		JLabel lblNovaSenha = new JLabel("Alterar Senha");
		lblNovaSenha.setForeground(Color.WHITE);
		lblNovaSenha.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNovaSenha.setBounds(410, 202, 192, 14);
		add(lblNovaSenha);
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(410, 230, 368, 30);
		add(textFieldSenha);
		
		textFieldSenha2 = new JPasswordField();
		textFieldSenha2.setColumns(10);
		textFieldSenha2.setBounds(410, 304, 368, 30);
		add(textFieldSenha2);
		
		JLabel lblDigiteNovamente = new JLabel("Digite Novamente");
		lblDigiteNovamente.setForeground(Color.WHITE);
		lblDigiteNovamente.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblDigiteNovamente.setBounds(410, 276, 192, 22);
		add(lblDigiteNovamente);
		
		new ControllerEditarPerfil(this);
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

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public JTextField getTextFieldSenha2() {
		return textFieldSenha2;
	}
	
	
}
