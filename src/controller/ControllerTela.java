package controller;

import javax.swing.JPanel;

import view.PanelLogin;
import view.Tela;

public class ControllerTela {
	
	private static Tela tela;
	
	public static void initTela() {
		if(tela==null) {
			tela = new Tela();
			tela.setContentPane(new PanelLogin());
			tela.setVisible(true);
		}
	}
	
	public static void setPanel(JPanel panel) {
		tela.getContentPane().removeAll();
		tela.setContentPane(panel);
		panel.setVisible(true);
		tela.setVisible(true);
		System.gc();
	}
	
	
	
	
}
