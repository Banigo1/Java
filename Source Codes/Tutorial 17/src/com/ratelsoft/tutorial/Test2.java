package com.ratelsoft.tutorial;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test2 {
	public static GridBagConstraints gbc = new GridBagConstraints();
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame("GridBag Test");
		
		JLabel nameLabel = new JLabel("Name: ");
		JLabel addressLabel = new JLabel("Address: ");
		JLabel genderField = new JLabel("Gender: ");
		
		JTextField nameField = new JTextField();
		JTextArea addressArea = new JTextArea();
		JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Male", "Female"});
		JCheckBox checkBox = new JCheckBox("I am Coming");
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		int pos = 0;
		
		addToGrid(nameLabel, pos, 0, 1, 1, 0, 0, panel);
		addToGrid(nameField, pos++, 1, 1, 1, 1, 0, panel);
		
		addToGrid(new JLabel("I am here"), pos++, 0, 2, 1, 1, 0, panel);
		
		addToGrid(addressLabel, pos, 0, 1, 1, 0, 0, panel);
		addToGrid(addressArea, pos++, 1, 1, 3, 1, 1, panel);
		pos += 2;
		
		addToGrid(genderField, pos, 0, 1, 1, 0, 0, panel);
		addToGrid(comboBox, pos++, 1, 1, 1, 1, 0, panel);
		
		addToGrid(checkBox, pos++, 0, 2, 1, 1, 0, panel);
		
		addToGrid(new JLabel(), pos++, 0, 3, 2, 1, 4, panel);
		
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		f.setContentPane(panel);
		
		f.setVisible(true);
	}
	
	public static void addToGrid(Component c, int row, int col, int width, int height, int weightx, int weighty, Container panel){
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.ipadx = 3;
		gbc.ipady = 3;
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		
		panel.add(c, gbc);
	}
}


