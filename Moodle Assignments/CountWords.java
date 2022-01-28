import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the Scentence (With Atleast 3 Characters) : ");
        String textDataEntered = input.nextLine();

        int lengthOfTextDataEntered = textDataEntered.length();
        
        if ( lengthOfTextDataEntered < 3 )
        {
            System.out.println("Please Enter Atleast 3 Characters");
            System.exit(-1);
        }

        String wordToBeCompared = "VIT";
        int nextSubstringIndex = wordToBeCompared.length();
        int counterForStoringCount = 0 ;

        for ( int i = 0 ; i < lengthOfTextDataEntered - 3 ; i++ )
        {
            String wordFormedFromTheNextNCharacter = textDataEntered.substring(i, i + nextSubstringIndex);
            if ( wordFormedFromTheNextNCharacter.compareToIgnoreCase(wordToBeCompared) == 0 )
                counterForStoringCount++;
        }

        if (counterForStoringCount == 0)
            System.out.println("Sorry, The Input Doesnt have the Word VIT in it.");
        else
            System.out.println("The Total Number of Counters are : " + counterForStoringCount );       

        input.close();
    }
}
