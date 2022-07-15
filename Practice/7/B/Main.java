// Write a program to implement multiple inheritance using interface in java
interface A {
    void funcA();
}

interface B {
    void funcB();
}

class C implements A, B {
    public void funcA() {
        System.out.println("Func A");
    }

    public void funcB() {
        System.out.println("Func B");
    }
}

class Main {
    public static void main(String args[]) {
        C obj = new C();
        obj.funcA();
        obj.funcB();
    }
}