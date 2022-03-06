import java.util.Scanner;

class OriginalDetails {
    int originalNumber;

    OriginalDetails ( int number ){
        this.originalNumber = number;
    }

    synchronized void outputEvenNumber(){
        System.out.println("Currently Executing the Thread : " + Thread.currentThread());
        System.out.println("********************Printing Even Number Thread**************************" );

        for ( int i = 2 ; i <= originalNumber ; i+= 2 )
            System.out.println(i);
    }

    synchronized void outputOddNumber(){
        System.out.println("Currently Executing the Thread : " + Thread.currentThread());
        System.out.println("********************Printing Odd Number Thread**************************" );

        for ( int i = 1 ; i <= originalNumber ; i+= 2 )
            System.out.println(i);
    
    }
}

class OddNumberThread extends Thread {
    OriginalDetails obj;
    int numberToSet ;


    OddNumberThread ( int number ){
        this.numberToSet = number;
    }

    public void run() {
        int number = this.numberToSet;
        this.obj = new OriginalDetails(number);

        obj.outputOddNumber();
    }
}


class EvenNumberThread extends Thread {
    OriginalDetails obj;
    int numberToSet ;


    EvenNumberThread ( int number ){
        this.numberToSet = number;
    }

    public void run() {
        int number = this.numberToSet;
        this.obj = new OriginalDetails(number);

        obj.outputEvenNumber();
    }
}

public class OddAndEvenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter The Number : ");
        int number = input.nextInt();

        OddNumberThread t1 = new OddNumberThread(number);
        EvenNumberThread t2 = new EvenNumberThread(number);

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        } catch ( Exception e ){
            System.out.println(e);
        }

        input.close();
    }
}
