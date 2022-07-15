
// Implement fibonacci series using recursion in java
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = scanner.nextInt();

        System.out.print("0 1 ");
        fibonacci(0, 1, length - 2);
    }

    public static void fibonacci(int prev, int curr, int length) {
        if (length == 0) {
            return;
        }
        int sum = prev + curr;
        System.out.print(sum + " ");
        fibonacci(curr, sum, length - 1);
    }
}
