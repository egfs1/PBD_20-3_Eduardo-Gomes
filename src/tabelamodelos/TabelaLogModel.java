package tabelamodelos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import log.Log;
import model.FormatarDataLog;

public class TabelaLogModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private List<Log> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Data", "Log"};
	
	public TabelaLogModel(List<Log> dados) {
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
			return FormatarDataLog.dateToFormat(dados.get(rowIndex).getData());
		
		case 2:
			return dados.get(rowIndex).getTexto();
		}
		return null;
	}
	
	public void addRow(Log t) {
		this.dados.add(t);
		this.fireTableDataChanged();
	}
	
}
