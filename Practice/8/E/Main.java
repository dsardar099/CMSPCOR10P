
// Implement custom exception type in java
import java.util.Scanner;

class CustomAgeException extends Exception {
    CustomAgeException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            testCustomException();
        } catch (CustomAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testCustomException() throws CustomAgeException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Age to vote:: ");
        int age = sc.nextInt();
        if (age < 18) {
            throw new CustomAgeException("Age must be 18 or more");
        }else{
            System.out.println("You are eligible to vote");
        }
    }
}
