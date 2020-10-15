package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import dao.GenericDAO;
import model.Criptografar;
import model.FormatarVigencia;
import model.GerarSenha;
import model.Pessoa;
import tabelamodelos.TabelaMesDeReferenciaModel;
import tabelamodelos.TabelaPessoaModel;
import tabelamodelos.TabelaSalarioFamiliaModel;
import tabelamodelos.TabelaSalarioMinimoModel;
import tabelasconfig.MesDeReferencia;
import tabelasconfig.TabelaINSS;
import tabelasconfig.TabelaIRRF;
import tabelasconfig.TabelaSalarioFamilia;
import tabelasconfig.TabelaSalarioMinimo;
import tabelasconfig.ValoresINSS;
import tabelasconfig.ValoresIRRF;
import view.PanelCadastrarINSS;
import view.PanelCadastrarIRRF;
import view.PanelCadastrarMesDeReferencia;
import view.PanelCadastrarSalarioFamilia;
import view.PanelCadastrarSalarioMinimo;
import view.PanelCadastro;
import view.PanelDashboardAdministrador;
import view.PanelEditar;
import view.PanelEditarINSS;
import view.PanelEditarIRRF;
import view.PanelEditarMesDeReferencia;
import view.PanelEditarPerfil;
import view.PanelEditarSalarioFamilia;
import view.PanelEditarSalarioMinimo;
import view.PanelLogin;
import view.PanelTabela;
import view.PanelVariasTabelas;

public class ControllerDashboardAdministrador {
	
