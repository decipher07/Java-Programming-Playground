import java.util.Scanner;

public class NumberOfDaysInAMonth {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please Enter the Month Number : ");
        int monthNumber = input.nextInt();

        int days = 31 ;
        if ( monthNumber == 2 )
        {
            System.out.println("Februrary has 28 or 29 days in a Year depening if the year is a leap year or not");
            System.exit(-1);
        }
        else if ( monthNumber > 12 )
        {
            System.out.println("Please Enter a Valid Month Number");
            System.exit(-1);
        }else if ( monthNumber < 8 )
            days = monthNumber % 2 != 0 ? 31 : 30;
        else 
            days = monthNumber % 2 == 0 ? 31 : 30 ;
        
        System.out.println("The Number of Days are : " + days );
        input.close();
    }
}