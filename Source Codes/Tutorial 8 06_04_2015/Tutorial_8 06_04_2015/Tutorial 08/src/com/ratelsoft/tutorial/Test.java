package com.ratelsoft.tutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing Layouts");
		JPanel rootPanel = new JPanel(new BorderLayout());
		frame.setContentPane(rootPanel);
		
		JPanel leftPanel = new JPanel(){
			public Dimension getPreferredSize(){
				//int width = getParent().getWidth() * 30 / 100;//30% of the rootPanel width
				return new Dimension(200, super.getPreferredSize().height);
			}
		};
		leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));//TOP LEFT BOTTOM RIGHT
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		//leftPanel.setPreferredSize(new Dimension(200, 0));
		
		leftPanel.setBackground(Color.BLUE);
		centerPanel.setBackground(Color.ORANGE);
		
		rootPanel.add(leftPanel, BorderLayout.WEST);
		rootPanel.add(centerPanel, BorderLayout.CENTER);
		
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		JButton button1 = new JButton("Add New");
		JButton button2 = new JButton("View Profile");
		JButton button3 = new JButton("Delete");
		JButton button4 = new JButton("Save Data");
		
		fixButton(button1);
		fixButton(button2);
		fixButton(button3);
		fixButton(button4);
		
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(button1);
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(button2);
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(button3);
		leftPanel.add(Box.createVerticalStrut(10));
		leftPanel.add(button4);
		leftPanel.add(Box.createVerticalGlue());
		
		JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 0));
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.WHITE);
		centerPanel.add(topPanel, BorderLayout.CENTER);
		centerPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		JPanel l1 = new JPanel();
		JPanel l2 = new JPanel();
		
		l1.setBackground(Color.YELLOW);
		l2.setBackground(Color.YELLOW);
		
		topPanel.add(l1);
		topPanel.add(l2);
		
		JButton button5 = new JButton("Play");
		JButton button6 = new JButton("Stop");
		JButton button7 = new JButton("Repeat");
		bottomPanel.add(button5);
		bottomPanel.add(button6);
		bottomPanel.add(button7);
		
		frame.setSize(600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private static void fixButton(JButton b){
		b.setMaximumSize(new Dimension(180, b.getPreferredSize().height));
	}
}
