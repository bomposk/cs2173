package cs2173.words;

import java.util.Comparator;

/**
 * This comparator can be used to sort Strings alphabetically, rather than
 * lexicographically, which is String's default.
 *
 * @author ahbuss
 */
public class AlphabeticalComparator implements Comparator<String> {

    /**
     * First compare ignoring case. If that comes up equal (i.e. 0), then use
     * the String's default compareTo to determine the order. Note that
     * compareTo will put upper case before lower case. If the opposite is
     * desired, simply negate the call to compareTo.
     *
     * @param o1 First String
     * @param o2 Second String
     * @return negative, 0, or positive based on alphabetic order
     */
    @Override
    public int compare(String o1, String o2) {
        int compare;
        compare = o1.compareToIgnoreCase(o2);
        if (compare == 0) {
            compare = o1.compareTo(o2);
        }

        return compare;
    }

}
