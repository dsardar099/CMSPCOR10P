// Implement Hierarchical inheritance in java

class A {
    void funcA() {
        System.out.println("Func-A from class A");
    }
}

class B extends A {
    void funcA() {
        System.out.println("Func-A from class B");
    }
    void funcB() {
        System.out.println("Func-B from class B");
    }
}

class C extends A {
    void funcA() {
        System.out.println("Func-A from class C");
    }
    void funcC() {
        System.out.println("Func-C from class C");
    }
}

public class Main {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();

        b.funcA();
        b.funcB();

        c.funcA();
        c.funcC();
    }
}
