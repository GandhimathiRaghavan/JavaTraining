package com.expectionalhandling;

public class Testtrycatch {
	
	
		public static void main(String args[]){
		try{
		int data=50/0;
		}catch(ArithmeticException e)
		{
			System.out.println("hi im out   "+e);
			}
		System.out.println("rest of the code...");
		}
		
		
		}


