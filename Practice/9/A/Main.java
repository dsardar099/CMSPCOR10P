// Create thread using runnable interface in java

class CustomThread implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":: Executing CustomThred Run");
    }
}

public class Main {
    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName() + ":: Executing Main");
        Thread t1 = new Thread(new CustomThread());
        t1.start();
    }
}
