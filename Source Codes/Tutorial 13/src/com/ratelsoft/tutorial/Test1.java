package com.ratelsoft.tutorial;

public class Test1 {
	public static void main(String[] args){
		ValuePair<String, Integer> pair = new ValuePair<>("age", 1);
		ValuePair<String, Boolean> pair2 = new ValuePair<>("status", false);
	}
	
	private static class ValuePair<E, T>{
		private E key;
		private T value;
		
		public ValuePair(E k, T v){
			key = k;
			value = v;
		}
		
		public E getKey(){
			return key;
		}
		
		public T getValue(){
			return value;
		}
	}
}
