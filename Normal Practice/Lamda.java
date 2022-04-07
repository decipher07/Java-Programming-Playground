interface Drawable {
    public int draw(String name);
    // public void change();
}

interface Sayable {
    public String say ( String name );
}

interface Addable {
    int add (int a, int b );
}

public class Lamda {
    public static void main(String[] args) {

        Drawable d = (String x) -> {
            System.out.println("hellow");
            return -1;
        };

        d.draw("asdfaFs");

        // Stack < String > st = new Stack<>();
        // st.push("Geeks");
        // st.push("Geeasdfasdfks");
        // st.push("Geekfasdf");
        // st.push("Gsafasdfasfdeeks");

        // Iterator <String> itr = st.iterator();

        // while ( itr.hasNext())
        //     System.out.print( itr.next() + " " );

        // st.pop();

        // Iterator < String > itr1 = st.iterator();

        // while ( itr1.hasNext() )
        //     System.out.print( itr1.next() + " ");

        // LinkedList < Integer > ll = new LinkedList<>();
        // for ( int i = 1 ; i < 5; i++ )
        //     ll.add(i);

        // System.out.println(ll);
        
        // ll.remove(2);
        // System.out.println(ll);

        // for ( int i = 1 ; i < ll.size() ; i++ )
            // System.out.println(ll.get(i));

        // ArrayList < String > animals = new ArrayList<>();
        // animals.add("Animals");
        // animals.add("Anls");
        // animals.add("imals");

        // System.out.println(animals);

        // ArrayList <Integer> al = new ArrayList<Integer>();
        // for ( int i = 1 ; i < 5 ; i++ )
        //     al.add(i);

        // System.out.println(al);
        
        // al.remove(2);
        
        // System.out.println(al);


        // int arr[] = new int[] {1, 2, 3, 4};

        // Vector <Integer> v = new Vector<>();
        // Hashtable < Integer, String > h = new  Hashtable<>();

        // v.add(1);
        // v.add(2);
        // v.add(3);
        // v.add(4);

        // h.put(1, "Args");
        // h.put(2, "Jeno");

        // System.out.println( arr[0] );

        // System.out.println(v.elementAt(0));

        // System.out.println(h.get(1));


        // Addable ab1 = ( a, b ) -> {

        //     return a + b;
        // };

        // Addable ab1 = ( a, b ) -> ( a + b );

        // System.out.println(ab1.add(2, 4 ));

        // Sayable s = (name) -> {
        //     return name;
        // };
        
        // System.out.println(s.say("ALJA"));
        
        // Sayable s = () -> {
        //     return "I have something to say";
        // };

        // System.out.println(s.say());
        
        // int width = 10 ;

        // Drawable d = () -> {
        //     System.out.println("Draw: " + width );
        // };

        // d.draw();

        // Drawable d = new Drawable() {
        //     public void draw(){
        //         System.out.println("Drawing " + width );
        //     }
        // };

        // d.draw();
    }
}
