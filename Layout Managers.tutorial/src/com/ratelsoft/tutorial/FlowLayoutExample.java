package com.ratelsoft.tutorial;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutExample extends JFrame{
	
	JFrame jFrame;

	public FlowLayoutExample() {
		
		setTitle("FlowLayout Example");
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setSize(200, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.RED);
		
		for(int i = 0; i < 10; i++){
			JLabel l = new JLabel("Label " + i + " ");
			l.setForeground(Color.WHITE);
			add(l);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new FlowLayoutExample();
	}

}
