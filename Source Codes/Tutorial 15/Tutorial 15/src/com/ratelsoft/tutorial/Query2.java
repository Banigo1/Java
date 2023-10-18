package com.ratelsoft.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Query2 {
	private Connection con;
	private PreparedStatement ps;
	private Exception e;
	private boolean isConnected;
	
	public Query2(String query){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			}
			catch(Exception e){
				Class.forName("com.mysql.jdbc.Driver");
			}
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamempire", "root", "");
			ps = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE);
			
			isConnected = true;
		}
		catch(Exception ex){
			isConnected = false;
			e = ex;
		}
	}
	
	public PreparedStatement getPS(){
		return ps;
	}
	
	public void disconnect(){
		try{
			ps.close();
		}catch(Exception e){}
		try{
			con.close();
		}catch(Exception e){}
	}
	
	public Exception getException(){
		return e;
	}
	
	public String getErrorMessage(){
		if( e != null )
			return e.getMessage();
		return "";
	}
	
	public boolean isConnected(){
		return isConnected;
	}
}
