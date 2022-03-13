import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter size of the stack: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Stack s = new Stack(n);
        int choice = 0;
        while (true) {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data to be pushed: ");
                    int data = sc.nextInt();
                    s.push(data);
                    break;
                case 2:
                    System.out.println("Popped element is: " + s.pop());
                    break;
                case 3:
                    System.out.println("Peeked element is: " + s.peek());
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Size of the stack is: " + s.size());
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

class Stack {
    int stack[];
    int top;

    Stack(int size) {
        stack = new int[size];
        top = -1;
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = data;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == stack.length - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    int size() {
        return top + 1;
    }
}