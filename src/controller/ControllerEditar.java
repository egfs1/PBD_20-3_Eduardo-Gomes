package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import dao.GenericDAO;
import model.Pessoa;
import view.PanelEditar;

public class ControllerEditar {
	
	private PanelEditar tela;
	
	public ControllerEditar(PanelEditar tela) {
		this.tela = tela;
		
		tela.getRdbtnTipoHorista().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getFormattedTextFieldHoras().setText("");
				tela.getFormattedTextFieldHoras().setEnabled(true);
				
			}
		});
		
		tela.getRdbtnTipoMensalista().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getFormattedTextFieldHoras().setText("40");
				tela.getFormattedTextFieldHoras().setEnabled(false);
			}
		});
		
		tela.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar esse funcionário da base de dados?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
					if (!(tela.getPessoa().getId()==tela.getIdUser())) {
						GenericDAO.getPdao().remove(tela.getPessoa(), GenericDAO.getEmf());
						JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Você não pode deletar o usuario que está usando!");
					}
				}
			}
		});
		
		tela.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = tela.getTextFieldNome().getText().intern();
				
				String naturalidade = tela.getTextFieldNaturalidade().getText().intern();
				
				String dataNascimentoString = tela.getFormattedTextFieldData().getText().intern();
				
				Date dataAdmissao = tela.getPessoa().getDataAdmissao();
				
				String qntFilhosString =tela.getFormattedTextFieldFilhos().getText().intern();
				
				boolean sindicalizado = false;
				if (tela.getRdbtnSindicalizadoSim().isSelected())sindicalizado = true;
				else if(tela.getRdbtnSindicalizadoNao().isSelected()) sindicalizado = false;
				
				String funcao = tela.getPessoa().getFuncao();
				
				String tipo = null;
				if (tela.getRdbtnTipoMensalista().isSelected())tipo = "Mensalista";
				else if(tela.getRdbtnTipoHorista().isSelected())tipo = "Horista";
				
				String horasSemanaisString = tela.getFormattedTextFieldHoras().getText().intern();
				
				String usuario = tela.getTextFieldUsuario().getText().intern();
				
				String senha = tela.getPessoa().getSenha();
				
				if (funcao!="Comum") {
					validarPessoaUsuario(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString, usuario, senha);
				}
				else {
					validarPessoaComum(nome, naturalidade, qntFilhosString, dataNascimentoString, dataAdmissao, sindicalizado, funcao, tipo, horasSemanaisString);
				}
			}
		});
		
		
	}
	
	private void validarPessoaUsuario(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas, String usuario,
			String senha) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		if (nome=="" || naturalidade == "" || usuario=="" || qntFilhos=="" || !(dataNascimento.length()==10) || horasSemanaisContratadas=="") {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Date newDataNascimento = null;
		int newQntFilhos;
		int newHorasSemanais;
		try {
			newQntFilhos = Integer.parseInt(qntFilhos);
			newHorasSemanais = Integer.parseInt(horasSemanaisContratadas);
			newDataNascimento = DateFor.parse(dataNascimento);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (dataAdmissao.before(newDataNascimento)) {
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
	
	private void validarPessoaComum(String nome, String naturalidade, String qntFilhos, String dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, String horasSemanaisContratadas) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		if (nome=="" || naturalidade == "" || qntFilhos=="" || !(dataNascimento.length()==10) || horasSemanaisContratadas=="") {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Date newDataNascimento = null;
		int newQntFilhos;
		int newHorasSemanais;
		try {
			newQntFilhos = Integer.parseInt(qntFilhos);
			newHorasSemanais = Integer.parseInt(horasSemanaisContratadas);
			newDataNascimento = DateFor.parse(dataNascimento);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		if (dataAdmissao.before(newDataNascimento)) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
			return;
		}
		
		Pessoa p = new Pessoa(nome, naturalidade, newQntFilhos, newDataNascimento, dataAdmissao, sindicalizado, funcao, tipo, newHorasSemanais);
		p.setId(tela.getPessoa().getId());
		GenericDAO.getPdao().merge(p, GenericDAO.getEmf());
		JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
	}
	
}
