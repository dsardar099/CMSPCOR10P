import java.util.Scanner;

class Queue {
    int queue[];
    int front;
    int rear;
    int size;

    Queue(int size) {
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        queue[++rear] = data;
        System.out.println("Size of queue is " + size);
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int deleteEle = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return deleteEle;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    boolean isEmpty() {
        return front == -1 || front > rear;
    }

    boolean isFull() {
        return rear == size - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        n = sc.nextInt();
        Queue q = new Queue(n);
        while (true) {
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Peek");
            System.out.println("4.Display");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the data: ");
                    int data = sc.nextInt();
                    q.enqueue(data);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    System.out.println("Peeked element is " + q.peek());
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
}
