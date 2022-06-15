package pack2;

import pack1.*;

class E extends A {
	public void display() {
		// System.out.println("CLASS=>E -- VALUE-Default: "+val1);
		System.out.println("CLASS=>E -- VALUE-Public: " + val2);
		System.out.println("CLASS=>E -- VALUE-Protected: " + val3);
		// System.out.println("CLASS=>E -- VALUE-Private: "+val4);
	}
}

class Other {
	public static void main(String[] args) {
		A a = new A();
		E e = new E();
		// System.out.println("CLASS=>Other -- VALUE-Default: "+a.val1);
		System.out.println("CLASS=>Other -- VALUE-Public: " + a.val2);
		// System.out.println("CLASS=>Other -- VALUE-Protected: "+a.val3);
		// System.out.println("CLASS=>Other -- VALUE-Private: "+a.val4);
		e.display();
	}
}

// To compile
// javac -d . Other.java
// java pack2.Other