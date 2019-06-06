package f;

import java.util.Comparator;

public class NameComparator implements Comparator<Checking>
{
    public int compare(Checking o1, Checking o2)
    {
       return o1.getName().compareTo(o2.getName());
   }
}
