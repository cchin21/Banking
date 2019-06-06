package f;

import java.util.Comparator;

public class AddressComparator implements Comparator<Checking>
{
    public int compare(Checking o1, Checking o2)
    {
        return o1.getAddress().compareTo(o2.getAddress());
    }

}
