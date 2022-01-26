import java.util.Arrays;

public class AlphabeticalCommandLineInputs {

    public static void main(String[] args) {
        
        int totalInputEnters = args.length;

        if ( totalInputEnters != 3 )
        {
            System.out.println("Please Enter Only 3 Arguments!");
            System.exit(-1);
        }

        Arrays.sort(args);
        System.out.println(Arrays.toString(args));
    }
}