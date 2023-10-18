package com.ratelsoft.tutorial;

import com.ratelsoft.tutorial.controllers.FormController;
import com.ratelsoft.tutorial.models.FormModel;
import com.ratelsoft.tutorial.views.FormView;

public class Starter {
	public static void main(String[] args){
		FormModel model = new FormModel();
		FormView view = new FormView();
		
		model.registerView(view);
		view.setModel(model);
		
		FormController controller = new FormController();
		controller.registerModel(model);
		controller.registerView(view);
		
		view.registerController(controller);
		view.buildUI();
		
		MyFrame frame = new MyFrame("MVC Test");
		frame.add(view.getRootView());
		frame.pack();
		frame.setVisible(true);
	}
}