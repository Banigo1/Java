package com.ratelsoft.tutorials;

public class ArrayPlay {

	public static void main(String[] args) {
		

		String[] grade_array = new String[100];
		String[] pre_array = { "A", "B", "C", "D", "E" };
		

		int array_count = 0;
		System.out.println(grade_array.length);
		for(int k = 0; k < grade_array.length; k++) {
				grade_array[k] = pre_array[array_count] + "" + (k+1);
		}

		for (String a : grade_array) {
			System.out.println(a);
		}

		System.out.println("\nFOR LOOP\n======================\n");

		for (int i = 0; i < grade_array.length; i++) {
			System.out.println(grade_array[i]);
		}

		System.out.println("\nORDINARY SYSTEM OUT\n======================\n");
		System.out.println(grade_array[0]);
		System.out.println(grade_array[1]);
		System.out.println(grade_array[2]);
		System.out.println(grade_array[3]);
		System.out.println(grade_array[4]);

		System.out.println("\nWHILE LOOP\n======================\n");
		int count = 0;
		while (count != grade_array.length) {
			System.out.println(grade_array[count]);
			count++;
		}

	}

}
