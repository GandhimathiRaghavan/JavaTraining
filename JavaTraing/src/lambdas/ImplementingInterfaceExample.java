package lambdas;


public class ImplementingInterfaceExample {

	public static void main(String[] args) {

		final SampleFunctionalInterface classImplementingInterface = new ClassImplementingInterface();
		classImplementingInterface.print("You used class implemented the interface.");

		final SampleFunctionalInterface anonymousImplementation = new SampleFunctionalInterface() {
			@Override
			public void print(String msg) {
				System.out.println(msg);
			}
		};
		anonymousImplementation.print("You used anonymous implementation");

		final SampleFunctionalInterface lamdaWayOfImplementation = (msg) -> System.out.println(msg);
		lamdaWayOfImplementation.print("You used lamda way of implementation");

	}

}

@FunctionalInterface
interface SampleFunctionalInterface {
	void print(String msg);
}

class ClassImplementingInterface implements SampleFunctionalInterface {
	@Override
	public void print(final String msg) {
		System.out.println(msg);
	}
}

