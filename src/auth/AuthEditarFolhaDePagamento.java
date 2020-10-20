package auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import folhadepagamento.FolhaDePagamento;
import folhadepagamento.GerarFolhaDePagamento;
import log.LogFolhaDePagamento;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.MesDeReferencia;
import tabelasconfig.TabelaINSS;
import tabelasconfig.TabelaIRRF;
import tabelasconfig.TabelaSalarioFamilia;
import tabelasconfig.TabelaSalarioMinimo;
import tabelasconfig.ValoresINSS;
import tabelasconfig.ValoresIRRF;
import view.PanelEditarFolhaDePagamento;

public class AuthEditarFolhaDePagamento {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private static double newAuxilioAlimentacao;
	private static double newHoraExtra;
	private static double newAcrescimoValor;
	private static double newContribuicaoSindical;
	private static double newFaltas;
	private static double newDescontoValor;
	
	@SuppressWarnings("deprecation")
	public static void authEditarFolhaDePagamento(String auxilioAlimentacao, 
			String horaExtra, String acrescimoValor, String acrescimoDescricao, String contribuicaoSindical,
			String faltas, String descontoValor, String descontoDescricao, Pessoa pessoaQueGerou, Pessoa funcionario, FolhaDePagamento folha) {
		
		if (!verifyFields(auxilioAlimentacao, horaExtra, acrescimoValor, contribuicaoSindical, faltas, descontoValor))return;
		
		MesDeReferencia mes = GenericDAO.getMdrdao().findByVigencia(folha.getVigencia(), GenericDAO.getEmf());
		
		TabelaSalarioMinimo tabelaSalarioMinimo = GenericDAO.getTsmdao().findID(mes.getIdSalarioMinimo(), GenericDAO.getEmf());
		TabelaSalarioFamilia tabelaSalarioFamilia = GenericDAO.getTsfdao().findID(mes.getIdSalarioFamilia(), GenericDAO.getEmf());
		TabelaINSS tabelaInss = GenericDAO.getTinssdao().findID(mes.getIdINSS(), GenericDAO.getEmf());
		TabelaIRRF tabelaIrrf = GenericDAO.getTirrfdao().findID(mes.getIdIRRF(), GenericDAO.getEmf());
		
		double salarioBase;
		double adicionalTempoServico;
		
		double salarioBruto;
		
		double inss;
		double valorContribuicaoSindical;
		double irrf;
		
		double totalDescontos;
		
		double salarioFamilia;
		
		double salarioLiquido;
		
		// SALARIO BASE
		
		System.out.println(funcionario.getHorasSemanaisContratadas());
		System.out.println(funcionario.getValorHora());
		
		if (funcionario.getTipo().equals("Mensalista")) {
			System.out.println("1");
			salarioBase = tabelaSalarioMinimo.getValor();
		}else if (funcionario.getHorasSemanaisContratadas()*funcionario.getValorHora()*4 < tabelaSalarioMinimo.getValor()) {
			System.out.println(2);
			salarioBase = tabelaSalarioMinimo.getValor();
		}else {
			System.out.println(3);
			salarioBase = funcionario.getHorasSemanaisContratadas()*funcionario.getValorHora()*4;
		}
		
		// ADICIONAL TEMPO DE SERVICO
		
		Date tempDate1 = funcionario.getDataAdmissao();
		tempDate1.setYear(tempDate1.getYear()+5);
		
		if (tempDate1.before(new Date(System.currentTimeMillis()))) {
			Date tempDate2 = null;
			try {
				tempDate2 = dateFormat.parse("30/04/2000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (tempDate2.after(new Date(System.currentTimeMillis()))) {
				adicionalTempoServico = salarioBase * 0.05;
			}
			else {
				adicionalTempoServico = salarioBase * 0.04;
			}
			
		} else {
			adicionalTempoServico = 0;
		}
		
		// SALARIO BRUTO
		
		salarioBruto = salarioBase + adicionalTempoServico + newHoraExtra + newAuxilioAlimentacao + newAcrescimoValor;
		
		// INSS
		
		ValoresINSS valorinss1 = GenericDAO.getVinssdao().findID(tabelaInss.getIdValorINSS1(), GenericDAO.getEmf());
		ValoresINSS valorinss2 = GenericDAO.getVinssdao().findID(tabelaInss.getIdValorINSS2(), GenericDAO.getEmf());
		ValoresINSS valorinss3 = GenericDAO.getVinssdao().findID(tabelaInss.getIdValorINSS3(), GenericDAO.getEmf());
		ValoresINSS valorinss4 = GenericDAO.getVinssdao().findID(tabelaInss.getIdValorINSS4(), GenericDAO.getEmf());
		
		if (salarioBruto <= valorinss1.getValorMaximo()) {
			inss = salarioBruto * valorinss1.getAliquota() / 100;
		}else 
			if(salarioBruto >= valorinss2.getValorMinimo() && salarioBruto <= valorinss2.getValorMaximo()) {
				inss = salarioBruto * valorinss2.getAliquota() / 100;
			}else
				if(salarioBruto >= valorinss3.getValorMinimo() && salarioBruto <= valorinss3.getValorMaximo()) {
					inss = salarioBruto * valorinss3.getAliquota() / 100;
				}else {
					inss = salarioBruto * valorinss4.getAliquota() / 100;
				}
		
		// CONTRIBUICAO SINDICAL
					
		if (funcionario.isSindicalizado()) {
			valorContribuicaoSindical = salarioBruto * newContribuicaoSindical / 100;
		}else {
			valorContribuicaoSindical = 0;
		}
		
		// IRRF
		
		ValoresIRRF valorirrf1 = GenericDAO.getVirrfdao().findID(tabelaIrrf.getIdValorIRRF1(), GenericDAO.getEmf());
		ValoresIRRF valorirrf2 = GenericDAO.getVirrfdao().findID(tabelaIrrf.getIdValorIRRF2(), GenericDAO.getEmf());
		ValoresIRRF valorirrf3 = GenericDAO.getVirrfdao().findID(tabelaIrrf.getIdValorIRRF3(), GenericDAO.getEmf());
		ValoresIRRF valorirrf4 = GenericDAO.getVirrfdao().findID(tabelaIrrf.getIdValorIRRF4(), GenericDAO.getEmf());
		ValoresIRRF valorirrf5 = GenericDAO.getVirrfdao().findID(tabelaIrrf.getIdValorIRRF5(), GenericDAO.getEmf());
		
		if (salarioBruto <= valorirrf1.getValorMaximo()) {
			irrf = salarioBruto * valorirrf1.getAliquota() / 100;
		}else 
			if(salarioBruto >= valorirrf2.getValorMinimo() && salarioBruto <= valorirrf2.getValorMaximo()) {
				irrf = salarioBruto * valorirrf2.getAliquota() / 100;
			}else
				if(salarioBruto >= valorirrf3.getValorMinimo() && salarioBruto <= valorirrf3.getValorMaximo()) {
					irrf = salarioBruto * valorirrf3.getAliquota() / 100;
				}else 
					if (salarioBruto >= valorirrf4.getValorMinimo() && salarioBruto <= valorirrf4.getValorMaximo()) {
						irrf = salarioBruto * valorirrf4.getAliquota() / 100; 
					}else {
						irrf = salarioBruto * valorirrf5.getAliquota() / 100;
					}
		
		// TOTAL DESCONTOS
		
		totalDescontos = inss + valorContribuicaoSindical + newFaltas + irrf + newDescontoValor;
		
		// SALARIO FAMILIA
		
		if (salarioBase <= tabelaSalarioFamilia.getRemuneracaoMensal()) {
			salarioFamilia = funcionario.getQntFilhos() * tabelaSalarioFamilia.getValorUnitario();
		}
		else {
			salarioFamilia = 0;
		}
		
		// SALARIO LIQUIDO
		
		salarioLiquido = salarioBruto - totalDescontos + salarioFamilia;
		
		FolhaDePagamento newFolha = new FolhaDePagamento(folha.getVigencia(), funcionario.getId(), salarioBase, adicionalTempoServico, newHoraExtra,
				newAuxilioAlimentacao, salarioFamilia, newAcrescimoValor, acrescimoDescricao, inss, valorContribuicaoSindical, irrf,
				newFaltas, newDescontoValor, descontoDescricao, salarioLiquido);
		
		newFolha.setId(folha.getId());
		
		GenericDAO.getFpdao().merge(newFolha, GenericDAO.getEmf());
			
		LogFolhaDePagamento.logEditarFolha(pessoaQueGerou, newFolha, funcionario);
			
		GerarFolhaDePagamento.gerar(newFolha);
			
		JOptionPane.showMessageDialog(null, "Folha de Pagamento editada com sucesso!");
		
	}
	
	
	
	public static void authBuscar(String vigencia, String usuario, PanelEditarFolhaDePagamento tela) {
		
		if (usuario == "" || vigencia.length() != 7) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
			return;
		}
		
		Date newVigencia = FormatarVigencia.formatToDate(vigencia);
		
		Pessoa user = GenericDAO.getPdao().findUsuarioORID(usuario, GenericDAO.getEmf());
		
		if (user==null) {
			JOptionPane.showMessageDialog(null, "Usuario incorreto!");
			return;
		}
		
		FolhaDePagamento folha = GenericDAO.getFpdao().findByUserIdAndVigencia(user.getId(), newVigencia,  GenericDAO.getEmf());
		
		
		if (user!=null && folha!=null) {
			
			tela.setUsuario(user);
			tela.setFolha(folha);
			
			tela.getTextFieldHoraExtra().setEnabled(true);
			tela.getTextFieldHoraExtra().setText(folha.getHoraExtra() + "");
			
			tela.getTextFieldAuxilioAlimentacao().setEnabled(true);
			tela.getTextFieldAuxilioAlimentacao().setText(folha.getAuxilioAlimentacao() + "");
			
			tela.getTextFieldAcrescimoValor().setEnabled(true);
			tela.getTextFieldAcrescimoValor().setText(folha.getAcrescimoValor() + "");
			
			tela.getTextFieldAcrescimoDescricao().setEnabled(true);
			tela.getTextFieldAcrescimoDescricao().setText(folha.getAcrescimoDescricao());
			
			tela.getTextFieldFaltas().setEnabled(true);
			tela.getTextFieldFaltas().setText(folha.getFaltas() + "");
			
			tela.getTextFieldDescontoValor().setEnabled(true);
			tela.getTextFieldDescontoValor().setText(folha.getDescontoValor() + "");
			
			tela.getTextFieldDescontoDescricao().setEnabled(true);
			tela.getTextFieldDescontoDescricao().setText(folha.getDescontoDescricao() + "");
			
			tela.getBtnDeletar().setEnabled(true);
			tela.getBtnSalvar().setEnabled(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "Não existe uma folha de pagamento desse funcionario para essa vigencia");
		}
		
	}
	
	private static boolean verifyFields(String auxilioAlimentacao, 
			String horaExtra, String acrescimoValor, String contribuicaoSocial,
			String faltas, String descontoValor) {
		try {
			
			if (auxilioAlimentacao=="" || horaExtra=="" || acrescimoValor=="" || contribuicaoSocial=="" || faltas=="" || descontoValor=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				return false;
			}
			
			newAuxilioAlimentacao = Double.parseDouble(auxilioAlimentacao);
			newHoraExtra = Double.parseDouble(horaExtra);
			newAcrescimoValor = Double.parseDouble(acrescimoValor);
			newContribuicaoSindical = Double.parseDouble(contribuicaoSocial);
			newFaltas = Double.parseDouble(faltas); 
			newDescontoValor = Double.parseDouble(descontoValor);
			
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return false;
		}
	}
	
}
