import java.util.Scanner;

public class FloydTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter The Number : ");
        int n = input.nextInt();

        int counter = 2;
        for ( int i = 1 ; i <= n ; i++ )
        {
            for ( int j = 1 ; j <= i ; j++, counter += 2 )
                System.out.print(counter + " ");

            System.out.println();
        }

        input.close();
    }
}
