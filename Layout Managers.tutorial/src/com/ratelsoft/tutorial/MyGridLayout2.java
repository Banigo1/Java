package com.ratelsoft.tutorial;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")

public class MyGridLayout2 extends JFrame{

	public MyGridLayout2() {
		
		GridLayout gl = new GridLayout(3,4,3,3);
		setLayout(gl);
		setSize(500, 550);
		setTitle("GridLayout Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		for(int i = 1; i <= 12; i++){
			add(new JButton("Number "+ i));
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyGridLayout2();

	}

}
