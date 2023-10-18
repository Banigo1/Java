package com.ratelsoft.tutorial.views;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.ratelsoft.tutorial.controllers.FormController;
import com.ratelsoft.tutorial.models.FormModel;
import com.ratelsoft.tutorial.models.Model;

public class FormView extends View{
	private JTextField firstnameField, lastnameField;
	private JTabbedPane tabbedPane;
	private JPanel formPanel, viewPanel;
	private JButton saveButton;
	private FormController controller;
	private JLabel firstnameLabel, lastnameLabel;
	
	
	public void buildUI(){
		formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
		viewPanel = new JPanel(new GridLayout(0, 2, 5, 5));
		
		buildFormPanel();
		buildViewPanel();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab("Form", formPanel);
		tabbedPane.addTab("View", viewPanel);
	}
	
	public Component getRootView(){
		return tabbedPane;
	}
	
	private void buildFormPanel(){
		firstnameField = new JTextField(20);
		lastnameField = new JTextField();
		
		formPanel.add(new JLabel("Firstname: "));
		formPanel.add(firstnameField);
		formPanel.add(new JLabel("Lastname: "));
		formPanel.add(lastnameField);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(controller);
		
		formPanel.add(saveButton);
	}
	
	private void buildViewPanel(){
		firstnameLabel = new JLabel();
		lastnameLabel = new JLabel();
		
		viewPanel.add(new JLabel("Firstname: "));
		viewPanel.add(firstnameLabel);
		viewPanel.add(new JLabel("Lastname: "));
		viewPanel.add(lastnameLabel);
	}

	@Override
	public void updateUI(Object... properties) {
		firstnameLabel.setText( ((FormModel) model).getFirstname() );
		lastnameLabel.setText( ((FormModel) model).getLastname() );
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void registerController(FormController c){
		controller = c;
	}
	
	public boolean isSaveButton(Object o){
		return o == saveButton;
	}
	
	public JTextField getFirstNameField(){
		return firstnameField;
	}
	
	public JTextField getLastNameField(){
		return lastnameField;
	}
}
