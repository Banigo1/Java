package com.ratelsoft.tutorial.views;

import com.ratelsoft.tutorial.models.Model;

public abstract class View {
	protected Model model;
	
	public abstract void updateUI(Object...properties);
	public abstract void setModel(Model model);
}
