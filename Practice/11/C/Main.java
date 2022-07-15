
// Implement bubble sort in java
// Time complexity=> O(n^2)
// Space complexity=> O(1)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num[];
        int size = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array: ");
        size = sc.nextInt();
        num = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter numbr at position " + (i + 1)+":: ");
            num[i] = sc.nextInt();
        }

        bubbleSort(num);
    }

    public static int[] bubbleSort(int num[]) {
        System.out.println("Before sort: ");
        display(num);

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    num[j] = num[j] + num[j + 1];
                    num[j + 1] = num[j] - num[j + 1];
                    num[j] = num[j] - num[j + 1];
                }
            }
        }

        System.out.println("After sort: ");
        display(num);
        return num;
    }

    public static void display(int num[]) {
        System.out.println("Array content::");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
