package com.ratelsoft.tutorial;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	String[] header= {"ID", "Name", "Phone", "Email"};
	String[][] data = {
			{"1", "Henry", "08033178408", "hen.ry@rest.6"},
			{"2", "Emmanuel", "08012345677", "emma@ratelsoft.com"}
	};
	@Override
	public int getColumnCount() {
		return header.length;
	}
	@Override
	public int getRowCount() {
		return data.length;
	}
	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	@Override
	public String getColumnName(int column) {
		return header[column];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
}
