package com.ratelsoft.tutorial;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Test implements ActionListener{
	private JButton addData, deleteData;
	private MyTableModel2 model;
	private MyFrame f;
	
	public Test() {
		linkDatabase();
		
		buildUI();
	}
	private void buildUI(){
		f = new MyFrame("JTable Test");
		
		JPanel topPanel = new JPanel(new BorderLayout());
		
		model = new MyTableModel2("SELECT * FROM test", this);
		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		
		table.setDefaultRenderer(Object.class, new MyRenderer());
		//table.setDefaultRenderer(JCheckBox.class, new CheckBoxRenderer());
		//table.getColumn(5).setCellRenderer(new CheckBoxRenderer());
		//table.getModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(5).setCellRenderer(new CheckBoxRenderer());
		//table.getColumnModel().getColumn(5).setCellEditor(new CheckBoxEditor(new JCheckBox()));
		table.getColumnModel().getColumn(5).setCellEditor(new ComboBoxEditor(new JComboBox<String>(new String[]{"Male", "Female"})));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMaxWidth(25);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		
		topPanel.add(new JScrollPane(table));
		
		f.getContentPane().add(topPanel, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		addData = new JButton("New Data");
		addData.addActionListener(this);
		
		deleteData = new JButton("Delete Data");
		deleteData.addActionListener(this);
		deleteData.setEnabled(false);
		
		bottomPanel.add(addData);
		bottomPanel.add(deleteData);
		
		f.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		f.setVisible(true);
	}
	public static void main(String[] args){
		new Test();
	}
	public void activateDeleteButton(){
		deleteData.setEnabled(true);
	}
	public void deactivateDeleteButton(){
		if( deleteData != null  )
		deleteData.setEnabled(false);
	}
	private void linkDatabase(){
		try{
			File url = new File( getClass().getResource("files/teamempire.db3").toURI() );
			Util.DB_PATH = url.getAbsolutePath();
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if( e.getSource() == addData ){
			final JDialog dialog = new JDialog(f, "Add New Data", true);
			
			
			final JTextField nameField = new JTextField(18);
			final JTextField emailField = new JTextField();
			final JTextField phoneField = new JTextField();
			
			JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
			panel.add(new JLabel("Name: "));
			panel.add(nameField);
			panel.add(new JLabel("Phone: "));
			panel.add(phoneField);
			panel.add(new JLabel("Email: "));
			panel.add(emailField);
			
			JButton add = new JButton("Add Data");
			add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					Query q = new Query("INSERT INTO test VALUES (NULL, ?, ?, ?)");
					if( q.isConnected() ){
						try{
							PreparedStatement ps = q.getPS();
							
							ps.setString(1, nameField.getText());
							ps.setString(2, phoneField.getText());
							ps.setString(3, emailField.getText());
							
							ps.executeUpdate();
						}
						catch(SQLException e){
							e.printStackTrace();
						}
					}
					else{
						System.err.println("Error: " + q.getErrorMessage());
						q.getException().printStackTrace();
					}
					
					q.disconnect();
					
					dialog.dispose();
					
					JOptionPane.showMessageDialog(f, "Data added successfully");
					
					model.setQuery("SELECT * FROM test");
				}
			});
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.getContentPane().add(panel);
			dialog.getContentPane().add(add, BorderLayout.SOUTH);
			dialog.pack();
			dialog.setLocationRelativeTo(f);
			dialog.setVisible(true);
		}
		else if(e.getSource() == deleteData){
			if( JOptionPane.showConfirmDialog(f, "Are you sure you want to delete the selected data?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ){
				model.deleteSelectedRow();
				model.setQuery("SELECT * FROM test");
			}
		}
	}
	
	private class MyRenderer extends DefaultTableCellRenderer{
		private JLabel label;
		public MyRenderer() {
			label = new JLabel();
			label.setFont(new Font(label.getFont().getName(), Font.PLAIN, label.getFont().getSize()));
			label.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
			label.setOpaque(true);
		}
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			label.setText(value.toString());
			
			if( column == 0 )
				label.setHorizontalAlignment(SwingConstants.CENTER);
			else
				label.setHorizontalAlignment(SwingConstants.LEFT);
			
			if( isSelected ){
				label.setForeground(new JList().getSelectionForeground());
				label.setBackground(new JList().getSelectionBackground());
			}
			else{
				label.setForeground(getForeground());
				label.setBackground(getBackground());
			}
			
			return label;
		}
	}
	
	private class CheckBoxRenderer extends DefaultTableCellRenderer{
		private JCheckBox checkBox;
		
		public CheckBoxRenderer() {
			checkBox = new JCheckBox();
			checkBox.setFocusable(false);
			checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			
			String gender = value.toString();
			if( gender.toLowerCase().equals("male") )
				checkBox.setSelected(true);
			else
				checkBox.setSelected(false);
			
			if( isSelected ){
				checkBox.setForeground(new JList().getSelectionForeground());
				checkBox.setBackground(new JList().getSelectionBackground());
			}
			else{
				checkBox.setForeground(getForeground());
				checkBox.setBackground(getBackground());
			}
			
			return checkBox;
		}
	}
	
	private class CheckBoxEditor extends DefaultCellEditor{
		private JCheckBox checkBox;
		public CheckBoxEditor(JCheckBox checkBox) {
			super(checkBox);
			this.checkBox = checkBox;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			String gender = value.toString();
			if( gender.toLowerCase().equals("male") )
				checkBox.setSelected(true);
			else
				checkBox.setSelected(false);
			
			if( isSelected ){
				checkBox.setForeground(new JList().getSelectionForeground());
				checkBox.setBackground(new JList().getSelectionBackground());
			}
			else{
				checkBox.setForeground(new JList().getForeground());
				checkBox.setBackground(new JList().getBackground());
			}
			
			return checkBox;
		}
		
		@Override
		public Object getCellEditorValue() {
			return checkBox.isSelected() ? "male" : "female";
		}
	}
	
	private class ComboBoxEditor extends DefaultCellEditor{
		private JComboBox comboBox;
		
		public ComboBoxEditor(JComboBox comboBox) {
			super(comboBox);
			this.comboBox = comboBox;
		}
		
		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			String gender = value.toString();
			if( gender.toLowerCase().equals("male") )
				comboBox.setSelectedIndex(0);
			else
				comboBox.setSelectedIndex(1);
			
			if( isSelected ){
				comboBox.setForeground(new JList().getSelectionForeground());
				comboBox.setBackground(new JList().getSelectionBackground());
			}
			else{
				comboBox.setForeground(new JList().getForeground());
				comboBox.setBackground(new JList().getBackground());
			}
			
			return comboBox;
		}
	}
}