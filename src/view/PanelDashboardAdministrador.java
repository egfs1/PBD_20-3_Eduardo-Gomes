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
	
	private JMenuItem mntmDeslogar, mntmSair, mntmCadastrarFuncionario, mntmEditar, mntmResetarSenha, mntmMeuPerfil;
	private JPanel panel;
	private Long IDPessoa;
	
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
		
		mntmCadastrarFuncionario = new JMenuItem("Cadastrar Funcionario");
		mnCadastro.add(mntmCadastrarFuncionario);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnEditar.setBounds(100,0,100, 32);
		menuBar.add(mnEditar);
		
		mntmEditar = new JMenuItem("Editar Funcionario");
		mnEditar.add(mntmEditar);
		
		mntmMeuPerfil = new JMenuItem("Meu Perfil");
		mnEditar.add(mntmMeuPerfil);
		
		mntmResetarSenha = new JMenuItem("Resetar Senha");
		mnEditar.add(mntmResetarSenha);
		
		JMenu mnTabelas = new JMenu("Tabelas");
		mnTabelas.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnTabelas.setBounds(200,0,100, 32);
		menuBar.add(mnTabelas);
		
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
