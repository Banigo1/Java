package com.ratelsoft.tutorial;

public class Animal {
	private int legCount;
	private String color;
	private int age;
	private String name;
	
	public Animal(int legCount, String color, int age, String name){
		this.legCount = legCount;
		this.color = color;
		this.age = age;
		this.name = name;
	}
	
	public int getLegCount(){
		return legCount;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name + " has " + legCount + " legs and is aged " + age + " and is coloured " + color; 
	}
}
