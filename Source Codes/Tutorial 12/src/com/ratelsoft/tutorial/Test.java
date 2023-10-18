package com.ratelsoft.tutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test implements ChangeListener{
	private JLabel statusBar;
	private JTabbedPane tabs;
	private ImageIcon icon;
	
	public Test(){
		MyFrame f = new MyFrame("Tabbed Pane Test");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Legend"));
		panel.add(new JLabel("Simple"));
		
		tabs = new JTabbedPane();
		tabs.addTab("First", new JTextArea());
		tabs.addTab("Panel", panel);

		tabs.addChangeListener(this);
		
		icon = new ImageIcon(Test.class.getResource("images/file.gif"));
		BorderLayout l = new BorderLayout();
		l.setHgap(7);
		JPanel tabComponent = new JPanel(l);
		tabComponent.add(new JLabel(icon), BorderLayout.WEST);
		tabComponent.add(new JLabel("First Tab "), BorderLayout.CENTER);
		tabComponent.setOpaque(false);
		
		JButton b = new JButton("X");
		b.setPreferredSize(new Dimension(20, 24));
		b.setBorderPainted(false);
		b.setFocusable(false);
		b.setFocusPainted(false);
		b.setBorder(null);
		b.setOpaque(false);
		b.setBackground(null);
		b.setContentAreaFilled(false);
		
		tabComponent.add(b, BorderLayout.EAST);
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tabs.removeTabAt(0);
			}
		});
		
		tabs.setTabComponentAt(0, tabComponent);
		
		statusBar = new JLabel("Status: ");
		f.getContentPane().add(statusBar, BorderLayout.SOUTH);
		
		f.getContentPane().add(tabs);
		f.setVisible(true);
	}
	
	public static void main(String[] args){
		new Test();
	}
	
	public void stateChanged(ChangeEvent event){
		if( tabs.getSelectedIndex() == 0 )
			statusBar.setText("Status: First Tab selected");
		else
			statusBar.setText("Status: Panel Tab selected");
	}
}
