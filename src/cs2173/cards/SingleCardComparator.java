package cs2173.cards;

import java.util.Comparator;

/**
 * This is an example of how to write a Comparator for instances of a class that
 * doesn't implement the Comparable interface. The rule is to sort first by suit
 * and then by value.
 *
 * @author ahbuss
 */
public class SingleCardComparator implements Comparator<SingleCard> {

    /**
     * <p>
     * The suit order is: CLUBS, DIAMONDS, HEARTS, SPADES
     * <p>
     * The value order is increasing, with Ace being the lowest
     *
     * @param o1 First SingleCard
     * @param o2 Second SingleCard
     * @return negative, positive, or 0 based on suit first then value
     */
    @Override
    public int compare(SingleCard o1, SingleCard o2) {
        int compare;
        
//        Sorted by Suit and then by value
//        Start by comparing suits. Note that all enums implement Comparable
//        compare = o1.getSuit().compareTo(o2.getSuit());
//        If the suits are the same, compare by value
//        if (compare == 0) {
//            compare = o1.getValue() - o2.getValue();
//        }
        
        
//        Sorted by value and then by suit
        compare = o1.getValue() - o2.getValue();
        if (compare == 0){
            compare = o1.getSuit().compareTo(o2.getSuit());
        }
        
        return compare;
    }

}
