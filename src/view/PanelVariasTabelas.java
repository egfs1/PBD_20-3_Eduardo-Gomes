package view;

import java.awt.SystemColor;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;

import model.FormatarVigencia;
import tabelamodelos.TabelaINSSModel;
import tabelamodelos.TabelaIRRFModel;
import tabelasconfig.TabelaINSS;
import tabelasconfig.TabelaIRRF;

public class PanelVariasTabelas extends JPanel {
	
	private TableColumnModel columnModel;
	private JPanel panel;
	private JScrollPane scrollPane;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelVariasTabelas(Object[][] valores, List<Object> tabelas, String titulo, int[] columnSizes, int tableHeight) {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setLayout(null);
		panel.setVisible(true);
		
		scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 72, 780, 497);
		
		for (int i = 0; i < valores.length; i++) {

			JTable table = new JTable();
			table.setRowHeight(30);
			table.getTableHeader().setReorderingAllowed(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setForeground(SystemColor.text);
			table.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
			table.setBackground(SystemColor.activeCaption);
			
			JLabel label = new JLabel();
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
			label.setBounds(0, i*(tableHeight + 100), 780, 50);
			
			switch (valores.getClass().getSimpleName()) {
			
			case "ValoresINSS[][]":
				TabelaINSSModel tinssModel = new TabelaINSSModel();
				TabelaINSS tinss = (TabelaINSS) tabelas.get(i);
				
				tinssModel.setDados(valores[i]);
				table.setModel(tinssModel);
				
				label.setText(FormatarVigencia.dateToFormat(tinss.getVigencia()));
				
				break;
				
			case "ValoresIRRF[][]":
				TabelaIRRFModel tirrfModel = new TabelaIRRFModel();
				TabelaIRRF tirrf = (TabelaIRRF) tabelas.get(i);
				
				tirrfModel.setDados(valores[i]);
				table.setModel(tirrfModel);
				
				label.setText(FormatarVigencia.dateToFormat(tirrf.getVigencia()));
				
				break;
			}
			
			if (columnModel==null) {
				columnModel = table.getColumnModel();
				if (columnSizes.length!=0) {
					for (int i1 = 0; i1 < columnModel.getColumnCount(); i1++) {
						columnModel.getColumn(i1).setMinWidth(columnSizes[i1]);
						columnModel.getColumn(i1).setMaxWidth(columnSizes[i1]);
						columnModel.getColumn(i1).setPreferredWidth(columnSizes[i1]);
					}
				}
			}
			table.setColumnModel(columnModel);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(0, 50 + i*(tableHeight + 100), 780, tableHeight);
			
			panel.add(label);
			panel.add(sp);
			panel.revalidate();
			panel.repaint();
			scrollPane.setViewportView(panel);
			
			if (i*(tableHeight + 150) > 497) {
				panel.setPreferredSize(new Dimension(780, i*(tableHeight + 150)));
				scrollPane.setSize(new Dimension(793, 497));
			}
		}
		
		
		
		JLabel lblNewLabel = new JLabel(titulo);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 0, 800, 60);
		add(lblNewLabel);
		
		add(scrollPane);
		
		
	}
}
