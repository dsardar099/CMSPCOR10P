// Implement deadlock in java
// synchronized keyword is used to make the class or method thread-safe which means only one thread can have lock of synchronized method and use it, other threads have to wait till the lock releases and anyone of them acquire that lock. 
// It is important to use if our program is running in multi-threaded environment where two or more threads execute simultaneously. But sometimes it also causes a problem which is called Deadlock. 

class SleepUtil {
    static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println("Timeout Exception:: " + e.getMessage());
        }
    }
}

class Shared {
    synchronized void test1(Shared s) {
        System.out.println("test-1 started:: " + Thread.currentThread().getName());
        SleepUtil.sleep(1000);
        s.test2();
        System.out.println("test-1 ended:: " + Thread.currentThread().getName());
    }

    synchronized void test2() {
        System.out.println("test-2 started:: " + Thread.currentThread().getName());
        SleepUtil.sleep(1000);
        System.out.println("test-2 ended:: " + Thread.currentThread().getName());
    }
}

class Thread1 extends Thread {
    private Shared s1, s2;

    Thread1(Shared s1, Shared s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run() {
        s1.test1(s2);
    }
}

class Thread2 extends Thread {
    private Shared s1, s2;

    Thread2(Shared s1, Shared s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run() {
        s2.test1(s1);
    }
}

public class Main {
    public static void main(String args[]) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();

        Thread1 t1 = new Thread1(s1, s2);
        t1.start();
        Thread2 t2 = new Thread2(s1, s2);
        t2.start();
    }
}

// To solve this deadlock we have to remove 'synchronized' keyword
