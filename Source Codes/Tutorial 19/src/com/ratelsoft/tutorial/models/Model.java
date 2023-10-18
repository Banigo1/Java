package com.ratelsoft.tutorial.models;

import java.util.ArrayList;

import com.ratelsoft.tutorial.views.View;

public abstract class Model {
	protected ArrayList<View> views;
	
	public Model() {
		views = new ArrayList<>();
	}
	
	public void registerView(View v){
		views.add(v);
	}
	public void unregisterView(View v){
		if( views.contains(v) )
			views.remove(v);
	}
	public abstract void fireDataChanged();
}
