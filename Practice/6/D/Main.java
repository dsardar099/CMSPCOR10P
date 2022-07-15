// Implement dynamic method dispatch in java

class A {
    void display() {
        System.out.println("Display from class A");
    }
}

class B extends A {
    void display() {
        System.out.println("Display from class B");
    }
}

class C extends A {
    void display() {
        System.out.println("Display from class C");
    }
}

public class Main {
    public static void main(String[] args) {
        A ref;

        ref = new A();
        ref.display();

        ref = new B();
        ref.display();

        ref = new C();
        ref.display();
    }
}
