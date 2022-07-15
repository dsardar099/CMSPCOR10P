// Implement Abtract class in java

abstract class Abs {
    abstract void display();
}

class A extends Abs {
    void display() {
        System.out.println("Display from class A");
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.display();
    }
}
