package pack1;

public class A {
    int val1;
    public int val2;
    protected int val3;
    private int val4;

    public A() {
        val1 = 1;
        val2 = 2;
        val3 = 3;
        val4 = 4;
    }

    public void display() {
        System.out.println("CLASS=>A -- VALUE-Default: " + val1);
        System.out.println("CLASS=>A -- VALUE-Public: " + val2);
        System.out.println("CLASS=>A -- VALUE-Protected: " + val3);
        System.out.println("CLASS=>A -- VALUE-Private: " + val4);
    }
}

// To compile
// javac -d . A.java