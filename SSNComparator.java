package f;

import java.util.Comparator;

public class SSNComparator implements Comparator<Checking>
{
    public int compare(Checking o1, Checking o2)
    {
        //this line gets changed between strong and ints
              return o1.ssn - o2.ssn;
    }

}




