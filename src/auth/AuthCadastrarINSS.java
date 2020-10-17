package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogTabelaINSS;
import model.FormatarVigencia;
import model.Pessoa;
import tabelasconfig.TabelaINSS;
import tabelasconfig.ValoresINSS;

public class AuthCadastrarINSS {
	
	public static boolean authINSS(String vigencia,String valorMinimo1, String valorMaximo1, String aliquota1, 
			String valorMinimo2, String valorMaximo2, String aliquota2, 
			String valorMinimo3, String valorMaximo3, String aliquota3, 
			String valorMinimo4, String valorMaximo4, String aliquota4, Pessoa pessoa) {
		
		try {
			
			if (vigencia.length()!=7 || valorMinimo1 == "" || valorMaximo1 == "" || aliquota1 == ""
					|| valorMinimo2 == "" || valorMaximo2 == "" || aliquota2 == ""
					|| valorMinimo3 == "" || valorMaximo3 == "" || aliquota3 == ""
					|| valorMinimo4 == "" || valorMaximo4 == "" || aliquota4 == "") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				return false;
			}
			
			Date newVigencia = FormatarVigencia.formatToDate(vigencia);
			
			double newValorMinimo1 = Double.parseDouble(valorMinimo1);
			double newValorMaximo1 = Double.parseDouble(valorMaximo1);
			double newAliquota1 = Double.parseDouble(aliquota1);
			
			double newValorMinimo2 = Double.parseDouble(valorMinimo2);
			double newValorMaximo2 = Double.parseDouble(valorMaximo2);
			double newAliquota2 = Double.parseDouble(aliquota2);

			double newValorMinimo3 = Double.parseDouble(valorMinimo3);
			double newValorMaximo3 = Double.parseDouble(valorMaximo3);
			double newAliquota3 = Double.parseDouble(aliquota3);

			double newValorMinimo4 = Double.parseDouble(valorMinimo4);
			double newValorMaximo4 = Double.parseDouble(valorMaximo4);
			double newAliquota4 = Double.parseDouble(aliquota4);
			
			ValoresINSS v1 = new ValoresINSS(newValorMinimo1, newValorMaximo1, newAliquota1);
			ValoresINSS v2 = new ValoresINSS(newValorMinimo2, newValorMaximo2, newAliquota2);
			ValoresINSS v3 = new ValoresINSS(newValorMinimo3, newValorMaximo3, newAliquota3);
			ValoresINSS v4 = new ValoresINSS(newValorMinimo4, newValorMaximo4, newAliquota4);
			
			GenericDAO.getVinssdao().persist(v1, GenericDAO.getEmf());
			GenericDAO.getVinssdao().persist(v2, GenericDAO.getEmf());
			GenericDAO.getVinssdao().persist(v3, GenericDAO.getEmf());
			GenericDAO.getVinssdao().persist(v4, GenericDAO.getEmf());
			
			TabelaINSS tabela = new TabelaINSS(newVigencia, v1.getId(), v2.getId(), v3.getId(), v4.getId());
			
			if (GenericDAO.getTinssdao().persist(tabela, GenericDAO.getEmf())) {
				
				
				LogTabelaINSS.logCadastrarTabelaINSS(pessoa, tabela);
				
				JOptionPane.showMessageDialog(null, "Vigência Cadastrada com sucesso!");
				return true;
			}
			return false;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
			return false;
		}
		
	}
	
}
