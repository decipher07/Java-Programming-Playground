import java.util.Scanner;

class OriginalNumberDetails {
    public int originalNumber ;

    OriginalNumberDetails (int number){
        this.originalNumber = number;
    }

    synchronized void setNumber (int number){
        System.out.println("********************Setting The Number Thread**************************" );
        System.out.println("Currently Executing the Thread : " + Thread.currentThread());
        
        this.originalNumber = number;
    }

    synchronized int getNumber (){
        System.out.println("Currently Executing the Thread : " + Thread.currentThread());
        return originalNumber;
    }

    synchronized void printOddNumbers (){
        System.out.println("Currently Executing the Thread : " + Thread.currentThread());
        System.out.println("********************Printing Odd Number Thread**************************" );

        for ( int i = 1 ; i <= originalNumber ; i+= 2 )
            System.out.println(i);
        }
        
        synchronized void printEvenNumbers (){
            System.out.println("Currently Executing the Thread : " + Thread.currentThread());
            System.out.println("********************Printing Even Number Thread**************************" );

        for ( int i = 2 ; i <= originalNumber ; i+= 2 )
            System.out.println(i);
    }

}

class EnterNumberThread extends Thread {
    OriginalNumberDetails obj;
    int numberToSet ;

    EnterNumberThread ( int number ){
        this.numberToSet = number;
    }

    public void run (){
        int number = this.numberToSet;
        obj = new OriginalNumberDetails(number);
        obj.setNumber(number);
    }
}

class OddNumberThread extends Thread {
    OriginalNumberDetails obj;
    int numberToSet ;


    OddNumberThread ( int number ){
        this.numberToSet = number;
    }

    public void run() {
        int number = this.numberToSet;
        this.obj = new OriginalNumberDetails(number);

        obj.printOddNumbers();
    }
}

class EvenNumberThread extends Thread {
    OriginalNumberDetails obj;
    int numberToSet ;


    EvenNumberThread ( int number ){
        this.numberToSet = number;
    }

    public void run() {
        int number = this.numberToSet;
        this.obj = new OriginalNumberDetails(number);

        obj.printEvenNumbers();
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter The Number : ");
        int number = input.nextInt();


        EnterNumberThread t1 = new EnterNumberThread(number);
        OddNumberThread t2 = new OddNumberThread(number);
        EvenNumberThread t3 = new EvenNumberThread(number);

        t1.start();
        t2.start();
        t3.start();

        input.close();
    }
}