package pack1;

class B extends A {
	public void display() {
		System.out.println("CLASS=>B -- VALUE-Default: " + val1);
		System.out.println("CLASS=>B -- VALUE-Public: " + val2);
		System.out.println("CLASS=>B -- VALUE-Protected: " + val3);
		// System.out.println("CLASS=>B -- VALUE-Private: "+val4);
	}
}

class Assignment71 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.println("CLASS=>C -- VALUE-Default: " + a.val1);
		System.out.println("CLASS=>C -- VALUE-Public: " + a.val2);
		System.out.println("CLASS=>C -- VALUE-Protected: " + a.val3);
		// System.out.println("CLASS=>C -- VALUE-Private: "+a.val4);
		a.display();
		b.display();
	}
}

// To compile
// javac -d . Assignment71.java
// java pack1.Assignment71