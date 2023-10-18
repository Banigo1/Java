package com.ratelsoft.tutorial_001;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Class_work {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Gridlayout");
		
		f.getContentPane().setLayout(new GridLayout(1,1,4,1));
		//f.getContentPane().setLayout(BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		f.getContentPane().add(panel);
		f.getContentPane().add(panel2);
		f.getContentPane().add(panel3);
		
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		
		ButtonListener B = new ButtonListener();
		
		button1.addActionListener(B);
		button2.addActionListener(B);
		button3.addActionListener(B);
		
		panel.add(button1);
		panel2.add(button2);
		panel3.add(button3);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		
	}
	
	private static class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			if( event.getActionCommand().equals("Button 1") );
			//do something
			else if( event.getActionCommand().equals("Button 2") );
			//do something
			else if( event.getActionCommand().equals("Button 3") );
			//do something
		}
	}
}

