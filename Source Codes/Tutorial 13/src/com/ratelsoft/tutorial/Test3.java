package com.ratelsoft.tutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test3 {
	public Test3()  throws Exception{
		ExecutorService executors = Executors.newFixedThreadPool(8);
		
		System.out.println("Main Thread started");
		
		Future f1 = executors.submit(new DoStuff());
		Future f2 = executors.submit(new DoStuff());
		Future f3 = executors.submit(new DoStuff());
		
		Future f = executors.submit(new DoStuff());
		f.get();
		f1.get();
		f2.get();
		f3.get();
		
		executors.shutdown();
		
		System.out.println("Main Thread ended");
	}
	public static void main(String[] args) throws Exception{
		new Test3();
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
