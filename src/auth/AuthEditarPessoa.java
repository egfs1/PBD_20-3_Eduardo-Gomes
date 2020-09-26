package auth;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import model.Pessoa;
import view.PanelEditar;

public class AuthEditarPessoa {
	
	private static int newQntFilhos;
	private static int newHorasSemanais;
	private static Date newDataNascimento;
	
	public static void authPessoaUsuario(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, String usuario,
			String senha, PanelEditar tela) {
		
		if (!verifyFields(nome, naturalidade, qntFilhos, dataNascimento, dataAdmissao, horasSemanaisContratadas))return;
			
		if (usuario=="") {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (!tela.getPessoa().getUsuario().equalsIgnoreCase(usuario) && GenericDAO.getPdao().existeUsuario(usuario, GenericDAO.getEmf())) {
			JOptionPane.showMessageDialog(null, "Esse nome de usuario já existe!");
			return;
		}
			
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais, usuario, senha);
		p.setId(tela.getPessoa().getId());
		GenericDAO.getPdao().merge(p, GenericDAO.getEmf());
		JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
		
	}
	
	public static void authPessoaComum(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, PanelEditar tela) {
		
		if (!verifyFields(nome, naturalidade, qntFilhos, dataNascimento, dataAdmissao, horasSemanaisContratadas))return;
			
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais);
		p.setId(tela.getPessoa().getId());
		GenericDAO.getPdao().merge(p, GenericDAO.getEmf());
		JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
		
	}
	
	private static boolean verifyFields(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,String horasSemanaisContratadas) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			if (nome=="" || naturalidade == "" || qntFilhos=="" || !(dataNascimento.length()==10) || horasSemanaisContratadas=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				return false;
			}
			
			newQntFilhos = Integer.parseInt(qntFilhos);
			newHorasSemanais = Integer.parseInt(horasSemanaisContratadas);
			newDataNascimento = DateFor.parse(dataNascimento);
			
			if (dataAdmissao.before(newDataNascimento)) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				return false;
			}
			
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return false;
		}
	}
	
}
