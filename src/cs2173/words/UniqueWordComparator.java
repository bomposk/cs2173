package cs2173.words;

import java.util.Comparator;

/**
 * This comparator can be used to sort Strings alphabetically, rather than
 * lexicographically, which is String's default. 
 * Moreover, it ignores case, so if 2 words are the same, we only keep one of 
 * them because we want our final result to contain unique words. 
 *
 * @author Konstantinos Bompos
 * Date: 02/21/2020
 */
public class UniqueWordComparator implements Comparator<String> {

    /**
     * It compares by ignoring case.
     *
     * @param o1 First String
     * @param o2 Second String
     * @return negative, 0, or positive based on alphabetic order ignoring the 
     *          case
     */
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }

}//class
