
// Copy content of a file into another file in java
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Source File Name:: ");
        String sFile = sc.next();
        System.out.print("Enter Destination File Name:: ");
        String dFile = sc.next();

        FileReader fin = new FileReader(sFile);
        FileWriter fout = new FileWriter(dFile);

        int c;
        System.out.println("Copying...");
        while ((c = fin.read()) != -1) {
            fout.write(c);
        }
        System.out.println("Copied...");
        fin.close();
        fout.close();

    }
}
