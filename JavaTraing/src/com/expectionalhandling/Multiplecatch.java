package com.expectionalhandling;

public class Multiplecatch {
	
		public static void main(String args[]){
		try{
		int a[]=new int[5];
		a[5]=30/0;
		}
		catch(ArithmeticException | ArrayIndexOutOfBoundsException e)
		{
			System.out.println("task1 is completed  "+e);
			
		}
				
		catch(Exception e) {
		System.out.println("common task completed"); 
		}
		System.out.println("rest of the code...");
		}
		}



