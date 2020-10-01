package tabelamodelos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.FormatarVigencia;
import tabelasconfig.TabelaSalarioMinimo;

public class TabelaSalarioMinimoModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<TabelaSalarioMinimo> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Vigência", "Valor do Salario Mínimo"};
	
	public TabelaSalarioMinimoModel(List<TabelaSalarioMinimo> dados) {
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
			return "R$ " +  dados.get(rowIndex).getValor();
		}
		return null;
	}
	
	public void addRow(TabelaSalarioMinimo t) {
		this.dados.add(t);
		this.fireTableDataChanged();
	}

}
