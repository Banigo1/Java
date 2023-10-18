package com.ratelsoft.tutorial;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Layout extends JFrame {

  public static void main(String[] args) {
	  
    JFrame f = new JFrame();
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Container pane = f.getContentPane();
            pane.setLayout(new BorderLayout());
    
    JLabel label = new JLabel("North", JLabel.CENTER);
           label.setFont(new Font("Tahoma", Font.ITALIC, 36));
           label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           pane.add(label, BorderLayout.NORTH);
           
    
    label = new JLabel("South", JLabel.CENTER);
    label.setFont(new Font("Tahoma", Font.BOLD, 36));
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.SOUTH);
    
    
    label = new JLabel("East", JLabel.CENTER);
    label.setFont(new Font("", Font.BOLD, 50));
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.EAST);
    
    
    
    label = new JLabel("West", JLabel.CENTER);
    label.setFont(new Font("", Font.BOLD, 50));
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.WEST);
    
    
    label = new JLabel("Center", JLabel.CENTER);
    label.setFont(new Font("Droid sans", Font.BOLD, 36));
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.CENTER);
    
    
    f.setSize(400, 300);
    f.setVisible(true);
  }

}