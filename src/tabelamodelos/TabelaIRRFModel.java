package tabelamodelos;


import javax.swing.table.AbstractTableModel;

import tabelasconfig.ValoresIRRF;

public class TabelaIRRFModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private ValoresIRRF[] dados;
	private String[] colunas = {"ID","Base de Calculo", "Aliquota", "Parcela a Deduzir do IRPF"};
	
	public TabelaIRRFModel() {
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	@Override
	public int getRowCount() {
		return dados.length;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
			
		case 0:
			return dados[rowIndex].getId();
		
		case 1:
			
			if (dados[rowIndex].getValorMinimo()==0)
				return "Até R$ " + dados[rowIndex].getValorMaximo();
			
			if (dados[rowIndex].getValorMaximo()==0)
				return "Acima de R$ " + dados[rowIndex].getValorMinimo();
			
			return "De R$ " + dados[rowIndex].getValorMinimo() + " até R$ " + dados[rowIndex].getValorMaximo();
			
		case 2:
			if (dados[rowIndex].getAliquota()==0)
				return "Isento";
			
			return dados[rowIndex].getAliquota() + "%";
			
		case 3:;
			
			return "R$ " + dados[rowIndex].getValorDeduzir();
		}
		return null;
	}

	public void setDados(Object[] tabelas) {
		this.dados = (ValoresIRRF[]) tabelas;
	}

	public ValoresIRRF[] getDados() {
		return dados;
	}

}
