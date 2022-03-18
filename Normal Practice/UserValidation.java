import java.util.Scanner;

public class UserValidation {

    static boolean checkAdjacentCharacters ( String password, String username ){

        int i = 0;
        int j = 2;
        int n = password.length();

        while ( j < n ){
            String subs = password.substring(i, j);

            if ( username.contains(subs))
                return true;
            i++;
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input from the user ;
        String username = sc.nextLine();
        String password = sc.nextLine();
        String confirmPassword = sc.nextLine();

        try {

            if ( username.length() < 8 || password.length() < 8 ){
                sc.close();
                throw new Error("Invalid Username Length or Invalid Password Length of the User");
            }
            
            if ( username.contains(" ") || password.contains(" ")){
                sc.close();
                throw new Error("Username or Password should not contain spaces");
            }
            
            if ( !confirmPassword.equals(password) ){
                sc.close();
                throw new Error("Confirmed Password and Given Password do not match");
            }

            if ( checkAdjacentCharacters(password, username)){
                sc.close();
                throw new Error("Somepart of your username is in your password");
            }

            System.out.println("Everything seems fine....");

        } catch ( Exception e ){
            System.out.println(e);
        }
        
        
        sc.close();
    }
}
