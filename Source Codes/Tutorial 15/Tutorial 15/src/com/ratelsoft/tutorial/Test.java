package com.ratelsoft.tutorial;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Test {
	public Test() {
		MyFrame f = new MyFrame("JTable Test");
		
		MyTableModel2 model = new MyTableModel2("SELECT * FROM test");
		JTable table = new JTable(model);
		
		table.setDefaultRenderer(Object.class, new MyRenderer());
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		
		f.getContentPane().add(new JScrollPane(table));
		
		f.setVisible(true);
	}
	public static void main(String[] args){
		new Test();
	}
	
	private class MyRenderer extends DefaultTableCellRenderer{
		private JLabel label;
		public MyRenderer() {
			label = new JLabel();
			label.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
			label.setOpaque(true);
		}
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			label.setText(value.toString());
			
			if( column == 0 )
				label.setHorizontalAlignment(SwingConstants.CENTER);
			else
				label.setHorizontalAlignment(SwingConstants.LEFT);
			
			if( isSelected ){
				label.setForeground(new JList().getSelectionForeground());
				label.setBackground(new JList().getSelectionBackground());
			}
			else{
				label.setForeground(getForeground());
				label.setBackground(getBackground());
			}
			
			return label;
		}
	}
}