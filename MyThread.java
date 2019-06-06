package f;

import java.util.ArrayList;

public class MyThread implements Runnable  (ArrayList<Savings> sList); {
	public void run() {
		 int interest = 2;
		 for(int i=0;i<sList.size(); i++) {
               double x=sList.get(i).getBalance();
               double newBalance = x * interest;
   
                      sList.get(i).setBalance(newBalance);
                  }
	}
}