package f;

import java.util.Comparator;
import java.util.Scanner;

public class Checking {
    public static final String SSN = null;
    public double amount;
    static Scanner input= new Scanner(System.in);

    public String Name;
    public String Address;
    public int ssn;
    public double Balance;
    
    public Checking(String name, String address, int ssn, double balance) {
        super();
        Name = name;
        Address = address;
        this.ssn = ssn;
        Balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "Account Name=" + Name + ", Address=" + Address + ", ssn=" + ssn + ", Balance="
                + Balance;
    }
    


}
