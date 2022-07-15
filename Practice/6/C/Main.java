// Implement method overriding in java

class A {
    void display() {
        System.out.println("Display from Class A");
    }
}

class B extends A {
    void display() {
        System.out.println("Display from Class B");
    }
}

public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.display();
    }
}
