class Product 
{
    public String listing;
    protected int productId;
    private String personAdmin;

    Product ( String currentStore, int productId, String personAdmin )
    {
        this.listing = currentStore ;
        this.productId = productId;
        this.personAdmin = personAdmin;
    }

    void displayDetailsOfTheGivenProduct ()
    {
        System.out.println("The Current Product is available in " + listing );
        System.out.println("The Current Product ID is " + productId );
        System.out.println("The Admin is " + personAdmin );
    }
}

class Book extends Product 
{
    public int price ;
    public int quantity ;
    public String nameOfTheBook;

    Book ()
    {
        super("WholeSale", 1234, "Deepankar Arun Jain");
    }

    Book ( int priceOfTheBook, int quantityOfTheBook, String currentListing, int productId, String nameOfTheBook, String personAdmin )
    {
        super(currentListing, productId, personAdmin);
        this.price = priceOfTheBook;
        this.quantity = quantityOfTheBook;
        this.nameOfTheBook = nameOfTheBook ;
    }

    public void buyBook ( )
    {
        System.out.println("\n\nYOU ARE BUYING THE BOOK. THE DETAILS OF THE BOOK ARE AS FOLLOWS :");


        this.quantity -= 1 ;
        System.out.println("You have successfully bought the book : " + nameOfTheBook + " for : " + price);
        System.out.println("The Quantity of the Books left : " + quantity);
        System.out.println("The Product Id is : " + productId );
    }

    public void getDetailsOfTheBook()
    {
        System.out.println("\n\nTHE DETAILS OF THE BOOK ARE AS FOLLOWS :");

        System.out.println("Book Name : " + nameOfTheBook );
        System.out.println("Quantity Left:  " + quantity );
        System.out.println("Price : " + price );
        System.out.println("Product Id : " + productId );
        System.out.println("Listing : " + listing );
    }
}

class CD extends Product 
{
    private int authorId ;
    public int lengthOfPlay ;
    private String nameOfTheCD;

    CD ( int authorId, int lengthOfPlay, String nameOfTheCD,  String currentListing, int productId, String personAdmin )
    {
        super ( currentListing, productId, personAdmin );
        this.authorId = authorId ;
        this.lengthOfPlay = lengthOfPlay ;
        this.nameOfTheCD = nameOfTheCD ;
    }
    
    public void getDetailsOfTheCD()
    {
        System.out.println("\n\nTHE DETAILS OF THE CD ARE AS FOLLOWS :");

        System.out.println("Author ID : " + authorId );
        System.out.println("Length of Play : " + lengthOfPlay );
        System.out.println("Name : " + nameOfTheCD );
        System.out.println("Product Id : " + productId );
        System.out.println("Listing : " + listing );
    }
}

class Scientific extends Book 
{
    private String subjectUnderScience;
    private int numberOfPages;

    Scientific(String subjectUnderScience, int numberOfPages, int priceOfTheBook, int quantityOfTheBook, String currentListing, int productId, String nameOfTheBook )
    {
        super(priceOfTheBook, quantityOfTheBook, currentListing, productId, nameOfTheBook, "Alex Ferguson");
        this.subjectUnderScience = subjectUnderScience;
        this.numberOfPages = numberOfPages;
    }

    public void getScienceBook ()
    {
        System.out.println("\n\nTHE DETAILS OF THE SCIENCE BOOK ARE AS FOLLOWS :");

        System.out.println("The Book name is " + nameOfTheBook + ". It is a " + subjectUnderScience + " Book. It has " + numberOfPages );
        System.out.println("Quantity left : " + quantity );
        System.out.println("Available at : " + listing );
    }
}


public class Library {
    public static void main(String[] args) {
        
        Product P = new Book (50, 10, "Retail", 1, "The New Era", "Deepankar Arun Jain");
        Scientific ScienceBook = new Scientific("Chemistry", 1000, 80, 19, "Whole Sale", 2, "The History of Science");
        CD VITSpeaksDVD = new CD (101, 100, "VIT Speaks", "Retail", 3, "Deepu");
        Book normalBook = new Book(100, 8, "Retail", 4, "Secrets of the World", "Deepankar");

        
        // Product
        P.displayDetailsOfTheGivenProduct();
        System.out.println("**********************************************************************");
        
        System.out.println("**********************************************************************");
        // Normal Book
        normalBook.getDetailsOfTheBook();
        normalBook.buyBook();
        normalBook.displayDetailsOfTheGivenProduct();
        normalBook.getDetailsOfTheBook();
        System.out.println("**********************************************************************");
        
        
        System.out.println("**********************************************************************");
        // DVD
        VITSpeaksDVD.displayDetailsOfTheGivenProduct();
        VITSpeaksDVD.getDetailsOfTheCD();
        System.out.println("**********************************************************************");
        
        
        System.out.println("**********************************************************************");
        // Science Book
        ScienceBook.getScienceBook();
        ScienceBook.buyBook();        
    }
}
