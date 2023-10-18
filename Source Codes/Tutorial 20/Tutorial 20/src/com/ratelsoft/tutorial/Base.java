package com.ratelsoft.tutorial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonComponent;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenu;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;
import org.pushingpixels.flamingo.api.ribbon.resize.RibbonBandResizePolicy;

public class Base extends JRibbonFrame{
	public Base(){
		super("Flamingo Test");
		setApplicationIcon(getIcon("files/table.png", 128));
		
		RibbonApplicationMenu menu = new RibbonApplicationMenu();
		getRibbon().setApplicationMenu(menu);
		
		buildFirstTask();
		buildSecondTask();
		
		add(new JLabel("center"), BorderLayout.CENTER);
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void buildFirstTask(){
		JRibbonBand newBand = new JRibbonBand("New", null);
		
		JCommandButton addButton = new JCommandButton("Add", getIcon("files/plus.png", 64));
		newBand.addCommandButton(addButton, RibbonElementPriority.TOP);
		
		JCommandButton goButton = new JCommandButton("Go", getIcon("files/go-icon.gif", 64));
		newBand.addCommandButton(goButton, RibbonElementPriority.TOP);
		
		List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
		resizePolicies.add(new CoreRibbonResizePolicies.None(newBand.getControlPanel()));
		resizePolicies.add(new CoreRibbonResizePolicies.Mirror(newBand.getControlPanel()));
		resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(newBand.getControlPanel()));
		resizePolicies.add(new CoreRibbonResizePolicies.High2Mid(newBand.getControlPanel()));
		resizePolicies.add(new CoreRibbonResizePolicies.High2Low(newBand.getControlPanel()));
		//resizePolicies.add(new IconRibbonBandResizePolicy(newBand.getControlPanel()));
		
		
		newBand.setResizePolicies(resizePolicies);
		
		
		RibbonTask fileTask = new RibbonTask("File", newBand);
		getRibbon().addTask(fileTask);
	}
	
	private void buildSecondTask(){
		JRibbonBand settingsBand = new JRibbonBand("Settings Band", null);
		
		JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
		panel.add(new JLabel("Name:"));
		panel.add(new JTextField(20));
		panel.add(new JLabel("Age:"));
		panel.add(new JComboBox<String>(new String[]{"12", "13"}));
		panel.add(new JLabel("Name:"));
		panel.add(new JProgressBar());
		
		JRibbonComponent comp = new JRibbonComponent(panel);
		settingsBand.addRibbonComponent(comp, 3);
		
		settingsBand.setResizePolicies(Arrays.asList(
				new CoreRibbonResizePolicies.None(settingsBand.getControlPanel()),
				new CoreRibbonResizePolicies.Mirror(settingsBand.getControlPanel()),
				new IconRibbonBandResizePolicy(settingsBand.getControlPanel())
		));
		
		JRibbonBand fancyBand = new JRibbonBand("Fancy", null);
		fancyBand.addCommandButton(new JCommandButton("Fancy Click", null), RibbonElementPriority.TOP);
		fancyBand.setResizePolicies(Arrays.asList(
				new CoreRibbonResizePolicies.None(fancyBand.getControlPanel())
		));
		
		RibbonTask settingsTask = new RibbonTask("Settings", settingsBand, fancyBand);
		getRibbon().addTask(settingsTask);
	}
	
	private ResizableIcon getIcon(String relPath, int size){
		return ImageWrapperResizableIcon.getIcon(getClass().getResource(relPath), new Dimension(size, size));
	}
}