	public ControllerDashboardAdministrador(PanelDashboardAdministrador tela) {
		
		// CADASTRAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		tela.getMntmCadastrarFuncionario().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastro());
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaSalarioMinimo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarSalarioMinimo());
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaSalarioFamilia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarSalarioFamilia());
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaINSS().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarINSS());
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaIRRF().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarIRRF());
				System.gc();
			}
		});
		
		tela.getMntmCadMesDeReferencia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarMesDeReferencia());
				System.gc();
			}
		});
		
		// EDITAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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
		
		tela.getMntmEditarSalarioMinimo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					String vigenciaString = JOptionPane.showInputDialog(null, "Digite a vigência que deseja editar! (MM/yyyy)");
					Date vigencia = FormatarVigencia.formatToDate(vigenciaString);
					
					if (vigencia==null) {
						JOptionPane.showMessageDialog(null, "Escreva a vigência da forma correta!");
						return;
					}
					
					TabelaSalarioMinimo tabela = GenericDAO.getTsmdao().findByVigencia(vigencia, GenericDAO.getEmf());
					if (tabela!=null) {
						tela.mudarPanel(new PanelEditarSalarioMinimo(tabela));
						System.gc();
						return;
					}
					JOptionPane.showMessageDialog(null, "Essa vigência não existe!");
				
				
			}
		});
		
		tela.getMntmEditarSalarioFamilia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String vigenciaString = JOptionPane.showInputDialog(null, "Digite a vigência que deseja editar! (MM/yyyy)");
				Date vigencia = FormatarVigencia.formatToDate(vigenciaString);
				
				if (vigencia==null) {
					JOptionPane.showMessageDialog(null, "Escreva a vigência da forma correta!");
					return;
				}
				
				TabelaSalarioFamilia tabela = GenericDAO.getTsfdao().findByVigencia(vigencia, GenericDAO.getEmf());
				if (tabela!=null) {
					tela.mudarPanel(new PanelEditarSalarioFamilia(tabela));
					System.gc();
					return;
				}
				JOptionPane.showMessageDialog(null, "Essa vigência não existe!");
			}
		});
		
		tela.getMntmEditarINSS().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String vigenciaString = JOptionPane.showInputDialog(null, "Digite a vigência que deseja editar! (MM/yyyy)");
				Date vigencia = FormatarVigencia.formatToDate(vigenciaString);
				
				if (vigencia==null) {
					JOptionPane.showMessageDialog(null, "Escreva a vigência da forma correta!");
					return;
				}
				
				TabelaINSS tabela = GenericDAO.getTinssdao().findByVigencia(vigencia, GenericDAO.getEmf());
				if (tabela!=null) {
					
					ValoresINSS valor1 = GenericDAO.getVinssdao().findID(tabela.getIdValorINSS1(), GenericDAO.getEmf());
					ValoresINSS valor2 = GenericDAO.getVinssdao().findID(tabela.getIdValorINSS2(), GenericDAO.getEmf());
					ValoresINSS valor3 = GenericDAO.getVinssdao().findID(tabela.getIdValorINSS3(), GenericDAO.getEmf());
					ValoresINSS valor4 = GenericDAO.getVinssdao().findID(tabela.getIdValorINSS4(), GenericDAO.getEmf());
					
					tela.mudarPanel(new PanelEditarINSS(tabela, valor1, valor2, valor3, valor4));
					System.gc();
					return;
				}
				JOptionPane.showMessageDialog(null, "Essa vigência não existe!");
				
			}
		});
		
		tela.getMntmEditarIRRF().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String vigenciaString = JOptionPane.showInputDialog(null, "Digite a vigência que deseja editar! (MM/yyyy)");
				Date vigencia = FormatarVigencia.formatToDate(vigenciaString);
				
				if (vigencia==null) {
					JOptionPane.showMessageDialog(null, "Escreva a vigência da forma correta!");
					return;
				}
				
				TabelaIRRF tabela = GenericDAO.getTirrfdao().findByVigencia(vigencia, GenericDAO.getEmf());
				
				if (tabela!=null) {
					
					ValoresIRRF valor1 = GenericDAO.getVirrfdao().findID(tabela.getIdValorIRRF1(), GenericDAO.getEmf());
					ValoresIRRF valor2 = GenericDAO.getVirrfdao().findID(tabela.getIdValorIRRF2(), GenericDAO.getEmf());
					ValoresIRRF valor3 = GenericDAO.getVirrfdao().findID(tabela.getIdValorIRRF3(), GenericDAO.getEmf());
					ValoresIRRF valor4 = GenericDAO.getVirrfdao().findID(tabela.getIdValorIRRF4(), GenericDAO.getEmf());
					ValoresIRRF valor5 = GenericDAO.getVirrfdao().findID(tabela.getIdValorIRRF5(), GenericDAO.getEmf());
					
					tela.mudarPanel(new PanelEditarIRRF(tabela, valor1, valor2, valor3, valor4, valor5));
					System.gc();
					return;
				}
				JOptionPane.showMessageDialog(null, "Essa vigência não existe!");
				
			}
		});
		
		tela.getMntmEditMesDeReferencia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vigenciaString = JOptionPane.showInputDialog(null, "Digite a vigência que deseja editar! (MM/yyyy)");
				Date vigencia = FormatarVigencia.formatToDate(vigenciaString);
				
				if (vigencia==null) {
					JOptionPane.showMessageDialog(null, "Escreva a vigência da forma correta!");
					return;
				}
				
				MesDeReferencia mes = GenericDAO.getMdrdao().findByVigencia(vigencia, GenericDAO.getEmf());
				
				if (mes!=null) {
					tela.mudarPanel(new PanelEditarMesDeReferencia(mes));
					System.gc();
					return;
				}
				
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
		
		// TABELAS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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
		
		tela.getMntmTabelaMesDeReferencia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<MesDeReferencia> dados = GenericDAO.getMdrdao().findAll(GenericDAO.getEmf());
				TabelaMesDeReferenciaModel tableModel = new TabelaMesDeReferenciaModel(dados);
				tela.mudarPanel(new PanelTabela(tableModel, "Mês de Referencia", MesDeReferencia.columnsSize()));
				System.gc();
			}
		});
		
		// OPÇÕES ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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
		
	}
	
	
	
	
	
}