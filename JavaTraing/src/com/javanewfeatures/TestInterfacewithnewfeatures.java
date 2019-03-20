package com.javanewfeatures;


	public class TestInterfacewithnewfeatures implements SampleInterface {

		public static void main(String[] args) {
			final TestInterfacewithnewfeatures t = new TestInterfacewithnewfeatures();
			t.sayHai("All");
			// t.sayBye("All");
		}

		@Override
		public void sayHai(String name) {
			System.out.println("Hello, " + name);

		}

//		@Override
//		public void sayBye(String name) {
//			System.out.println("Bye, " + name);
	//
//		}

	}

	// coming form third party lib - Ex, Apache
	interface SampleInterface {
		void sayHai(String name);

		public default void sayBye(String name) {

		}

	}
	



