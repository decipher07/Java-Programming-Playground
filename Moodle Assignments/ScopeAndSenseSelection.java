import java.util.Scanner;

public class ScopeAndSenseSelection {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        String[] arr = new String[5];
    
        System.out.println("Please Enter Any 5 Registrations of your choice!");
        for ( int i = 0 ; i < 5 ; i++ )
        {
            System.out.print("Please Enter the Reg Number for " + (i + 1) + " Student! : ");
            arr[i] = input.nextLine();

            if ( arr[i].length() == 0 )
            {
                System.out.println("Sorry, There are no Students from SCOPE and SENSE School");
                System.exit(-1);
            }
        }

        for ( String regNumber : arr )
        {
            String theStudentSchoolCode = regNumber.substring(2, 5);
            
            if ( theStudentSchoolCode.compareToIgnoreCase("BCE") == 0 )
                System.out.println("The Given Student with Reg Number : " + regNumber + " is from the School of SCOPE");
            else if ( theStudentSchoolCode.compareToIgnoreCase("BEC") == 0)
                System.out.println("The Given Student with Reg Number : " + regNumber + " is from the School of SENSE");
            else
                System.out.println("The Given Student with Reg Number : " + regNumber + " is Neither from the School of SENSE nor from the School of SCOPE");
        }

        input.close();
    }
}
