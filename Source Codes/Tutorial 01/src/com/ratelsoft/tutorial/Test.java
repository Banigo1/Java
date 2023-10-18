package com.ratelsoft.tutorial;

public class Test {
	public static void main(String[] args){
		
		Animal a = new Animal(4, "brown", 4, "Cow");
		Animal b = new Animal(2, "black", 20, "Man");
		
		System.out.println(a.getName() + " has " + a.getLegCount() + " legs");
		System.out.println(b.getName() + " has " + b.getLegCount() + " legs");
		
		
		/*Cat c = new Cat("White", 3);
		//System.out.println(c.getName());
		
		Man m = new Man(34);
		//System.out.println(m);
	
		
		Animal man = new Man(34);
		Animal cat = new Cat("White", 3);
		
		
		//System.out.println( ((Man)man).getNameAge() );
		*/
	}
}
