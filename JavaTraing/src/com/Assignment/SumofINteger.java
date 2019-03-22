package com.Assignment;

public class SumofINteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sumoftwonumbers obj=(int a,int b)->System.out.println(a+b);
		obj.add(5, 6);
		

	}

	
	

}

@FunctionalInterface
interface sumoftwonumbers{
	void add(int a, int b) ;
		
	
}

