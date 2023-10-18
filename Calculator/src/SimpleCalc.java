

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Container;

public class SimpleCalc implements ActionListener{
	
	JFrame jframe;
	JPanel buttonPanel;
	JTextField textfield;
	int calcOperation = 0;
	int result;
 
	public static void main(String[] args){
		EventQueue.invokeLater (new Runnable(){
	@Override
		public void run()
		{
			new SimpleCalc();
		}
		});
	    }
	
	
	
	public SimpleCalc()
	{
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("Banigo Calculator");
		jframe.setSize(500,550);
		//gui.setLocationRelativeTo(null);
		
		
        textfield = new JTextField();
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setEditable(true);
        textfield.setFocusable(false);
        
        jframe.add(textfield, BorderLayout.NORTH);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,3,5,5));
       
        
        jframe.add(buttonPanel);
        buttonPanel.setFont(new Font("Tahoma", Font.BOLD, 50));
        
        
        for (int i=1; i<10;i++)
        {
        
        addButton(buttonPanel,String.valueOf(i));
      
        }
        
            JButton addButton = new JButton("+");
            addButton.setActionCommand("+");
        	OperatorAction subAction = new OperatorAction(1);
        	addButton.addActionListener(subAction);
        	
        	
        	JButton subButton = new JButton("-");
        	subButton.setActionCommand("-");
        	OperatorAction addAction = new OperatorAction(2);
        	subButton.addActionListener(addAction);
        	
        	JButton divButton = new JButton("/");
        	divButton.setActionCommand("/");
        	OperatorAction DIV = new OperatorAction(3);
        	divButton.addActionListener(DIV);
        	
        	JButton mulButton = new JButton("*");
        	mulButton.setActionCommand("*");
        	OperatorAction DIV1 = new OperatorAction(4);
        	mulButton.addActionListener(DIV1);
        	
        	JButton D11 = new JButton("Banigo");
        	D11.setActionCommand("Banigo");
        	OperatorAction DIV11 = new OperatorAction(5);
        	D11.addActionListener(DIV11);
        	
      
        	 JButton equalsButton = new JButton("=");
        	 equalsButton.addActionListener(new ActionListener(){
        		 
        		 
        		 
        		 
       
        		 @Override
        		 public void actionPerformed(ActionEvent event)
        		 {
        			 if (!textfield.getText().isEmpty())
        			 {
        				 int number = Integer.parseInt(textfield.getText());
        				 
        				 
        			 if (calcOperation == 1)
        				 {
        				 
        			int calculate = result + number;
        					textfield.setText(Integer.toString(calculate));
        				 }
        			 
        			 
        			else if (calcOperation == 2)
        				 {
        			int calculate = result - number;
        					 textfield.setText(Integer.toString(calculate));
        				 }	
        			 
        			 
        					 else if (calcOperation == 3)
            				 {
            			int calculate = result / number;
            					 textfield.setText(Integer.toString(calculate));
            				 }
        			 
        			 
            					 else if (calcOperation == 4)
                				 {
                			int calculate = result * number;
                					 textfield.setText(Integer.toString(calculate));
        		     }

            					 else if (calcOperation == 5)
                				 {
                			String calculate = "Banigo";
                					 textfield.setText(calculate);
        		     }
        			 }
        			 }
        		     });
        	 
        	 
        	 buttonPanel.add(addButton);
        	 buttonPanel.add(subButton);
        	 buttonPanel.add(divButton);
        	 buttonPanel.add(mulButton);
        	 buttonPanel.add(equalsButton);
        	 buttonPanel.add(D11);
        	 
        	 jframe.setVisible(true);
    }



	private void addButton(Container parent,String name){
	JButton but = new JButton(name);
	but.setActionCommand(name);
	but.addActionListener(this);
	parent.add(but);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt){
		String action = evt.getActionCommand();
		textfield.setText(action);
	}
	
	
	private class OperatorAction implements ActionListener{
		
		private int Operator;
		
		public OperatorAction(int operation){
		Operator = operation;
	}
		
		
    public void actionPerformed(ActionEvent evt){
	result = Integer.parseInt(textfield.getText());
    calcOperation = Operator;
	}
	}
    }
