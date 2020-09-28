package auth;

import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.FormatarVigencia;
import tabelasconfig.TabelaIRRF;
import tabelasconfig.ValoresIRRF;

public class AuthCadastrarIRRF {
	
	public static boolean authIRRF(String vigencia,String valorMinimo1, String valorMaximo1, String aliquota1, String valorDeduzir1, 
			String valorMinimo2, String valorMaximo2, String aliquota2, String valorDeduzir2, 
			String valorMinimo3, String valorMaximo3, String aliquota3, String valorDeduzir3, 
			String valorMinimo4, String valorMaximo4, String aliquota4, String valorDeduzir4,
			String valorMinimo5, String valorMaximo5, String aliquota5, String valorDeduzir5) {
		
		try {
			
			if (vigencia.length()!=7 || valorMinimo1 == "" || valorMaximo1 == "" || aliquota1 == "" || valorDeduzir1 == ""
					|| valorMinimo2 == "" || valorMaximo2 == "" || aliquota2 == "" || valorDeduzir2 == ""
					|| valorMinimo3 == "" || valorMaximo3 == "" || aliquota3 == "" || valorDeduzir3 == ""
					|| valorMinimo4 == "" || valorMaximo4 == "" || aliquota4 == "" || valorDeduzir4 == ""
					|| valorMinimo5 == "" || valorMaximo5 == "" || aliquota5 == "" || valorDeduzir5 == "") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				return false;
			}
			
			Date newVigencia = FormatarVigencia.formatToDate(vigencia);
			
			double newValorMinimo1 = Double.parseDouble(valorMinimo1);
			double newValorMaximo1 = Double.parseDouble(valorMaximo1);
			double newAliquota1 = Double.parseDouble(aliquota1);
			double newValorDeduzir1 = Double.parseDouble(valorDeduzir1);
			
			double newValorMinimo2 = Double.parseDouble(valorMinimo2);
			double newValorMaximo2 = Double.parseDouble(valorMaximo2);
			double newAliquota2 = Double.parseDouble(aliquota2);
			double newValorDeduzir2 = Double.parseDouble(valorDeduzir2);

			double newValorMinimo3 = Double.parseDouble(valorMinimo3);
			double newValorMaximo3 = Double.parseDouble(valorMaximo3);
			double newAliquota3 = Double.parseDouble(aliquota3);
			double newValorDeduzir3 = Double.parseDouble(valorDeduzir3);

			double newValorMinimo4 = Double.parseDouble(valorMinimo4);
			double newValorMaximo4 = Double.parseDouble(valorMaximo4);
			double newAliquota4 = Double.parseDouble(aliquota4);
			double newValorDeduzir4 = Double.parseDouble(valorDeduzir4);
			
			double newValorMinimo5 = Double.parseDouble(valorMinimo5);
			double newValorMaximo5 = Double.parseDouble(valorMaximo5);
			double newAliquota5 = Double.parseDouble(aliquota5);
			double newValorDeduzir5 = Double.parseDouble(valorDeduzir5);
			
			ValoresIRRF v1 = new ValoresIRRF(newValorMinimo1, newValorMaximo1, newAliquota1, newValorDeduzir1);
			ValoresIRRF v2 = new ValoresIRRF(newValorMinimo2, newValorMaximo2, newAliquota2, newValorDeduzir2);
			ValoresIRRF v3 = new ValoresIRRF(newValorMinimo3, newValorMaximo3, newAliquota3, newValorDeduzir3);
			ValoresIRRF v4 = new ValoresIRRF(newValorMinimo4, newValorMaximo4, newAliquota4 , newValorDeduzir4);
			ValoresIRRF v5 = new ValoresIRRF(newValorMinimo5, newValorMaximo5, newAliquota5 , newValorDeduzir5);
			
			GenericDAO.getVirrfdao().persist(v1, GenericDAO.getEmf());
			GenericDAO.getVirrfdao().persist(v2, GenericDAO.getEmf());
			GenericDAO.getVirrfdao().persist(v3, GenericDAO.getEmf());
			GenericDAO.getVirrfdao().persist(v4, GenericDAO.getEmf());
			GenericDAO.getVirrfdao().persist(v5, GenericDAO.getEmf());
			
			TabelaIRRF tabela = new TabelaIRRF(newVigencia, v1.getId(), v2.getId(), v3.getId(), v4.getId(), v5.getId());
			
			if (GenericDAO.getTirrfdao().persist(tabela, GenericDAO.getEmf())) {
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
