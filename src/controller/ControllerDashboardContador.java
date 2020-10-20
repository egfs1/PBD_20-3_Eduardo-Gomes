package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import dao.GenericDAO;
import model.FormatarVigencia;
import tabelamodelos.TabelaMesDeReferenciaModel;
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
import view.PanelDashboardContador;
import view.PanelEditarFolhaDePagamento;
import view.PanelEditarINSS;
import view.PanelEditarIRRF;
import view.PanelEditarMesDeReferencia;
import view.PanelEditarPerfil;
import view.PanelEditarSalarioFamilia;
import view.PanelEditarSalarioMinimo;
import view.PanelGerarFolhaDePagamento;
import view.PanelLogin;
import view.PanelTabela;
import view.PanelVariasTabelas;

public class ControllerDashboardContador {
	
	public ControllerDashboardContador(PanelDashboardContador tela) {
		
		// CADASTRAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		tela.getMntmCadVigenciaSalarioMinimo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarSalarioMinimo(tela.getIDPessoa()));
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaSalarioFamilia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarSalarioFamilia(tela.getIDPessoa()));
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaINSS().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarINSS(tela.getIDPessoa()));
				System.gc();
			}
		});
		
		tela.getMntmCadVigenciaIRRF().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarIRRF(tela.getIDPessoa()));
				System.gc();
			}
		});
		
		tela.getMntmCadMesDeReferencia().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelCadastrarMesDeReferencia(tela.getIDPessoa()));
				System.gc();
			}
		});
		
		// EDITAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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
						tela.mudarPanel(new PanelEditarSalarioMinimo(tabela,tela.getIDPessoa()));
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
					tela.mudarPanel(new PanelEditarSalarioFamilia(tabela,tela.getIDPessoa()));
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
					
					tela.mudarPanel(new PanelEditarINSS(tabela, valor1, valor2, valor3, valor4,tela.getIDPessoa()));
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
					
					tela.mudarPanel(new PanelEditarIRRF(tabela, valor1, valor2, valor3, valor4, valor5,tela.getIDPessoa()));
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
					tela.mudarPanel(new PanelEditarMesDeReferencia(mes,tela.getIDPessoa()));
					System.gc();
					return;
				}
				
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
		
		// FOLHA DE PAGAMENTO ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		tela.getMntmGerarFolhaPagamento().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelGerarFolhaDePagamento(tela.getIDPessoa()));
				System.gc();
			}
		});
		
		tela.getMntmEditarFolhaPagamento().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.mudarPanel(new PanelEditarFolhaDePagamento(tela.getIDPessoa()));
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