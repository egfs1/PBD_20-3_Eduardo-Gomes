package tabelamodelos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pessoa;

public class TabelaPessoaModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<Pessoa> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Nome", "Naturalidade", "N° Filhos", "Data de Nascimento", "Data de Admissão", "Sindicalizado", "Função", "Tipo", "Horas Semanais", "Valor Hora", "Usuario", "Senha"};
	
	public TabelaPessoaModel(List<Pessoa> dados) {
		this.dados = dados;
		this.fireTableDataChanged();
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
			
		case 0:
			return dados.get(rowIndex).getId();
		
		case 1:
			return dados.get(rowIndex).getNome();
		
		case 2:
			return dados.get(rowIndex).getNaturalidade();
		
		case 3:
			return dados.get(rowIndex).getQntFilhos();
		
		case 4:
			return dados.get(rowIndex).getDataNascimento();
			
		case 5:
			return dados.get(rowIndex).getDataAdmissao();
			
		case 6:
			return dados.get(rowIndex).isSindicalizado();
			
		case 7:
			return dados.get(rowIndex).getFuncao();
			
		case 8:
			return dados.get(rowIndex).getTipo();
			
		case 9:
			return dados.get(rowIndex).getHorasSemanaisContratadas();
			
		case 10:
			return dados.get(rowIndex).getValorHora();
			
		case 11:
			return dados.get(rowIndex).getUsuario();
			
		case 12:
			return dados.get(rowIndex).getSenha();
		}
		return null;
	}
	
	public void addRow(Pessoa p) {
		this.dados.add(p);
		this.fireTableDataChanged();
	}
}
