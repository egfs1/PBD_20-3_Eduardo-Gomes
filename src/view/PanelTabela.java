package view;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public class PanelTabela extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	public PanelTabela(AbstractTableModel tableModel, String titulo, int[] columnSizes) {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 32, 800, 568);
		setLayout(null);
		
		table = new JTable();
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setForeground(SystemColor.text);
		table.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		table.setBackground(SystemColor.activeCaption);
		table.setModel(tableModel);
		table.setBounds(10, 73, 780, 484);
		table.setBorder(null);
		
		TableColumnModel columnModel = table.getColumnModel();
		if (columnSizes.length!=0) {
			for (int i = 0; i < columnModel.getColumnCount(); i++) {
				
				columnModel.getColumn(i).setMinWidth(columnSizes[i]);
				columnModel.getColumn(i).setMaxWidth(columnSizes[i]);
				columnModel.getColumn(i).setPreferredWidth(columnSizes[i]);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 73, 780, 484);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel(titulo);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 0, 800, 60);
		add(lblNewLabel);
		
		
		
	}
}
