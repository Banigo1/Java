import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
class Calc_1 extends JFrame implements ActionListener{
  
   String str_number="";
   String buff[];
   String entries[];
   int operation=0;
   char operator='\0';
   double num1, num2;
   double result;
 
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b0 = new JButton("0");
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mul= new JButton("*");
    JButton div= new JButton("/");
    JButton equ= new JButton("=");
    JButton clr = new JButton("CLR");
    JButton dec = new JButton(".");
    JButton sini = new JButton("sin");
    JButton cosi = new JButton("cos");
    JButton tani = new JButton("tan");
    JButton lni = new JButton("ln");
    JButton logi = new JButton("log");
    JButton pii = new JButton("pi");
    JButton cbt = new JButton("cbrt");
    JButton sqt = new JButton("sqrt");
    JButton xsq = new JButton("X^2");
    JButton mc = new JButton("MC");
    JButton mr = new JButton("MR");
    JButton mp = new JButton("M+");
   
    JFrame f = new JFrame("Banigo");
    
    
    JPanel NumberPanel = new JPanel();
    JPanel ResultPanel = new JPanel();
    JPanel MemoryPanel = new JPanel();
    
    JTextField text = new JTextField(20);
    JTextField memt = new JTextField(20);
    
   public Calc_1()
    {
   // f.setLayout(new BorderLayout());
    NumberPanel.setLayout(new GridLayout(6,4));
    
    ResultPanel.setLayout(new FlowLayout());
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    NumberPanel.add(b1);
    b1.setFont(new Font ("Tahoma", Font.BOLD,15));
    b1.addActionListener(this);
    
    NumberPanel.add(b2);
  
    b2.setFont(new Font ("Tahoma", Font.BOLD,15));
    b2.addActionListener(this);
    
    NumberPanel.add(b3);
    b3.setFont(new Font ("Tahoma", Font.BOLD,15));
    b3.addActionListener(this);
    
    NumberPanel.add(b4);
    b4.setFont(new Font ("Tahoma", Font.BOLD,15));
    b4.addActionListener(this);
    
    NumberPanel.add(b5);
    b5.setFont(new Font ("Tahoma", Font.BOLD,15));
    b5.addActionListener(this);
    
    NumberPanel.add(b6);
    b6.setFont(new Font ("Tahoma", Font.BOLD,15));
    b6.addActionListener(this);
    
    NumberPanel.add(b7);
    b7.setFont(new Font ("Tahoma", Font.BOLD,15));
    b7.addActionListener(this);
    
    NumberPanel.add(b8);
    b8.setFont(new Font ("Tahoma", Font.BOLD,15));
    b8.addActionListener(this);
    
    NumberPanel.add(b9);
    b9.setFont(new Font ("Tahoma", Font.BOLD,15));
    b9.addActionListener(this);
    
    NumberPanel.add(b0);
    b0.setFont(new Font ("Tahoma", Font.BOLD,15));
    b0.addActionListener(this);
    
    NumberPanel.add(add);
    add.setFont(new Font ("Tahoma", Font.BOLD,15));
    add.addActionListener(this);
    
    NumberPanel.add(sub);
    sub.setFont(new Font ("Tahoma", Font.BOLD,18));
    sub.addActionListener(this);
    
    NumberPanel.add(mul);
    mul.setFont(new Font ("Tahoma", Font.BOLD,15));
    mul.addActionListener(this);
    
    NumberPanel.add(div);
    div.setFont(new Font ("Tahoma", Font.BOLD,15));
    div.addActionListener(this);
   /* 
   NumberPanel.add(dec);
    dec.setFont(new Font ("Tahoma", Font.BOLD,15));
    dec.addActionListener(this);
    */
    NumberPanel.add(sini);
    sini.setFont(new Font ("Tahoma", Font.BOLD,15));
    sini.addActionListener(this);
    
    NumberPanel.add(cosi);
    cosi.setFont(new Font ("Tahoma", Font.BOLD,15));
    cosi.addActionListener(this);
    
    NumberPanel.add(tani);
    tani.setFont(new Font ("Tahoma", Font.BOLD,15));
    tani.addActionListener(this);
    
    NumberPanel.add(logi);
    logi.setFont(new Font ("Tahoma", Font.BOLD,15));
    logi.addActionListener(this);
    
    NumberPanel.add(lni);
    lni.setFont(new Font ("Tahoma", Font.BOLD,15));
    lni.addActionListener(this);
    
    NumberPanel.add(cbt);
    cbt.setFont(new Font ("Tahoma", Font.BOLD,15));
    cbt.addActionListener(this);
    
    NumberPanel.add(sqt);
    sqt.setFont(new Font ("Tahoma", Font.BOLD,15));
    sqt.addActionListener(this);
    
    NumberPanel.add(xsq);
    xsq.setFont(new Font ("Tahoma", Font.BOLD,15));
    xsq.addActionListener(this);
    
    NumberPanel.add(clr);
    clr.setFont(new Font ("Tahoma", Font.BOLD,15));
    clr.addActionListener(this);
  
    /*
	    mc.addActionListener(this);
	    mc.setFont(new Font ("Tahoma", Font.BOLD,15));
	    NumberPanel.add(mc);
	     
	    
	    mr.addActionListener(this);
	    mr.setFont(new Font ("Tahoma", Font.BOLD,15));
	    NumberPanel.add(mr);
	    
	    mp.addActionListener(this);
	    mp.setFont(new Font ("Tahoma", Font.BOLD,15));
	    NumberPanel.add(mp);
    */
    
    NumberPanel.add(equ);
    
    text.setFocusable(true); 
    
    text.addKeyListener(new KeyAdapter(){
    	public void KeyTyped(KeyEvent e){
    		char c = e.getKeyChar();
    		
    		if(c==KeyEvent.VK_ENTER)
    		{
    			equalto();
    		}
    		else if(c==KeyEvent.VK_BACK_SPACE)
    		{
    			str_number="";
    			text.setText("");
    		}
    		else
    		{
    			str_number+= c;
    		}
    	}
    	
    });
    
      ResultPanel.add(text);
      //ResultPanel.add(equ);
      equ.addActionListener(this);
      equ.setFont(new Font ("Tahoma", Font.BOLD,18));
    //MemoryPanel.add(memt);
      
      
      f.add(NumberPanel, BorderLayout.CENTER);
      f.add(ResultPanel, BorderLayout.NORTH);
      //f.add(MemoryPanel, BorderLayout.SOUTH);
      f.setSize(400,500);
      f.setLocationRelativeTo(null);
   
    }
    
