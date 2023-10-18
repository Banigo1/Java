import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Classwork {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Gridlayout");
		frame.getContentPane().setLayout(new GridLayout(1, 3, 5, 5));
		
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel2);
		frame.getContentPane().add(panel3);
		
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		
		ButtonListener handler = new ButtonListener();
		
		button1.addActionListener(handler);
		button2.addActionListener(handler);
		button3.addActionListener(handler);
		
		panel.add(button1);
		panel2.add(button2);
		panel3.add(button3);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private static class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( event.getActionCommand().equals("Button 1") )
				;//do something
			else if( event.getActionCommand().equals("Button 2") )
				;//do something
			else if( event.getActionCommand().equals("Button 3") )
				;//do something
		}
	}
}