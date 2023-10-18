package com.ratelsoft.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Query {
	private Connection con;
	private PreparedStatement ps;
	private Exception e;
	private boolean isConnected;
	
	public Query(String query){
		try{
			try{
				Class.forName("org.sqlite.JDBC").newInstance();
			}
			catch(Exception e){
				Class.forName("org.sqlite.JDBC");
			}
			
			con = DriverManager.getConnection("jdbc:sqlite:" + Util.DB_PATH);
			ps = con.prepareStatement(query);
			
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