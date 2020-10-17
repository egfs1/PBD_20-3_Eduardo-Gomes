package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogMesDeReferencia;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.MesDeReferencia;

public class AuthCadastrarMesDeReferencia {
	
	public static void authMesDeReferencia(String vigencia, Pessoa pessoa) {
		
		try {
			
			if (vigencia.length()!=7) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				return;			
			}
			
			Date newVigencia = FormatarVigencia.formatToDate(vigencia);
			
			Long idInss = GenericDAO.getTinssdao().findIdByVigencia(newVigencia, GenericDAO.getEmf());
			Long idIrrf = GenericDAO.getTirrfdao().findIdByVigencia(newVigencia, GenericDAO.getEmf());
			Long idSalarioFamilia = GenericDAO.getTsfdao().findIdByVigencia(newVigencia, GenericDAO.getEmf());
			Long idSalarioMinimo = GenericDAO.getTsmdao().findIdByVigencia(newVigencia, GenericDAO.getEmf());
			
			if (idInss!=null && idIrrf!=null && idSalarioFamilia!=null && idSalarioMinimo!=null) {
				
				MesDeReferencia mes = new MesDeReferencia(newVigencia, idSalarioMinimo, idInss, idIrrf, idSalarioFamilia);
				
				if (GenericDAO.getMdrdao().persist(mes, GenericDAO.getEmf())) {
					
					LogMesDeReferencia.logCadastrarMesDeReferencia(pessoa, mes);
					
					JOptionPane.showMessageDialog(null, "Mês de Referência gerado com sucesso!");
					return;
				}
				JOptionPane.showMessageDialog(null, "Já existe um mês de referência pra essa vigência!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "Todas as tabelas de configuração precisam ser criadas para essa vigência!");
				return;
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
			return;
		}
		
	}
	
}
