package com.ratelsoft.tutorials;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {
		
		Scanner kbinput = new Scanner(System.in);
		String answer;
		
		do{
		int i = 0;
		while(i <= 20){
			int j = 0; 
			while(j <= i){
				System.out.print(j + " ");
				j++;
			}
			System.out.println("\n");
			i++;
		}
		
		System.out.print("Do you wish to run this loop again? (Y/N): ");
		answer = kbinput.next();
		}while(answer.equals("Y") || answer.equals("y"));

		System.out.print("Program Terinated Successfully!");
	}

}
