import java.util.ArrayList;
import java.util.HashMap;

public class OccurenceString {
    public static void main(String[] args) {
        String name = "Die with memories";

        // ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        int n = name.length();
// Without Hashmap
        for ( int i = 0 ; i < n ; i++ ){
            
            char guess = name.charAt(i);
            if ( guess == ' ' || guess == '$')
                continue;
            System.out.print(guess + " -> ");
            int index = name.indexOf(guess);
            while (index >= 0) {
                System.out.print(index + ", ");
                index = name.indexOf(guess, index + 1);
            }
            String change = Character.toString(guess);
            name = name.replace( change, "$");
            System.out.println();
        }

        name = "Die with memories";
        HashMap < Character, ArrayList<Integer> > mp = new HashMap<Character, ArrayList<Integer>>();

        for ( int i = 0 ; i <n ; i++ )
        {
            char guess = name.charAt(i);
            if ( guess == ' ' || guess == '$')
                continue;

            if ( mp.get(guess) == null )
            {
                mp.put(guess, new ArrayList<Integer>());
            }

            mp.get(guess).add(i);
        }

        for ( Character element : mp.keySet()){
            ArrayList<Integer> ans = mp.get(element);

            System.out.println(element + " " + ans);
        }



    }
}
