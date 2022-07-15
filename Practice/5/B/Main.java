// Implement call by value and call by reference in java

class IntegerWrap {
    int data;

    IntegerWrap(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        // Call by value
        int a = 5, b = 10;
        System.out.println("Call By Value--");
        System.out.println("Before swap::A=" + a + ", B=" + b);
        swap(a, b);
        System.out.println("After swap::A=" + a + ", B=" + b);

        // Call by reference
        IntegerWrap ia = new IntegerWrap(5);
        IntegerWrap ib = new IntegerWrap(10);
        System.out.println("Call By Reference--");
        System.out.println("Before swap::A=" + ia.data + ", B=" + ib.data);
        swap(ia, ib);
        System.out.println("After swap::A=" + ia.data + ", B=" + ib.data);
    }

    public static void swap(int a, int b) {
        System.out.println("Before swap inside swap::A=" + a + ", B=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap inside swap::A=" + a + ", B=" + b);
    }

    public static void swap(IntegerWrap a, IntegerWrap b) {
        System.out.println("Before swap inside swap::A=" + a.data + ", B=" + b.data);
        a.data = a.data + b.data;
        b.data = a.data - b.data;
        a.data = a.data - b.data;
        System.out.println("After swap inside swap::A=" + a.data + ", B=" + b.data);
    }
}
