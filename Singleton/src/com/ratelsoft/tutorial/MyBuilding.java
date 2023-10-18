package com.ratelsoft.tutorial;

public class MyBuilding {
	
	private static MyBuilding myPlan;
	private int noOfRooms;
	private boolean isAFlat;
	
	public static MyBuilding getInstance(){
		if(myPlan == null){
			myPlan = new MyBuilding();
		}
		return myPlan;
	}
	
	private MyBuilding(){
		noOfRooms = 20;
		isAFlat = true;
	}
	

	public void setNumberOfRoom(int noOfRooms){
		this.noOfRooms = noOfRooms;
	}
	
	public int getNumberOfRoom(){
		return noOfRooms;
	}
	
	public boolean isaFlat(){
		return isAFlat;
	}

}
