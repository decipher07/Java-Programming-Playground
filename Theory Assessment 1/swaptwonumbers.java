import java.util.Scanner;

/**
 * swaptwonumbers
 */
public class swaptwonumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int firstNumber, secondNumber ;
        System.out.print("Please Enter First Number : ");
        firstNumber = input.nextInt();
        
        System.out.print("Please Enter Second Number : ");
        secondNumber = input.nextInt();

        System.out.println("The FirstNumber is : " + firstNumber + " The Second Number is : " + secondNumber );

        firstNumber = firstNumber + secondNumber ; // x + y --> x
        secondNumber = firstNumber - secondNumber ; // ( x + y ) - y 
        firstNumber = firstNumber - secondNumber ; // ( x + y ) - x 

        System.out.println("The FirstNumber is : " + firstNumber + " The Second Number is : " + secondNumber );

        input.close();
    }
}