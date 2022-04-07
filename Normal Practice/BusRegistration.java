class BusTicket {
    String busName;
    int seats;
    boolean isAvailable ;

    BusTicket ( String busName, int seats ){
        this.busName = busName;
        this.seats = seats;
        this.isAvailable = false;
    }

    synchronized void registerSeat (){
        if ( !isAvailable ){
            try {
                System.out.println("Waiting for the Seats to be released. Your Process is still in the queue!" + Thread.currentThread());
                wait();
            } catch ( InterruptedException e ){
                System.out.println(e);
            }
        }
        
        // Deducting the seats from the bus registrations
        this.seats--;
        isAvailable = true;
        System.out.println("You have successfully registered a seat here!" + Thread.currentThread());
        notifyAll();

    }

    synchronized void allotSeat ( int numberOfSeats ){
        if ( isAvailable ){
            try {
                System.out.println("Waiting for the Seats to be deducted. Your Process is still in the queue!" + Thread.currentThread());
                wait();
            } catch ( InterruptedException e ){
                System.out.println(e);
            }
        }
        
        isAvailable = false;
        this.seats += numberOfSeats;
        System.out.println("Successfully Added the Seats!");
        notifyAll();
    }

    synchronized void displaySeats (){
        if ( !isAvailable ){
            try {
                System.out.println("Waiting for the Seats to be released. Your Process is still in the queue!" + Thread.currentThread());
                wait();
            } catch ( InterruptedException e ){
                System.out.println(e);
            }
        }

        System.out.println("The Total Number of seats is : " + seats);
        notifyAll();
    }
}

class Producer implements Runnable {
    
    BusTicket q;
    Producer ( BusTicket q ){
        this.q = q ;
        new Thread(this).start();
    }

    public void run () {
        q.allotSeat(60);
        // q.displaySeats();
    }
}

class Consumer implements Runnable {

    BusTicket q;
    Consumer ( BusTicket q ){
        this.q = q;
        new Thread(this).start();
    }

    public void run() {
        q.registerSeat();
        q.displaySeats();
    }
}

class Display implements Runnable {
    BusTicket q ;
    Display ( BusTicket q ){
        this.q = q;
        new Thread(this).start();
    }

    public void run() {
        q.displaySeats();
    } 
}

public class BusRegistration {
    public static void main(String[] args) {
        BusTicket q = new BusTicket("Red Bus", 0);
        
        new Display(q);
        new Consumer(q);
        new Consumer(q);
        new Producer(q);
    }
}
