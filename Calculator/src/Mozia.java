	import java.awt.*;

	import javax.swing.*;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	public class Mozia extends JFrame{
		
    Mozia(String g){

	super(g);
	
	}

	public static void main(String[] args) {

	final JTextField item1 = new JTextField(20);
	final JTextField item2 = new JTextField(20);
	final JTextField item3 = new JTextField(20);
	
	final JLabel l1 = new JLabel("                Enter value :");
	final JLabel l2 = new JLabel("                Enter value :");
	final JLabel l3 = new JLabel("                  the result is : ");
	
	final JButton b1 = new JButton("+");
	final JButton b2 = new JButton("-");
	final JButton b3 = new JButton("*");
	final JButton b4 = new JButton("/");
	final JButton b5 = new JButton("^");
	final JButton b6 = new JButton("clear");
	
	b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	
	{int i, j, z;
	
	calc a = new calc();
	i = Integer.parseInt(item1.getText());
	j = Integer.parseInt(item2.getText());
	z = a.add(i,j);
	String s = String.valueOf(z);
	item3.setText(s);
	}
	});
	
	
	b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{ int i, j, z;
	
	calc a = new calc();
	i = Integer.parseInt(item1.getText());
	j = Integer.parseInt(item2.getText());
	z =  a.sub(i,j);
	String s = String.valueOf(z);
	item3.setText(s);
	}
	});
	
	
	b3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{ int i,j,z;
	calc a = new calc();
	i=Integer.parseInt(item1.getText());
	j=Integer.parseInt(item2.getText());
	z = a.mul(i,j);
	String s=String.valueOf(z);
	item3.setText(s);
	}
	});
	
	
	b4.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{ int i,j,z;
	calc a = new calc();
	i = Integer.parseInt(item1.getText());
	j=Integer.parseInt(item2.getText());
	z = a.div(i,j);
	String s=String.valueOf(z);
	item3.setText(s);
	}
	});
	
	
	b5.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{ int i,j,z;
	calc a = new calc();
	i=Integer.parseInt(item1.getText());
	j=Integer.parseInt(item2.getText());
	z=a.pwr(i,j);
	String s=String.valueOf(z);
	item3.setText(s);
	}
	});
	
	b6.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{ item1.setText("");
	item2.setText("");
	item3.setText("");

	}
	});

	Mozia fr = new Mozia("calculator");
	fr.setLayout(new GridLayout(0,2,2,2));
	
	fr.add(l1);
	fr.add(item1);
	fr.add(l2);
	fr.add(item2);
	fr.add(l3);
	fr.add(item3);
	fr.add(b1);
	fr.add(b2);
	fr.add(b3);
	fr.add(b4);
	fr.add(b5);
	fr.add(b6);
	fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	fr.setVisible(true);
	fr.setSize(300,200);
	}
	}
	
	class calc{

	public int add(int i,int j){

	return i+j;
	}
	
	public int sub(int i,int j){

	return i-j;
	}
	
	public int mul(int i,int j){

	return i*j;
	}
	
	public int div(int i,int j){

	return i/j;
	}
	
	public int pwr(int i,int j){

	return (int)Math.pow(i, j);
	}
	}