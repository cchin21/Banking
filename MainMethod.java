package f;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMethod {
    static ArrayList<Checking> cList = new ArrayList<Checking>();
    static ArrayList<Savings> sList = new ArrayList<Savings>();
    static Checking cAccount = new Checking(null, null, 0, 0);
    static Savings sAccount = new Savings(null, null, 0, 0);
    static Scanner input = new Scanner(System.in);
    static int counter = 3;
    static Timer timer;
    static int day = counter * 1000;
    static int intTest = 0;
    static String accountChoice;
    
    public static void main(String [ ] args) { 	
        Thread k = new Thread(new Runnable() {

            @Override
            public void run() {
                sAccount = new Savings("", "", 0, 0);
                sList.add(sAccount);
                day = counter * 1000;
                int interest = 2;
                while (true) {
                    for (int i = 0; i < sList.size(); i++) {
                        double x = sList.get(i).getBalance();
                        double newBalance = x * interest;
                        sList.get(i).setBalance(newBalance);
                        if (i <= sList.size()) {
                            try {
//                                System.out.println(sList.get(i));
                                Thread.sleep(day);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        });

        // create timer task to increment counter
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                // System.out.println("TimerTask executing counter is: " + counter);
                counter--;
            }
        };

        // create thread to print counter value
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
//                        System.out.println("Thread reading counter is: " + counter);
                        if (counter == 0) {
                            counter = 3;
                            day++;
                            // Restart Timer
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        timer = new Timer("MyTimer");// create a new timer
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        t.start();// start thread to display counter
        k.start();
//-------------------------------------------------------------------------------------
        Checking cAccount1 = new Checking("Bobby", "B", 2, 0);
        cList.add(cAccount1);
        Checking cAccount0 = new Checking("Alan", "A", 1, 0);
         cList.add(cAccount0);
         Savings sAccount1 = new Savings("Daryl", "D", 4, 0);
         sList.add(sAccount1);
         Savings sAccount0 = new Savings("Cary", "C", 3, 0);
         sList.add(sAccount0);
    	 
        String choice;

        while (true) {

            // Bank Teller Choices
                System.out.println("What would you like to do?");
                System.out.println("1) Sort");
                System.out.println("2) Create a Brand New Account");
                System.out.println("3) Deposit");
                System.out.println("4) Withdraw");
                System.out.println("0) Exit");
                choice =  input.next().trim();
                char ch= choice.charAt(0);
                choice=Character.toString(ch);
                
                String stringChoice = returnIntegerValue(choice);
                int newChoice = Integer.parseInt(stringChoice);
                
            switch (newChoice) {
            case 1:

                // Sorting the items
            

                System.out.println("How would you like to sort the items?");
                System.out.println("1) Name");
                System.out.println("2) Address");
                System.out.println("3) SSN");
                System.out.println("4) Balance");
                
                String sortChoice = input.next().trim();
                char ch1= sortChoice.charAt(0);
                sortChoice=Character.toString(ch);
               String stringSortChoice = returnIntegerValue(sortChoice);
                int intSortChoice = Integer.parseInt(stringSortChoice);

                Sorting sort = new Sorting(cList, intSortChoice);
               // SavingSort sortS = new SavingSort(sList, intSortChoice);
                for (int i = 0; i < cList.size(); i++) {
                    System.out.println(cList.get(i).toString());
                }
                for (int i = 0; i < sList.size(); i++) {
                    System.out.println(sList.get(i).toString());
                }
                break;

            case 2:
				// Creating a new Account

				String name, address;
				String ssn = "";
				String deposit;
				System.out.println("Creating a brand new account");
				System.out.println("What type of account are you creating? ");
				System.out.println("1) Savings Account ");
				System.out.println("2) Checking Account ");

				accountChoice = input.next();
				String intAccount = returnIntegerValue(accountChoice);
				int intAccountChoice = Integer.parseInt(intAccount);

				// These inputs get put into the classes and built

				System.out.print("Enter name: \n");
				name = input.next();
				System.out.print("Enter address: \n");
				address = input.next();
				System.out.print("Enter SSN: \n");
				ssn = input.next();
				String intSSN = returnIntegerValue(ssn);
				int newSSN = Integer.parseInt(intSSN);
				System.out.print("Enter initial deposit(if any): \n");
				deposit = input.next();
				String stringDeposit = returnDoubleValue(deposit);
				double newDeposit = Double.parseDouble(stringDeposit);

				// The data is added

				if (intAccountChoice == 1) {
					// Creates a savings account					
					sAccount = new Savings(name, address, newSSN, newDeposit);
					sList.add(sAccount);
				} else if (intAccountChoice == 2) {
					// Creates a checking account
					cAccount = new Checking(name, address, newSSN, newDeposit);
					cList.add(cAccount);
				}
				break;


            case 3:

                // Deposit
                System.out.println("Which account is the deposit to? ");
                System.out.println("1) Savings ");
                System.out.println("2) Checkings ");
                
                int place = 0;
                String placeChoice = input.next();
                String newPlace = returnIntegerValue(placeChoice);
                int newIntPlace = Integer.parseInt(newPlace);
                
                if (newIntPlace == 1) {
                    depositSavings(sList, place);
                } else if (newIntPlace == 2) {
                    depositCheckings(cList, place);
                }
                break;

            case 4:

                // Withdraw
                System.out.println("Which account is the withdraw from? ");
                System.out.println("1) Savings ");
                System.out.println("2) Checkings ");
                String withdrawChoice = input.next();
                String stringWithdrawChoice = returnIntegerValue(withdrawChoice);
                int intWithdrawChoice = Integer.parseInt(stringWithdrawChoice);
                
                int place2 = 0;
                if (intWithdrawChoice == 1) {
                    withdrawSavings(sList, place2);
                } else if (intWithdrawChoice == 2) {
                    withdrawCheckings(cList, place2);
                }
                break;
            case 0:
                System.exit(0);
            }
        }

    }

    // Deposit Method

    static void depositCheckings(ArrayList<Checking> cList, int place) {
        String depos;
        System.out.println("Enter SSN: ");
    
        String ssn = input.next();
        String stringSSN = returnIntegerValue(ssn);
        int intSSN = Integer.parseInt(stringSSN);
        
        for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).getSsn() == intSSN) {
                place = i;
                System.out.println("Deposit Amount ");
                
                depos = input.next();
                String stringDepos = returnDoubleValue(depos);
                double doubleDepos = Double.parseDouble(stringDepos);
                
                doubleDepos = doubleDepos + cList.get(place).getBalance();
                cList.get(place).setBalance(doubleDepos);
            }
        }
    }

    static void depositSavings(ArrayList<Savings> sList, int place) {
        String depos;
        System.out.println("Enter SSN: ");
        
        String ssn = input.next();
        String stringSSN = returnIntegerValue(ssn);
        int intSSN = Integer.parseInt(stringSSN);
        
        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i).getSsn() == intSSN) {
                place = i;
                System.out.println("Deposit Amount ");
                
                depos = input.next();
                String stringDepos = returnDoubleValue(depos);
                double doubleDepos = Double.parseDouble(stringDepos);
                
                doubleDepos = doubleDepos + sList.get(place).getBalance();
                sList.get(place).setBalance(doubleDepos);
            }
        }
    }

    // Withdraw Method

    static void withdrawCheckings(ArrayList<Checking> cList, int place) {
        String withdraw;
        System.out.println("Enter SSN: ");
        
        String ssn = input.next();
        String stringSSN = returnIntegerValue(ssn);
        int intSSN = Integer.parseInt(stringSSN);
        
        for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).getSsn() == intSSN) {
                place = i;
                System.out.println("Withdraw Amount ");
                
                withdraw = input.next();
                String stringWithdraw = returnDoubleValue(withdraw);
                double doubleWithdraw = Double.parseDouble(stringWithdraw);
                
                System.out.println(cList.get(place).getBalance());
                doubleWithdraw = cList.get(place).getBalance() - doubleWithdraw;
                if(doubleWithdraw < 0){
                    System.out.println("ERROR: You cannot withdraw that amount.");
                    System.out.println("The account currently has a balance of: $" + cList.get(place).getBalance() + "/t");
                    break;
                }
                cList.get(place).setBalance(doubleWithdraw);
            }
        }

    }

    static void withdrawSavings(ArrayList<Savings> sList, int place) {
        String withdraw;
        System.out.println("Enter SSN: ");
        
        String ssn = input.next();
        String stringSSN = returnIntegerValue(ssn);
        int intSSN = Integer.parseInt(stringSSN);
        
        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i).getSsn() == intSSN) {
                place = i;
                System.out.println("Withdraw Amount ");
            
                withdraw = input.next();
                String stringWithdraw = returnDoubleValue(withdraw);
                double doubleWithdraw = Double.parseDouble(stringWithdraw);
                
                System.out.println(sList.get(place).getBalance());
                doubleWithdraw = sList.get(place).getBalance() - doubleWithdraw;
                if(doubleWithdraw < 0){
                    System.out.println("ERROR: You cannot withdraw that amount.");
                    System.out.println("The account currently has a balance of: $" + cList.get(place).getBalance() + "/t");
                    break;
                }
                sList.get(place).setBalance(doubleWithdraw);
            }
        }

    }

    static String returnIntegerValue(String a) {
        String q = a;
        while (true) {
            try {
                Integer.parseInt(q);
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
                q = input.next();
                continue;
            }
            return q;
        }

    }
    static String returnDoubleValue(String a) {
        String q = a;
        
        while (true) {
            try {
                Double.parseDouble(q);
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
                q = input.next().trim();
                continue;
            }
            return q;
        }

    }
}
