package f;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Checking>
{
    public int compare(Checking o1, Checking o2)
    {
        //(int) was the line changed to work with doubles
              return (int) (o1.Balance - o2.Balance);// this line gets changed between Strings and ints
   }


}
