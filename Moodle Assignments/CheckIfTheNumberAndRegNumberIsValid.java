import java.util.Scanner;

public class CheckIfTheNumberAndRegNumberIsValid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please Enter your Phone Number : ");
        String phoneNumber = input.nextLine();
        System.out.print("Please Enter your Reg Number : ");
        String registerNumber = input.nextLine();

        int lengthOfPhoneNumber = phoneNumber.length();
        int lengthRegisterNumber = registerNumber.length();

        if ( lengthOfPhoneNumber != 10 || lengthRegisterNumber != 9 )
        {
            System.out.println("Please Enter the correct Format");
            System.exit(-1);
        }

        char[] phoneNumberConvertedCharacter = phoneNumber.toCharArray();
        char[] registerNumberConvertedCharacter = registerNumber.toCharArray();
        
        for ( int i = 0 ; i < lengthOfPhoneNumber ; i++ )
        {
            if ( !Character.isDigit(phoneNumberConvertedCharacter[i]))
            {
                System.out.println("Please Enter a valid phone Number");
                System.exit(-1);
            }
        }
        
        for ( int i = 0 ; i < lengthRegisterNumber; i++ )
        {
            if ( !Character.isDigit(registerNumberConvertedCharacter[i]) && !Character.isAlphabetic(registerNumberConvertedCharacter[i]))
            {
                System.out.println("Please Enter a valid phone Number");
                System.exit(-1);
            }
        }

        System.out.println("This is a valid input.");

        input.close();
    }
}
