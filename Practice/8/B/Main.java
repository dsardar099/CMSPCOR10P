// Implement throw in java

public class Main {
    public static void main(String[] args) {
        try {
            divide(3, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("b can not be zero");
        }
    }
}
