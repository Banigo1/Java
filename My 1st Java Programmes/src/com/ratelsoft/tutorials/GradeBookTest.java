package com.ratelsoft.tutorials;

import java.util.Scanner;

public class GradeBookTest {

	public static void main(String[] args) {
		GradeBook g = new GradeBook();
     Scanner input = new Scanner(System.in);

		

		System.out.print("Please enter the course name: ");
		String Banigo = input.nextLine();
		
		System.out.println();
		g.displayMessage(Banigo);
	}

}