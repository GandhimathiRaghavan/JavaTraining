package com.javanewfeatures;

public class ExampleofFunctionalInterface implements SampleFunctionalInterface{
	
	@Override
	public void sayHai() {
		System.out.println("Hi, you are in overridden method.");
	}

	public static void main(String[] args) {
		final ExampleofFunctionalInterface example = new ExampleofFunctionalInterface();
		example.sayHai();
	}
}

@FunctionalInterface
interface SampleFunctionalInterface {
	void sayHai();
}


