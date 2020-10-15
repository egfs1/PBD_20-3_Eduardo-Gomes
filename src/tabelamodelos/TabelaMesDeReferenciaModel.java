package tabelamodelos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.FormatarVigencia;
import tabelasconfig.MesDeReferencia;

public class TabelaMesDeReferenciaModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<MesDeReferencia> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Vigência", "ID Salario Minimo", "ID Salario Familia", "ID INSS", "ID IRRF"};
	
	public TabelaMesDeReferenciaModel(List<MesDeReferencia> dados) {
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
			return dados.get(rowIndex).getIdSalarioMinimo();
			
		case 3:
			return dados.get(rowIndex).getIdSalarioFamilia();
			
		case 4:
			return dados.get(rowIndex).getIdINSS();
			
		case 5:
			return dados.get(rowIndex).getIdIRRF();
		}
		return null;
	}
	
	public void addRow(MesDeReferencia t) {
		this.dados.add(t);
		this.fireTableDataChanged();
	}

}
