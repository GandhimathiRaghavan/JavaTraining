package com.javanewfeatures;



public class DefaultInterfaceMethod implements InterfaceWithDefaultMethod {
	public static void main(String[] args) {
		final DefaultInterfaceMethod example = new DefaultInterfaceMethod();
		example.sayHaiToDefault();
	}
	
	@Override
	public void sayHaiToDefault() {
		System.out.println("hai method Implementation can also be changed");
	}
}

//In daufault interface method you can have method with body in the interface 
//also you can change the body of the method during Implementation

interface InterfaceWithDefaultMethod {
	default void sayHaiToDefault() {
		System.out.println("Hi, you are in default method.");
	}
}
