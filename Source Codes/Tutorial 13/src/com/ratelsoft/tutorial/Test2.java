package com.ratelsoft.tutorial;


public class Test2 {
	public static void main(String[] args){
		Thread t1 = new Thread(new DoStuff());
		Thread t2 = new Thread(new DoStuff());
		Thread t3 = new Thread(new DoStuff());
		
		System.out.println("Main Thread started");
		
		t1.start();
		t2.start();
		t3.start();
		
		try{
			t1.join();
			t2.join();
			t3.join();
		}catch(Exception e){}
		
		
		System.out.println("Main Thread ended");
	}
	
	private static class DoStuff implements Runnable{
		public void run(){
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
			}
			
			System.out.println(Thread.currentThread().getName());
		}
	}
}