// Implement throws in java
// throws is a keyword in Java which is used in the signature of method to indicate that this method might throw one of the listed type exceptions.
// The caller to these methods has to handle the exception using a try-catch block. 

// throws keyword is required only for checked exception and usage of throws keyword for unchecked exception is meaningless.
// throws keyword is required only to convince compiler and usage of throws keyword does not prevent abnormal termination of program.
// By the help of throws keyword we can provide information to the caller of the method about the exception.

public class Main {
    public static void main(String[] args) {
        try {
            test();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inside catch of ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Inside catch of ArithmeticException");
            e.printStackTrace();
        }
    }

    public static void test() throws ArrayIndexOutOfBoundsException, ArithmeticException {
        throw new ArrayIndexOutOfBoundsException();
    }
}
