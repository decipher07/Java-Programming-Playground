class Handler extends Thread {
    int classDetecter;

    Handler(int val) {
        this.classDetecter = val;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                System.out.println("Hey from " + this.classDetecter + " " + Thread.currentThread());
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class ImpRun implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread());
    }
}

public class HandlingFats {
    public static void main(String[] args) {
        // Handler hd = new Handler(5);
        // Handler hd2 = new Handler(10);
        // hd.start();
        // hd2.start();

        // Thread t1 = new Thread() {
        //     public void run() {
        //         Table.printTable(1);
        //     }
        // };

        // Thread t2 = new Thread() {
        //     public void run() {
        //         Table.printTable(10);
        //     }
        // };

        // Thread t3 = new Thread() {
        //     public void run() {
        //         Table.printTable(100);
        //     }
        // };

        // Thread t4 = new Thread() {
        //     public void run() {
        //         Table.printTable(1000);
        //     }
        // };
        // t1.start();
        // t2.start();
        // t3.start();
        // t4.start();

        // ImpRun pd = new ImpRun();
        // Thread td = new Thread(pd);
        // td.start();

        // Bike bm = new Honda();
        // bm.changeGear();
        A x = new A();
        x.print();
    }
}

abstract class Bike {
    Bike(){System.out.println("IKE");}
    abstract void run();
    void changeGear () {
        System.out.println("GEAR CHANGED!");
    }
}

class Honda extends Bike {
    void run () {
        System.out.println("Here!!");
    }
}

interface printable {
    static int mn=1;
    void print();
}

class A implements printable {
    public void print(){
        System.out.println("HEERE");
        System.out.printlnmn);
    }
}

class Table {

    synchronized static void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("N = " + n + " " + n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
            }
        }
    }
}

/**
  
 public class FirstServlet extends HttpServlet {
public void doPost(HttpServletRequest request,
HttpServletResponse response){
 try{
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();

 String n=request.getParameter("userName");
 out.print("Welcome "+n);

 Cookie ck=new Cookie("uname",n);//creating cookie object

 response.addCookie(ck);//adding cookie in the response

 //creating submit button
 out.print("<form action='servlet2'>");
 out.print("<input type='submit' value='go'>");
 out.print("</form>");

 out.close(); 




 
 
public class SecondServlet extends HttpServlet {

public void doPost(HttpServletRequest request,
HttpServletResponse response){
 try{

 response.setContentType("text/html");
 PrintWriter out = response.getWriter();

 Cookie ck[]=request.getCookies();
 out.print("Hello "+ck[0].getValue());

 out.close();

 }catch(Exception e){System.out.println(e);}
 }


} 
 */