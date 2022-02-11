import java.util.Scanner;

class Account 
{
    private int accountNumber ;
    private float accountBalance ;

    Account ()
    {
        accountBalance = 100;
        accountNumber = 6542;
    }

    public void performOperations ( char type, float transactionAmount )
    {
        if ( type == 'D' )
            this.accountBalance += transactionAmount ;
        
        else if ( type == 'W' )
            if ( this.accountBalance - transactionAmount >= 0)
                this.accountBalance -= transactionAmount;
            else{
                System.out.println("In-sufficient Fund");
                System.exit(-1);
            }
    }

    public String print ()
    {
        String str = "The Current Balance of the Account No. " + this.accountNumber + " is : " + this.accountBalance ;
        return str;
    }
}


public class Bank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account acc = new Account();

        System.out.println("The Initial Balance is " + acc.print());

        while (true)
        {
            System.out.print("Please Enter the Mode of Transaction (W/D):");
            char mode = input.next().charAt(0);
            
            if ( mode != 'D' && mode != 'W' )
            {
                System.out.println("Sorry, Please Enter a Valid Input");
                input.close();
                System.exit(-1);
            }
            
            System.out.print("Please Enter the Amount of Transaction ");
            float amount = input.nextFloat();
            acc.performOperations(mode, amount);
    
            System.out.println("The Balance after Deposit of " + amount + " is " + acc.print());
            
            
            
            System.out.print("Please Enter the Mode of Transaction (W/D):");
            mode = input.next().charAt(0);
            
            if ( mode != 'D' && mode != 'W' )
            {
                System.out.println("Sorry, Please Enter a Valid Input");
                input.close();
                System.exit(-1);
            }
            
            System.out.print("Please Enter the Amount of Transaction ");
            amount = input.nextFloat();
    
            acc.performOperations(mode, amount);
            System.out.println("The Balance after Withdrawl of " + amount + " is " + acc.print());
        }
        
        
    }
}
