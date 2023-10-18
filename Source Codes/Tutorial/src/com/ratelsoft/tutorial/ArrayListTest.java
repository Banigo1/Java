package com.ratelsoft.tutorial;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		
		list.add("Richboy");
		list.add("Paul");
		list.add("David");
		list.add(new Cat("White", 3));
		
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}
