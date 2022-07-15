
// Implement Multilevel inheritance in java
class A {
    void funcA() {
        System.out.println("Func-A from class A");
    }
}

class B extends A {
    void funcB() {
        System.out.println("Func-B from class B");
    }
}

class C extends B {
    void funcC() {
        System.out.println("Func-C from class C");
    }
}

class Main {
    public static void main(String args[]) {
        C c = new C();
        c.funcA();
        c.funcB();
        c.funcC();
    }
}