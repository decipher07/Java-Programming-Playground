import java.util.Scanner;

/**
 * MakeEmail
 */
public class MakeEmail {
    public static void main(String[] args) 
    {
        Scanner takeInput = new Scanner(System.in);

        System.out.print("Please Enter Your First Name Followed By Last Name : ");
        String name = takeInput.nextLine().toLowerCase();

        System.out.print("Please Enter the Domain for your Email : ");
        String domain = takeInput.nextLine();

        String[] nameAndSurname = name.split(" ");
        int numberOfInitialsEntered = nameAndSurname.length;
        
        if ( numberOfInitialsEntered > 2 )
        {
            System.out.println("Sorry, Please Enter Your First Name and Last Name ");
            System.exit(-1);
        }
        int initialsToInclude = nameAndSurname[0].length() >= 3 ? 3 : nameAndSurname[0].length();
        int surnameCharacterToInclude = nameAndSurname[1].length() >= 4 ? 4 : nameAndSurname[1].length();

        String startingEmailAddress = nameAndSurname[0].substring(0, initialsToInclude);
        String surnameEmailAddress = nameAndSurname[1].substring(0, surnameCharacterToInclude);

        System.out.println(startingEmailAddress + '.' + surnameEmailAddress + '@' + domain + ".com");
        
        takeInput.close();
    }
}