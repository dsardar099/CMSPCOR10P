// Implement use of isAlive and join method of thread in java
// t1.isAlive()::false
// t1.isAlive()::true
// t2.isAlive()::false
// Starting of run:: Thread-1
// Starting of run:: Thread-0
// Ending of run:: Thread-1
// t2.isAlive()::false
// t3.isAlive()::false
// t3.isAlive()::true
// Starting of run:: Thread-2
// Ending of run:: Thread-0
// Ending of run:: Thread-2

class CustomThread extends Thread {
    public void run() {
        System.out.println("Starting of run:: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Ending of run:: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            CustomThread t1 = new CustomThread();
            CustomThread t2 = new CustomThread();
            CustomThread t3 = new CustomThread();
            System.out.println("t1.isAlive()::" + t1.isAlive());
            t1.start();
            System.out.println("t1.isAlive()::" + t1.isAlive());
            System.out.println("t2.isAlive()::" + t2.isAlive());
            t2.start();
            t2.join();
            System.out.println("t2.isAlive()::" + t2.isAlive());
            System.out.println("t3.isAlive()::" + t3.isAlive());
            t3.start();
            System.out.println("t3.isAlive()::" + t3.isAlive());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
