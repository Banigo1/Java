package com.ratelsoft.tutorial;

public class ArrayTest {
	public static void main(String[] args){
		int[] ages = new int[4];
		ages[0] = 20;
		ages[1] = 21;
		ages[2] = 24;
		ages[3] = 10;
		
		int[] a = {30, 21, 8, 5, 7};
		
		//System.out.println("The age is " + a.length);
		
		
		String[] names = new String[5];
		names[0] = "Richboy";
		names[1] = "Philip";
		names[2] = "Patience";
		names[3] = "Paul";
		names[4] = "Katey";
		
		/*
		for(int i = 0; i < names.length; i++){
			System.out.println(names[i]);
		}
		*/
		
		int[][] count = new int[3][2];
		count[0][0] = 65;
		count[0][1] = 32;
		count[1][0] = 11;
		count[1][1] = 15;
		count[2][0] = 9;
		count[2][1] = 0;
		
		int[][] counts = {
							{3, 4, 6}, 
							{3, 4}, 
							{1, 2, 6, 8}
						 };
		
		for(int i = 0; i < counts.length; i++){
			for(int j = 0; j < counts[i].length; j++){
				System.out.print(counts[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
