// Implement method overloading in java

class A {
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String args[]) {
        A a = new A();
        int sum1 = a.sum(2, 3);
        System.out.println("sum1 = " + sum1);
        int sum2 = a.sum(2, 3, 4);
        System.out.println("sum2 = " + sum2);
    }
}
