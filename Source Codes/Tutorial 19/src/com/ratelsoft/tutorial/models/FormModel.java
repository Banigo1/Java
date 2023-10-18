package com.ratelsoft.tutorial.models;

import com.ratelsoft.tutorial.views.View;

public class FormModel extends Model{
	private String firstname;
	private String lastname;
	
	@Override
	public void fireDataChanged() {
		for(View v : views){
			v.updateUI();
		}
	}
	
	public void setFirstname(String fn){
		firstname = fn;
	}
	
	public void setLastname(String ln){
		lastname = ln;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
}
