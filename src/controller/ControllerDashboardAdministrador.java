package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.RandomStringUtils;

import dao.GenericDAO;
import model.Pessoa;
import view.PanelCadastro;
import view.PanelDashboardAdministrador;
import view.PanelEditar;
import view.PanelLogin;

public class ControllerDashboardAdministrador {
	
	public ControllerDashboardAdministrador(PanelDashboardAdministrador tela) {
		tela.getMntmSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		tela.getMntmDeslogar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerTela.setPanel(new PanelLogin());
				System.gc();
			}
		});
		
		tela.getMntmCadastrarFuncionario().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastro());
				System.gc();
			}
		});
		
		tela.getMntmEditar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, "Digite o ID ou o nome de usuario", "Editar Funcion�rio", JOptionPane.QUESTION_MESSAGE);
				if (input==null)return;
				
				Pessoa buscarUsuario = GenericDAO.getPdao().findUsuarioORID(input, GenericDAO.getEmf());
				if (buscarUsuario!=null) {
					tela.mudarPanel(new PanelEditar(buscarUsuario));
					System.gc();
					return;
				}
				
				JOptionPane.showMessageDialog(null, "N�o foi encontrado nenhum funcion�rio com esse ID/Nome de usuario!");
				
				
			}
		});
		
		tela.getMntmResetarSenha().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, "Digite o ID ou o nome de usuario", "Resetar Senha", JOptionPane.QUESTION_MESSAGE);
				if (input==null)return;
				
				
				Pessoa buscarUsuario = GenericDAO.getPdao().findUsuarioORID(input, GenericDAO.getEmf());
				if (buscarUsuario!=null) {
					if (GenericDAO.getRdao().remove(buscarUsuario.getId(), GenericDAO.getEmf())) {
						String charactersSenha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
						String senhaGerada = RandomStringUtils.random( 8, charactersSenha );
						buscarUsuario.setSenha(senhaGerada);
						GenericDAO.getPdao().merge(buscarUsuario, GenericDAO.getEmf());
						
						JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!\n" + "Nova Senha: " + senhaGerada + "\nCertifique-se de copiar a senha antes de apertar OK!");
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse funcion�rio n�o solicitou o reset da senha!");
						return;
					}
				}
				
				JOptionPane.showMessageDialog(null, "N�o foi encontrado nenhum funcion�rio com esse ID/Nome de usuario!");
			}
		});
		
	}
	
	
	
	
	
}
