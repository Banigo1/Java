package com.ratelsoft.tutorial.controllers;

import com.ratelsoft.tutorial.models.Model;
import com.ratelsoft.tutorial.views.View;

public abstract class Controller {
	protected Model model;
	protected View view;
	
	public void registerView(View v){
		view = v;
	}
	
	public void registerModel(Model m){
		model = m;
	}
}
