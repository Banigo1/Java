package com.ratelsoft.tutorial;

import java.sql.ResultSet;

import javax.swing.table.AbstractTableModel;

public class MyTableModel2 extends AbstractTableModel{
	private ResultSet rs;
	private Query2 q;
	String[] header= {"ID", "Name", "Phone", "Email"};
	
	public MyTableModel2(String query) {
		setQuery(query);
	}
	
	public void setQuery(String query){
		try{
			q = new Query2(query);
			if( q.isConnected() ){
				rs = q.getPS().executeQuery();
			}
			else{
				rs = null;
				q.disconnect();
			}
		}
		catch(Exception e){
			rs = null;
		}
	}
	
	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public int getRowCount() {
		if( rs == null )
			return 0;
		else{
			try{
				rs.last();
				return rs.getRow();
			}
			catch(Exception e){
				return 0;
			}
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		try{
			rs.absolute(row + 1);
			return rs.getString(col + 1);
		}
		catch(Exception e){
		}
		return "";
	}
	
	public void disconnect(){
		q.disconnect();
	}

}
