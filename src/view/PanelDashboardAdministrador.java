package view;

import javax.swing.JPanel;

import controller.ControllerDashboardAdministrador;

import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;

public class PanelDashboardAdministrador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuItem mntmDeslogar, mntmSair, mntmCadastrarFuncionario, mntmEditar, mntmResetarSenha, mntmMeuPerfil, mntmTabelaPessoas,mntmTabelaSalarioMinimo;
	private JPanel panel;
	private Long IDPessoa;

	private JMenuItem mntmTabelaSalarioFamilia;

	private JMenuItem mntmTabelaINSS;

	private JMenuItem mntmTabelaIRRF;

	private JMenuItem mntmCadVigenciaSalarioMinimo;

	private JMenuItem mntmCadVigenciaSalarioFamilia;

	private JMenuItem mntmCadVigenciaINSS;

	private JMenuItem mntmCadVigenciaIRRF;

	private JMenuItem mntmEditarSalarioMinimo;

	private JMenuItem mntmEditarSalarioFamilia;

	private JMenuItem mntmEditarINSS;

	private JMenuItem mntmEditarIRRF;

	private JMenuItem mntmTabelaMesDeReferencia;

	private JMenuItem mntmEditMesDeReferencia;

	private JMenuItem mntmCadMesDeReferencia;

	
	/**
	 * Create the panel.
	 */
	public PanelDashboardAdministrador(Long id) {
		this.IDPessoa = id;
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 800, 32);
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setLayout(null);
		add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnCadastro.setBounds(0,0,100, 32);
		menuBar.add(mnCadastro);
		
		mntmCadastrarFuncionario = new JMenuItem("Funcionario");
		mnCadastro.add(mntmCadastrarFuncionario);
		
		mntmCadVigenciaSalarioMinimo = new JMenuItem("Vig\u00EAncia Salario Minimo");
		mnCadastro.add(mntmCadVigenciaSalarioMinimo);
		
		mntmCadVigenciaSalarioFamilia = new JMenuItem("Vig\u00EAncia Salario Familia");
		mnCadastro.add(mntmCadVigenciaSalarioFamilia);
		
		mntmCadVigenciaINSS = new JMenuItem("Vig\u00EAncia INSS");
		mnCadastro.add(mntmCadVigenciaINSS);
		
		mntmCadVigenciaIRRF = new JMenuItem("Vig\u00EAncia IRRF");
		mnCadastro.add(mntmCadVigenciaIRRF);
		
		mntmCadMesDeReferencia = new JMenuItem("M\u00EAs de Referencia");
		mnCadastro.add(mntmCadMesDeReferencia);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnEditar.setBounds(100,0,100, 32);
		menuBar.add(mnEditar);
		
		mntmEditar = new JMenuItem("Funcionario");
		mnEditar.add(mntmEditar);
		
		mntmEditarSalarioMinimo = new JMenuItem("Vig\u00EAncia Salario Minimo");
		mnEditar.add(mntmEditarSalarioMinimo);
		
		mntmEditarSalarioFamilia = new JMenuItem("Vig\u00EAncia Salario Familia");
		mnEditar.add(mntmEditarSalarioFamilia);
		
		mntmEditarINSS = new JMenuItem("Vig\u00EAncia INSS");
		mnEditar.add(mntmEditarINSS);
		
		mntmEditarIRRF = new JMenuItem("Vig\u00EAncia IRRF");
		mnEditar.add(mntmEditarIRRF);
		
		mntmEditMesDeReferencia = new JMenuItem("M\u00EAs de Referencia");
		mnEditar.add(mntmEditMesDeReferencia);
		
		mntmMeuPerfil = new JMenuItem("Meu Perfil");
		mnEditar.add(mntmMeuPerfil);
		
		mntmResetarSenha = new JMenuItem("Resetar Senha");
		mnEditar.add(mntmResetarSenha);
		
		JMenu mnTabelas = new JMenu("Tabelas");
		mnTabelas.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnTabelas.setBounds(200,0,100, 32);
		menuBar.add(mnTabelas);
		
		mntmTabelaPessoas = new JMenuItem("Tabela de Funcionarios");
		mnTabelas.add(mntmTabelaPessoas);
		
		mntmTabelaSalarioMinimo = new JMenuItem("Tabela Salario M\u00EDnimo");
		mnTabelas.add(mntmTabelaSalarioMinimo);
		
		mntmTabelaSalarioFamilia = new JMenuItem("Tabela Salario Fam\u00EDlia");
		mnTabelas.add(mntmTabelaSalarioFamilia);
		
		mntmTabelaINSS = new JMenuItem("Tabela INSS");
		mnTabelas.add(mntmTabelaINSS);
		
		mntmTabelaIRRF = new JMenuItem("Tabela IRRF");
		mnTabelas.add(mntmTabelaIRRF);
		
		mntmTabelaMesDeReferencia = new JMenuItem("M\u00EAs de Referencia");
		mnTabelas.add(mntmTabelaMesDeReferencia);
		
		JMenu mnOpcoes = new JMenu("Op\u00E7\u00F5es");
		mnOpcoes.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnOpcoes.setBounds(300,0,100, 32);
		menuBar.add(mnOpcoes);
		
		mntmDeslogar = new JMenuItem("Deslogar");
		mntmDeslogar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mntmDeslogar.setSize(100, 32);
		mnOpcoes.add(mntmDeslogar);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setLayout(null);
		mntmSair.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mntmSair.setSize(100, 32);
		mnOpcoes.add(mntmSair);
		
		new ControllerDashboardAdministrador(this);
	}

	public JMenuItem getMntmDeslogar() {
		return mntmDeslogar;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

	public JMenuItem getMntmCadastrarFuncionario() {
		return mntmCadastrarFuncionario;
	}
	

	public JMenuItem getMntmEditar() {
		return mntmEditar;
	}

	public JMenuItem getMntmResetarSenha() {
		return mntmResetarSenha;
	}

	public Long getIDPessoa() {
		return IDPessoa;
	}

	public JMenuItem getMntmMeuPerfil() {
		return mntmMeuPerfil;
	}

	public JMenuItem getMntmTabelaPessoas() {
		return mntmTabelaPessoas;
	}

	public JMenuItem getMntmTabelaSalarioMinimo() {
		return mntmTabelaSalarioMinimo;
	}

	public JMenuItem getMntmTabelaSalarioFamilia() {
		return mntmTabelaSalarioFamilia;
	}

	public JMenuItem getMntmTabelaINSS() {
		return mntmTabelaINSS;
	}

	public JMenuItem getMntmTabelaIRRF() {
		return mntmTabelaIRRF;
	}

	public JMenuItem getMntmCadVigenciaSalarioMinimo() {
		return mntmCadVigenciaSalarioMinimo;
	}

	public JMenuItem getMntmCadVigenciaSalarioFamilia() {
		return mntmCadVigenciaSalarioFamilia;
	}

	public JMenuItem getMntmCadVigenciaINSS() {
		return mntmCadVigenciaINSS;
	}

	public JMenuItem getMntmCadVigenciaIRRF() {
		return mntmCadVigenciaIRRF;
	}

	public JMenuItem getMntmEditarSalarioMinimo() {
		return mntmEditarSalarioMinimo;
	}

	public JMenuItem getMntmEditarSalarioFamilia() {
		return mntmEditarSalarioFamilia;
	}

	public JMenuItem getMntmEditarINSS() {
		return mntmEditarINSS;
	}

	public JMenuItem getMntmEditarIRRF() {
		return mntmEditarIRRF;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JMenuItem getMntmTabelaMesDeReferencia() {
		return mntmTabelaMesDeReferencia;
	}

	public JMenuItem getMntmEditMesDeReferencia() {
		return mntmEditMesDeReferencia;
	}

	public JMenuItem getMntmCadMesDeReferencia() {
		return mntmCadMesDeReferencia;
	}

	public void mudarPanel(JPanel panel) {
		if (this.panel!=null) {
			this.remove(this.panel);
			this.panel = null;
			System.gc();
		}
		this.panel = panel;
		this.add(this.panel);
		this.repaint();
		System.gc();
	}
}
