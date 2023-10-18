package com.ratelsoft.tutorial;

public class Test {

	public static void main(String[] args) {
		MyBuilding myBuilding = MyBuilding.getInstance();
		
		System.out.println(myBuilding.getNumberOfRoom());
		myBuilding.setNumberOfRoom(50);
		System.out.print(myBuilding.getNumberOfRoom());

	}

}
