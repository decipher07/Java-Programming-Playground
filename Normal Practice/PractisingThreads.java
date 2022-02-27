class Multi extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

class Multi3 implements Runnable {
    public void run() {
        System.out.println("thread is running...");
    }
}

class Multithread {
    private int i = 0;

    public void increment() {
        i++;
    }

    public int getValue() {
        return i;
    }
}

class Table {
    synchronized void printTable(int n) {// method not synchronized
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread12 extends Thread {
    Table t;

    MyThread12(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

class Mythread12 extends Thread {
    static Thread mt;

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                mt.join();
            } catch (InterruptedException ex) {
            }
            System.out.println(i);
        }
    }
}

class Mythread1 extends Thread {
    static Thread m1;

    public void run() {
        try {
            // Thread.yield();
            m1.join();
        } catch (InterruptedException ex) {

        }
        for (int i = 0; i < 5; i++) {
            // Thread.yield();
            System.out.println(i * 2);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {

        }

    }
}

class Mythread2 extends Thread {
    static Thread m2;

    public void run() {
        try {
            // Thread.yield();
            m2.join();
        } catch (InterruptedException ex) {

        }
        System.out.println(Thread.currentThread().getName());
        for (int i = 5; i < 10; i++)
            System.out.println(i * 2);

        try {
            Thread.currentThread().join();
        } catch (InterruptedException ex) {

        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {

        }
    }
}

public class PractisingThreads {
    public static void main(String[] args) throws InterruptedException {
        /*
         * // Multi obj = new Multi();
         * // obj.start();
         * 
         * // int n = 8;
         * // for ( int i = 0 ; i < n ; i++ )
         * // {
         * // Multi obj = new Multi();
         * // obj.start();
         * // }
         * 
         * // Multi3 m1 = new Multi3();
         * // Thread t1 = new Thread(m1); // Using the constructor Thread(Runnable r)
         * // t1.start();
         * 
         * // Multithread t = new Multithread();
         * // t.increment();
         * // System.out.println(t.getValue());
            * 
            * // Table obj = new Table();// only one object
            * // MyThread1 t1 = new MyThread1(obj);
            * // MyThread2 t2 = new MyThread2(obj);
            * // t1.start();
            * // t2.start();
            * 
         * 
         * final Table obj = new Table();
         * Thread t1 = new Thread() {
         * public void run() {
         * obj.printTable(5);
         * }
         * };
         * 
         * Thread t2 = new Thread() {
         * public void run() {
         * obj.printTable(100);
         * }
         * };
         * 
         * t1.start();
         * t2.start();
         * 
         * 
         * Mythread1.mt = Thread.currentThread();
         * Mythread1 t1 = new Mythread1();
         * t1.start();
         * t1.join();
         * for (int i = 11; i < 20; i++)
         * System.out.println(i);
         * System.out.println("Main thread");
         */
        Mythread1 t1 = new Mythread1();
        Mythread2 t2 = new Mythread2();
        Mythread1.m1 = Thread.currentThread();
        Mythread2.m2 = Thread.currentThread();
        t1.setName("mythread1");
        t1.getPriority();
        // t1.setPriority(10);
        // t2.setPriority(1);
        t1.join();
        t2.join();
        t2.setName("mythread2");
        System.out.println("priority" + Thread.MIN_PRIORITY);
        t1.start();

        System.out.println(Thread.currentThread().getName());
        // t1.start();
        System.out.println(t1.getName());
        t2.start();
        t1.join();

        System.out.println(t2.getName());
        for (int i = 10; i < 15; i++)
            System.out.println(i * 2);
        System.out.println("Main thread");
    }
}
