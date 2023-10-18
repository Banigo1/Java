package com.ratelsoft.tutorial.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ratelsoft.tutorial.models.FormModel;
import com.ratelsoft.tutorial.views.FormView;

public class FormController extends Controller implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		if( ((FormView) view).isSaveButton(event.getSource()) ){
			//validation
			((FormModel) model).setFirstname(((FormView) view).getFirstNameField().getText());
			((FormModel) model).setLastname(((FormView) view).getLastNameField().getText());
			
			((FormModel) model).fireDataChanged();
		}
	}
	
}
