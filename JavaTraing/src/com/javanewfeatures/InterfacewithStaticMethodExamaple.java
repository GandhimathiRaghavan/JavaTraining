package com.javanewfeatures;

public class InterfacewithStaticMethodExamaple {
	
		public static void main(String[] args) {
			InterfaceWithStaticMethod.sayHai();
		}
	}

	interface InterfaceWithStaticMethod {
		static void sayHai() {
			System.out.println("Hi, you are in static method.");
		}
		
	}


