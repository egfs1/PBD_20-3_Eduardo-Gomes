package auth;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import log.LogPessoa;
import model.Criptografar;
import model.GerarSenha;
import model.Pessoa;

public class AuthCadastrarPessoa {
	
	private static int newQntFilhos;
	private static int newHorasSemanais;
	private static double newValorHora;
	private static Date newDataNascimento;
	
	public static void authPessoaUsuario(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, String valorHora, String usuario, Long idUser) {
			
		if (!verifyFields(nome, naturalidade, qntFilhos, dataNascimento, dataAdmissao, horasSemanaisContratadas, valorHora))return;
			
		if (usuario=="") {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
			
		String senha = GerarSenha.gerarSenha(8);
			
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais, newValorHora, usuario, Criptografar.criptografar(senha));
			
		if (GenericDAO.getPdao().persist(p, GenericDAO.getEmf())) {
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!\n Nome de usuario: " + usuario + "\n Senha: " + senha + "\n certifique-se de copiar a senha antes de apertar OK!");
			
			Pessoa user = GenericDAO.getPdao().findID(idUser, GenericDAO.getEmf());
			LogPessoa.logCadastrarPessoa(user, p);
			
		}
		else JOptionPane.showMessageDialog(null, "Esse nome de usuario já existe!");
		
	}
	
	public static void authPessoaComum(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, String valorHora, Long idUser) {
		
		if (!verifyFields(nome, naturalidade, qntFilhos, dataNascimento, dataAdmissao, horasSemanaisContratadas, valorHora))return;
			
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais, newValorHora);
		
		if (GenericDAO.getPdao().persist(p, GenericDAO.getEmf())) {
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
			
			Pessoa user = GenericDAO.getPdao().findID(idUser, GenericDAO.getEmf());
			LogPessoa.logCadastrarPessoa(user, p);
		}
		else JOptionPane.showMessageDialog(null, "Esse nome de usuario já existe!");
		
	}
	
	private static boolean verifyFields(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,String horasSemanaisContratadas, String valorHora) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			if (nome=="" || naturalidade == "" || qntFilhos=="" || !(dataNascimento.length()==10) || horasSemanaisContratadas=="" || valorHora=="") {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
				return false;
			}
			
			newQntFilhos = Integer.parseInt(qntFilhos);
			newHorasSemanais = Integer.parseInt(horasSemanaisContratadas);
			newDataNascimento = DateFor.parse(dataNascimento);
			newValorHora = Double.parseDouble(valorHora);
			
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
