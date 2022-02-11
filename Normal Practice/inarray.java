import java.util.Scanner;
import java.util.*;

public class inarray {

    public static void changeString ( String str, int toChange, int whichChange )
    {
        char ch = str.charAt(toChange);
        // System.out.println(ch);
        // char check = (char)(whichChange+'a');
        // System.out.println(check);
        
        char[] newStringCharacter = str.toCharArray();

        for ( int i = 0 ; i < str.length(); i++ )
            if ( newStringCharacter[i] == ch )
                newStringCharacter[i] = (char) (whichChange+'a') ;

        System.out.println(Arrays.toString(newStringCharacter));
    }

    public static int numberOfConsonants ( String str )
    {
        int sum = 0 ;
        char[] newStringCharacter = str.toCharArray();

        for ( int i = 0 ; i < str.length(); i++ )
            if ( newStringCharacter[i] == 'a' || newStringCharacter[i] == 'e' ||  newStringCharacter[i] == 'i' || newStringCharacter[i] == 'o' || newStringCharacter[i] == 'u' )
                continue;
            else
                sum += 1 ;

        return sum ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(",");
        
        int m = sc.nextInt();
        int [][]matrix = new int[m][2] ; 

        for ( int i = 0 ; i < m ; i++ )
            for ( int j = 0 ; j < 2 ; j++ )
                matrix[i][j] = sc.nextInt();

        String outStr = "";
        int currentConsonants = 1000001;
        for ( int i = 0 ; i < m ; i++ )
        {
            changeString(arr[i], matrix[i][0], matrix[i][1] );

            int currentNumberOfConsonants = numberOfConsonants(arr[i]);
            if ( currentConsonants > currentNumberOfConsonants )
            {
                outStr = arr[i];
                currentConsonants = currentNumberOfConsonants;
            }
        }
        
        // changeString("appfe", 3, 11 );
        System.out.println(Arrays.toString((arr)));
        System.out.println(outStr);
        sc.close();
    }
}
