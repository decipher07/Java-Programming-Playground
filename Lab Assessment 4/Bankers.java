import java.util.Scanner;

class Bank {
    int balance;
    String name;
        
    Bank( int currentAmount, String nameOfTheUser ){
            balance = currentAmount ;
            name = nameOfTheUser;
    }

    synchronized public void addMoney(int amount){
        System.out.println("\n********************Depositing Money Thread**************************" );
        System.out.println("\nCurrently Executing the Thread : " + Thread.currentThread());
        balance += amount;
    }

    synchronized public void withDrawMoney ( int amount ){
        System.out.println("\n********************Withdrawal Money Thread**************************" );
        System.out.println("\nCurrently Executing the Thread : " + Thread.currentThread());
        
        try {
            if ( balance < amount ){
                throw new Exception ("Sorry, You dont have enough Balance");
            }

            balance -= amount;
            System.out.println("\nThe Withdrawal is successful, Thank You For Using Deepankar's Bank, The Left Bank Balance is: " + balance );

        } catch (Exception e){
            System.out.println(e);
        }
    }

    synchronized public void getDetailsOfTheBalance (){
        System.out.println("\n********************Get Status Money Thread**************************\n" );
        System.out.println("Currently Executing the Thread : " + Thread.currentThread());
        System.out.println();
        System.out.println("\nYour Account Details are as follws: ");
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}


class Customer extends Thread {
    Bank obj;
    Customer( int balance, String name ){
        obj = new Bank(balance, name);
    }

    public void run(){
        synchronized(obj){
            char ch = 'y';
            Scanner sc = new Scanner(System.in);
            while ( ch == 'y' ){
                System.out.println("The Current Execution is : " + obj.name);
                System.out.print("\nPlease Answer \n1. Deposit, \n2. Withdrawal\n3. Details\n");
                int response = sc.nextInt();

                if ( response == 1 ){
                    System.out.print("Please Enter the amount to be deposited: ");
                    int tellAmount = sc.nextInt();
                    obj.addMoney(tellAmount);
                }
                else if ( response == 2 ){
                    System.out.print("Please Enter the amount to be Withdrawal: ");
                    int tellAmount = sc.nextInt();
                    obj.withDrawMoney(tellAmount);
                }
                else if ( response == 3 ){
                    obj.getDetailsOfTheBalance();
                }

                System.out.print("\nDo You want to continue? Press (Y/N): ");
                ch = sc.next().charAt(0);
                System.out.println();
            }
        }
    }
}

public class Bankers {
    public static void main(String[] args) {
        Customer cust1 = new Customer(1000, "Deepankar Jain");
        Customer cust2 = new Customer(1000, "Radhe Radhe");
        cust1.start();
        
        try {
            cust1.join();
            cust2.start();
            cust2.join();
        } catch (Exception e){
            System.out.print("Threads Error!");
        }

    }
}
