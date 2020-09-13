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
	
	private JMenuItem mntmDeslogar, mntmSair;

	/**
	 * Create the panel.
	 */
	public PanelDashboardAdministrador() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 799, 32);
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setLayout(null);
		add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnCadastro.setBounds(0,0,100, 32);
		menuBar.add(mnCadastro);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		mnEditar.setBounds(100,0,100, 32);
		menuBar.add(mnEditar);
		
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
		setVisible(true);

	}

	public JMenuItem getMntmDeslogar() {
		return mntmDeslogar;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}
	
	
	
}
