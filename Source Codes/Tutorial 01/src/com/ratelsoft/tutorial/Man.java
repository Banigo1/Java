package com.ratelsoft.tutorial;

public class Man extends Animal{

	public Man(int age) {
		super(2, "Brown", age, "Man");
	}
	
	public String getNameAge(){
		return getName() + ", " + getAge();
	}
}
