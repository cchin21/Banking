package f;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {

    public Sorting(ArrayList<Checking> list, int sortChoice) {
        if (sortChoice == 1) {
            Collections.sort(list, new NameComparator());
        }
        if (sortChoice == 2) {
            Collections.sort(list, new AddressComparator());
        }
        if (sortChoice == 3) {
            Collections.sort(list, new SSNComparator());
        }
        if (sortChoice == 4) {
            Collections.sort(list, new BalanceComparator());
        }
    }
}
