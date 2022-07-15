// Create thread using Thread class in java

class CustomThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":: Executing CustomThred Run");
    }
}

public class Main {
    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName() + ":: Executing Main");
        Thread t1 = new CustomThread();
        t1.start();
    }
}
