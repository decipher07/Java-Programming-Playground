interface Bank {
    float roi();
    void show();
}

class Customer {
    protected String customerName;
    protected int customerId;

    Customer ( String name, int Id ){
        this.customerName = name;
        this.customerId = Id;
    }

    public void display (){
        System.out.println("Customer Name = " + customerName);
        System.out.println("Customer Id = " + customerId);
    }
}

class Account extends Customer implements Bank {

    private int accountNumber;
    private float accountBalance;
    private int time;

    Account (String name, int Id, int accountNumber, float accountBalance, int time ){
        super(name, Id);
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.time = time;
    }

    public float roi () {
        return 12.00f;
    }

    public float interest(){
        float answer = (float)((accountBalance * roi() * time)/100);
        return answer;
    }

    public void show(){
        System.out.println("Customer Name = " + customerName);
        System.out.println("Customer Id = " + customerId);
        System.out.println("Account no = " + accountNumber);
        System.out.println("Account Balance = " + accountBalance);
        System.out.println("Interest = " + interest());
    }

}

public class BankAccounts {
    public static void main(String[] args) {
        Account acc = new Account("XYZ", 12345678, 9876543, 5000.0f, 3);
        acc.show();        
    }
}
