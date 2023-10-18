package com.ratelsoft.tutorial;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;

public class Starter {
	
	public Starter() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				buildUI();
			}
		});
	}
	public static void main(String[] args) {
		new Starter();
	}

	private void buildUI(){
		JRibbonFrame.setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Base();
	}
}
