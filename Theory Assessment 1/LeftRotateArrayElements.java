import java.util.Arrays;

/**
 * LeftRotateArrayElements
 */
public class LeftRotateArrayElements {

    public static void main(String[] args) {
        int[] arr = { 11, 12, 13, 14, 15, 16 };
        
        for ( int i = 0 ; i < 4 ; i++ )
        {
            int store = arr[0];

            for ( int j = 0 ; j < 5 ; j++ )
            {
                arr[j] = arr[j+1];
            }

            arr[5] = store ;
        }

        System.out.println(Arrays.toString(arr));
    }
}