    public void actionPerformed(ActionEvent e)
    {
      
      if(e.getSource()==b1)
      {
    	  text.setText("1");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b2)
      {
    	  text.setText("2");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b3)
      {
    	  text.setText("3");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b4)
      {
    	  text.setText("4");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b5)
      {
    	  text.setText("5");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b6)
      {
    	  text.setText("6");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b7)
      {
    	  text.setText("7");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b8)
      {
    	  text.setText("8");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b9)
      {
    	  text.setText("9");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==b0)
      {
    	  text.setText("0");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==clr)
      {
    	 text.setText("");
    	 operation=0;
    	 str_number="";
    	 num1=0;
    	 num2=0;
    	 result=0;
    	 operator='\0';
      }
      
      if(e.getSource()==dec)
      {
    	  text.setText(".");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==add)
      {
    	  text.setText("+");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==sub)
      {
    	  text.setText("-");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==mul)
      {
    	  text.setText("*");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==div)
      {
    	  text.setText("/");
    	  str_number+=text.getText();
    	  text.setText(str_number);
      }
      
      if(e.getSource()==logi)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.log10(num1);
    	 
    	  
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	  
  
      }
      if(e.getSource()==lni)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.log(num1);
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
     }
      
      if(e.getSource()==cosi)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.cos (Math.toRadians(num1));
    	  
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	
     }
      
      if(e.getSource()==sini)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.sin(Math.toRadians(num1));
    	  
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	  
    	 
     }
      
      if(e.getSource()==tani)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.tan(Math.toRadians(num1));
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	  
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
     }
   
      
      if(e.getSource()==pii)
      {
    	  text.setText(str_number+Double.toString(Math.PI));
    	  str_number=text.getText();
     }
    
        if(e.getSource()==sqt)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.sqrt(num1); 
    	  
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	  
     }
      
      if(e.getSource()==cbt)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=Math.cbrt(num1);
    	  
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	 }
      
      if(e.getSource()==xsq)
      {
    	  num1=Double.parseDouble(str_number);
    	  result=num1*num1;
    	  text.setText(Double.toString(result));
    	  str_number=text.getText();
    	 }
      
      if(e.getSource()==mp)
      {
    	 memt.setText(str_number);
     }
      
      if(e.getSource()==mr)
      {
    	  str_number+= memt.getText();
    	  text.setText(str_number);
     }
      
      
      if(e.getSource()==mc)
      {
    	  memt.setText("");
    	 
     }
      
      if(e.getSource()==equ)
      {
    	 equalto();
      }
      }
      public void  equalto() 
      {
	
        if (str_number!="")
    	{
    		text.setText(str_number);
    		System.out.print(str_number);
    		operation=0;
 
    		ScriptEngineManager mgr = new ScriptEngineManager();
    		ScriptEngine engine = mgr.getEngineByName("JavaScript");
    		
    		try{
    			result = Double.parseDouble(engine.eval(str_number).toString());
    		}
    		catch (ScriptException ex){
    			Logger.getLogger(Calc_1.class.getName()).log(Level.SEVERE, null, ex);
    		}
    		text.setText(Double.toString(result));
    		str_number=text.getText();
    	}
    	}
    			
    		public static void main(String args[])
    		{
    			new Calc_1();
    			
    		}
    	}
    