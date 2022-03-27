import java.util.*;

class ListingList {
    ArrayList < LinkedList < Integer > > ll = new ArrayList<LinkedList < Integer >>();

    ListingList ( int n ){
        ll = new ArrayList<LinkedList < Integer >>(n);

        for ( int i = 0 ; i < n ; i++ )
            ll.add(new LinkedList<Integer>());

    }
    
    void add ( int mthIndex, int element ){
       ll.get(mthIndex).add(element);
    }

    void addFront ( int mthIndex, int element ){
        ll.get(mthIndex).addFirst(element);
    }

    Integer delete ( int mthIndex, int kthElement ){
        LinkedList < Integer > res = ll.get(mthIndex);
        Integer val = res.get(kthElement);
        ll.get(mthIndex).remove(kthElement);
        return val ;
    }

    Integer diff ( int mthIndex, int m2thIndex ){
        LinkedList <Integer> m1 = ll.get(mthIndex);
        LinkedList <Integer> m2 = ll.get(m2thIndex);

        Integer ans = 0;

        HashMap < Integer, Integer > mp = new HashMap<Integer, Integer>();

        int count = 0;
        for ( int i = 0 ; i < m1.size(); i++ ){
            Integer element = m1.get(i);

            if ( mp.containsKey(element)){
                count++;
                mp.put(element, mp.get(element) + 1 );
            }
            else{
                mp.put(element, 1);
            }
        }
        
        // System.out.println(count);
        Integer old = count ;
        count = 0 ;

        mp = new HashMap<Integer, Integer>();
        for ( int i = 0 ; i < m2.size(); i++ ){
            Integer element = m2.get(i);

            if ( mp.containsKey(element)){
                mp.put(element, mp.get(element) + 1 );
                count++;
            }
            else{
                mp.put(element, 1);
            }
        }

        // System.out.println(count);
        ans = m1.size() + m2.size() - count - old;
        return ans;
    }

    void display(){
        System.out.println(ll);
    }
}

public class NLinks {
    public static void main(String[] args) {
        ListingList ll = new ListingList(3);

        ll.add(0, 1);
        ll.add(0, 2);
        ll.add(0, 3);

        ll.add(1, 4);
        ll.add(1, 5);
        ll.add(1, 6);

        ll.add(2, 6);
        ll.add(2, 6);
        ll.add(2, 6);
        ll.display();

        ll.addFront(0, 10);
        ll.addFront(1, 100);
        ll.display();
        
        ll.delete(0, 2);
        ll.display();

        System.out.println(ll.diff(0, 1));

    }
}

/**
 *      ll.add(1, 10);
        ll.add(1, 20);
        ll.add(2, 30);
        ll.add(2, 40);
        ll.add(3, 50);
        ll.add(3, 60);
        ll.add(4, 80);
        ll.add(4, 80);
        ll.add(4, 80);
 */
   