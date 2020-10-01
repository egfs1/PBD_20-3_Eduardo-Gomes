package tabelamodelos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.FormatarVigencia;
import tabelasconfig.TabelaSalarioFamilia;

public class TabelaSalarioFamiliaModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<TabelaSalarioFamilia> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Vigência", "Remuneração", "Valor"};
	
	public TabelaSalarioFamiliaModel(List<TabelaSalarioFamilia> dados) {
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
			return FormatarVigencia.dateToFormat(dados.get(rowIndex).getVigencia());
		
		case 2:
			return dados.get(rowIndex).getRemuneracaoMensal();
			
		case 3:
			return dados.get(rowIndex).getValorUnitario();
		}
		return null;
	}
	
	public void addRow(TabelaSalarioFamilia t) {
		this.dados.add(t);
		this.fireTableDataChanged();
	}

}
