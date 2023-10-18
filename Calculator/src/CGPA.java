

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CGPA {
	
	public static void main (String [] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println ("Enter the number of Course: ");
		int num = input.nextInt();
		System.out.print("      ");
		
		
		int [] creditUnit = new int[num];
		double [] creditValue = new double [num];
		
		
		for (int i = 0; i < creditUnit.length; i++) {
			
			System.out.print("Enter Course " + (i+1) + " Grade: ");
			
			
	        String grade_input = input.next();
	        if (grade_input.equals("A"))
		    	 creditValue[i] = 5.00;
		    
		    else if (grade_input.equals("B"))
		    	creditValue[i] = 4.00;
		    
		    else if (grade_input.equals("C"))
		    	creditValue[i] = 3.00;
		    
		    else if (grade_input.equals("D"))
		    	creditValue[i] = 2.00;
		    
		    else if (grade_input.equals("F"))
		    	creditValue[i] = 0.00;
		    
		    else {
		    	
		    	System.out.println("INVALID GRADE ENTERED:");
		    	
		    	break;
		    }
		    
		   
		   System.out.print("      Enter Course " + (i+1) + " Credit Unit: ");
		    creditUnit[i] = input.nextInt();
		    
		    System.out.println();
		   }
		
		
		int totCredit = 0;
		double totGPA = 0;
		
		for (int i=0; i < creditValue.length; i++){
			
			totGPA = totGPA + (creditValue[i] * creditUnit[i]);
			
			totCredit += creditUnit[i];
		   }
		
		double CGPA = (totGPA/totCredit);
		
		JFrame jf = new JFrame("Result");
		jf.setSize(500, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		
//		 System.out.printf("GPA:%2f", totGPA);
//		 System.out.println();
//		 System.out.println();
//		 System.out.printf("Total Credit %d", totCredit);
//		 System.out.println("                                                         ");
//		 System.out.printf("CGPA : %f ",CGPA);
		 
		 jf.add(new JLabel("GPA: " + totGPA + "  \nTotal Credit: " + totCredit + "  \nCGPA : " +CGPA));
		 jf.setVisible(true);
		 jf.setAlwaysOnTop(true);
		 
	
}
}
	