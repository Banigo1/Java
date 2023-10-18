package com.ratelsoft.tutorial;

public class YetAnother {
	public static void main(String[] args){
		Animal[] animals = new Animal[3];
		animals[0] = new Animal(4, "Off White", 5, "Pig");
		animals[1] = new Cat("Black", 3);
		animals[2] = new Man(45);
		
		for(int i = 0; i < animals.length; i++){
			System.out.println(animals[i]);
			if( animals[i] instanceof Man ){
				System.out.println( ((Man) animals[i]).getNameAge() );
			}
		}
	}
}
