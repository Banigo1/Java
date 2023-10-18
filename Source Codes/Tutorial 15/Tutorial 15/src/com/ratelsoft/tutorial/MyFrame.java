package com.ratelsoft.tutorial;
import javax.swing.JFrame;


public class MyFrame extends JFrame{
	public MyFrame(String title){
		super(title);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);
		//setVisible(true);
	}
}
