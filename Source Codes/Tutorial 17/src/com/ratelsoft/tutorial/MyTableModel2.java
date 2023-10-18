package com.ratelsoft.tutorial;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class MyTableModel2 extends AbstractTableModel{
	private Query q;
	String[] header= {"S/N", "ID", "Name", "Phone", "Email", "Gender"};
	private LinkedList<RowData> data;
	private int selectedRow;
	private Test test;
	private Random rand;
	private String[] gender = {"male", "female"};
	
	public MyTableModel2(String query, Test test) {
		rand = new Random();
		data = new LinkedList<>();
		this.test = test;
		setQuery(query);
	}
	
	public void setQuery(String query){
		data.clear();
		test.deactivateDeleteButton();
		
		try{
			q = new Query(query);
			
			if( q.isConnected() ){
				ResultSet rs = q.getPS().executeQuery();
				int count = 1;
				while( rs.next() ){
					RowData d = new RowData();
					d.serialNo = count++;
					d.ID = rs.getInt("id");
					d.name = rs.getString("name");
					d.phone = rs.getString("phone");
					d.email = rs.getString("email");
					d.gender = gender[rand.nextInt(2)];
					
					data.add(d);
				}
				rs.close();
			}
			
			q.disconnect();
		}
		catch(Exception e){
		}
		
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if( columnIndex == 5 )
			return JCheckBox.class;
		else
			return Object.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		selectedRow = rowIndex;
		test.activateDeleteButton();
		if( columnIndex == 5 )
			return true;
		else
			return false;
	}
	
	public void deleteSelectedRow(){
		Query q = new Query("DELETE FROM test WHERE id = " + data.get(selectedRow).ID);
		try{
			q.getPS().executeUpdate();
		}
		catch(Exception e){}
		
		q.disconnect();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		RowData d = data.get(row);
		
		switch( col ){
			case 0: return d.serialNo;
			case 1: return d.ID;
			case 2: return d.name;
			case 3: return d.phone;
			case 4: return d.email;
			case 5: return d.gender;
			default: return "";
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		RowData d = data.get(rowIndex);
		d.gender = aValue.toString();
	}

	private class RowData{
		private int ID, serialNo;
		private String name, phone, email, gender;
	}
}
