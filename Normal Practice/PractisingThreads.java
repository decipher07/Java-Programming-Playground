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
            System.out.println("PRINTING FOR i " + i );
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

class ClassA extends Thread{
	public void run() {
		System.out.println("Start Thread A ....");
		for(int i = 1; i <= 5; i++) {
			System.out.println("From Thread A: i = "+ i);
		}
		System.out.println("... Exit Thread A");
	}
}

class ClassB extends Thread{
public void run() {
	System.out.println("Start Thread B ....");
	for(int j = 1; j <= 5; j++) {
		System.out.println("From Thread B: j = "+ j);
	}
	System.out.println("... Exit Thread B");
	}
}

class ClassC extends Thread{
	public void run() {
	System.out.println("Start Thread C ....");
	for(int k = 1; k <= 5; k++) {
		System.out.println("From Thread C: k = "+ k);
	}
	System.out.println("... Exit Thread C");
	}
}

class Q {			// Q is a class containing two parallel processes
    int n;
    boolean flag = false;
//PRODUCER
    synchronized void put( int n) {	// Produce a value
        if(flag) {							// Entry	      	                      
           try { wait( );}  
           catch(InterruptedException e){
                System.out.println(e);
           }		// to the		      
        }							// critical section	                              
                                                                                      
                    this.n = n;								                                      
            System.out.println( "Produce :" + n);			// Critical Section           
                                                                                      
            flag = true;						// Exit from the	                      
            notify( );							// critical section
        }
//CONSUMER
       synchronized int get( ) {		// Consume a value
        if(! flag) {						// Entry		                          
          try { wait( );}  catch(InterruptedException e){
            System.out.println(e);
          }		// to the		      
        }							// critical section	                              
                                                                                      
        System.out.println( "Consume :" + n);			// Critical Section           												                   
                                                                                      
        flag = false;						// Exit from the	                      
        notify( );							// critical	// section                         	
             return( n );						
    }
}

class Producer implements Runnable  {	// Thread for Producer process 
         Q  q;
     Producer ( Q q ) 	{  	// constructor
     this.q =q;
     new Thread (this).start ( ) ;		// Producer process is started 
    }

   public void run( ) { 		// infinite running  thread for Producer 
    int i = 0;
    while (true ) 	
        q.put ( i++ );
       }
    }

class Consumer implements Runnable { 	// Thread for consumer process
    Q q;
   Consumer (Q q )	{ 	          // Constructor 
   this.q  = q;
   new Thread (this).start ( );
    }

 public void run( ) {		// infinite running thread for Consumer 
 while (true) 
    q.get ( );
    }
}

class TestSleepMethod1 extends Thread{
    public void run(){
    for(int i=1;i<5;i++){
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
    System.out.println(i);
    }
    }
}

class Counter{
    int count;
    public void increment(){
    count++;
    }
    }
class Mythread11 extends Thread{
    Counter c;
    Mythread11(Counter c){
    this.c=c;
    }
    public void run(){
    for(int i=0;i<10000;i++){
    c.increment();
    }
   }
}
class Mythread21 extends Thread{
    Counter c;
    Mythread21(Counter c){
    this.c=c;
    }
   
    public void run(){
    for(int i=0;i<10000;i++){
    c.increment();
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
    
        
        // ClassA t1 = new ClassA();
        // ClassB t2 = new ClassB();
        // ClassC t3 = new ClassC();

        // t3.setPriority(Thread.MAX_PRIORITY);
        // t2.setPriority(t2.getPriority() + 1);
        // t1.setPriority(Thread.MIN_PRIORITY);

        // t1.start(); t2.start(); t3.start();
        // System.out.println("... End of executuion ");

        // Q q = new Q( );		// an instance of parallel processes  is created
		// new Producer(q) ;			// Run the thread for producer 
		// new Consumer (q);
    */
            // TestSleepMethod1 t1 = new TestSleepMethod1();
            // TestSleepMethod1 t2 = new TestSleepMethod1();

            // t1.start();
            // t1.join();
            // t2.start();
            // Table obj = new Table();//only one object
            // MyThread12 t1 = new MyThread12(obj);
            // MyThread2 t2 = new MyThread2(obj);
            // t1.start();
            // t2.start(); 
            // Counter c=new Counter();
            // Mythread11 t1=new Mythread11(c);
            // Mythread21 t2=new Mythread21(c);
            // t1.start();
            // t2.start();
            // t1.join();
            // t2.join();
            // System.out.println("Count= "+c.count);

            Multithread t1 = new Multithread();
            t1.increment();
            t1.increment();
    }
}
