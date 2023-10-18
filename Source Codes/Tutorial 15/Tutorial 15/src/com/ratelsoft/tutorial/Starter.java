package com.ratelsoft.tutorial;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Starter {
	public Starter() {
		linkDatabase();
		
		//startApp();
		updateRecord(1);
	}
	public static void main(String[] args){
		new Starter();
	}
	private void linkDatabase(){
		try{
			File url = new File( getClass().getResource("files/teamempire.db3").toURI() );
			Util.DB_PATH = url.getAbsolutePath();
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	private void displayResults(){
		Query q = new Query("SELECT * FROM test");
		if( q.isConnected() ){
			try{
				ResultSet rs = q.getPS().executeQuery();
				while( rs.next() ){
					System.out.println(rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("phone") + "\t" + rs.getString("email"));
					
				}
				rs.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		else{
			System.err.println("Error: " + q.getErrorMessage());
			q.getException().printStackTrace();
		}
		q.disconnect();
	}
	private void startApp(){
		Query q = new Query("INSERT INTO test VALUES (NULL, ?, ?, ?)");
		if( q.isConnected() ){
			try{
				PreparedStatement ps = q.getPS();
				
				ps.setString(1, "Joseph");
				ps.setString(2, "24367821");
				ps.setString(3, "j.self@us.them");
				
				ps.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		else{
			System.err.println("Error: " + q.getErrorMessage());
			q.getException().printStackTrace();
		}
		
		q.disconnect();
		
		displayResults();
	}
	
	private void updateRecord(int id){
		Query q = new Query("UPDATE test SET name = ?, email = ? WHERE id = ?");
		if( q.isConnected() ){
			try{
				PreparedStatement ps = q.getPS();
				
				ps.setString(1, "Henry");
				ps.setString(2, "hen.ry@rest.6");
				ps.setInt(3, id);
				
				ps.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		else{
			System.err.println("Error: " + q.getErrorMessage());
			q.getException().printStackTrace();
		}
		
		q.disconnect();
		
		displayResults();
	}
}
