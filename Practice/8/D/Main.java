// Implement Finally in java

public class Main {
    public static void main(String[] args) {
        try {
            int num[] = new int[5];
            num[5] = 1 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inside catch of ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Inside catch of ArithmeticException");
            e.printStackTrace();
        }finally{
            System.out.println("Inside Finally");
        }
    }
}