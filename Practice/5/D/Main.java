// Implement command line args in java

public class Main {
    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}

// Compile as usual but during run-> java Main 1 2 3 4 5
