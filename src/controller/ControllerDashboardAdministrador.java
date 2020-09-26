package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.Criptografar;
import model.GerarSenha;
import model.Pessoa;
import tabelamodelos.TabelaPessoaModel;
import tabelamodelos.TabelaSalarioFamiliaModel;
import tabelamodelos.TabelaSalarioMinimoModel;
import tabelasconfig.TabelaSalarioFamilia;
import tabelasconfig.TabelaSalarioMinimo;
import tabelasconfig.ValoresINSS;
import tabelasconfig.ValoresIRRF;
import view.PanelCadastro;
import view.PanelDashboardAdministrador;
import view.PanelEditar;
import view.PanelEditarPerfil;
import view.PanelLogin;
import view.PanelTabela;
import view.PanelVariasTabelas;

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
				String input = JOptionPane.showInputDialog(null, "Digite o ID ou o nome de usuario", "Editar Funcionário", JOptionPane.QUESTION_MESSAGE);
				if (input==null)return;
				
				Pessoa buscarUsuario = GenericDAO.getPdao().findUsuarioORID(input, GenericDAO.getEmf());
				if (buscarUsuario!=null) {
					tela.mudarPanel(new PanelEditar(buscarUsuario, tela.getIDPessoa()));
					System.gc();
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum funcionário com esse ID/Nome de usuario!");
				
				
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
						
						String senhaGerada = GerarSenha.gerarSenha(8);
						
						buscarUsuario.setSenha(Criptografar.criptografar(senhaGerada));
						GenericDAO.getPdao().merge(buscarUsuario, GenericDAO.getEmf());
						
						JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!\n" + "Nova Senha: " + senhaGerada + "\nCertifique-se de copiar a senha antes de apertar OK!");
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse funcionário não solicitou o reset da senha!");
						return;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum funcionário com esse ID/Nome de usuario!");
			}
		});
		
		tela.getMntmMeuPerfil().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelEditarPerfil(GenericDAO.getPdao().findID(tela.getIDPessoa(), GenericDAO.getEmf())));
				System.gc();
			}
		});
		
		tela.getMntmTabelaPessoas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Pessoa> dados = GenericDAO.getPdao().findAll(GenericDAO.getEmf());
				TabelaPessoaModel tableModel = new TabelaPessoaModel(dados);
				tela.mudarPanel(new PanelTabela(tableModel, "Funcionários", Pessoa.columnsSize()));
				System.gc();
			}
		});
		
		tela.getMntmTabelaSalarioMinimo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TabelaSalarioMinimo> dados = GenericDAO.getTsmdao().findAll(GenericDAO.getEmf());
				TabelaSalarioMinimoModel tableModel = new TabelaSalarioMinimoModel(dados);
				tela.mudarPanel(new PanelTabela(tableModel, "Salario Mínimo", TabelaSalarioMinimo.columnsSize()));
				System.gc();
			}
		});
		
		tela.getMntmTabelaSalarioFamilia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TabelaSalarioFamilia> dados = GenericDAO.getTsfdao().findAll(GenericDAO.getEmf());
				TabelaSalarioFamiliaModel tableModel = new TabelaSalarioFamiliaModel(dados);
				tela.mudarPanel(new PanelTabela(tableModel, "Salario Família", TabelaSalarioFamilia.columnsSize()));
				System.gc();
			}
		});
		
		tela.getMntmTabelaINSS().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ValoresINSS[][]dados = GenericDAO.getTinssdao().getAllValues(GenericDAO.getEmf());
				List<Object> tabelas = GenericDAO.getTinssdao().findAll(GenericDAO.getEmf());
				tela.mudarPanel(new PanelVariasTabelas(dados, tabelas, "INSS", ValoresINSS.columnsSize(), ValoresINSS.tableHeight()));
				System.gc();
				
			}
		});
		
		tela.getMntmTabelaIRRF().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ValoresIRRF[][]dados = GenericDAO.getTirrfdao().getAllValues(GenericDAO.getEmf());
				List<Object> tabelas = GenericDAO.getTirrfdao().findAll(GenericDAO.getEmf());
				tela.mudarPanel(new PanelVariasTabelas(dados, tabelas, "IRRF", ValoresIRRF.columnsSize(), ValoresIRRF.tableHeight()));
				System.gc();
				
			}
		});
		
	}
	
	
	
	
	
}