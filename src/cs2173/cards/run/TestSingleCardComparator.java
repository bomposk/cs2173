package cs2173.cards.run;

import cs2173.cards.CardDeck;
import cs2173.cards.SingleCard;
import cs2173.cards.SingleCardComparator;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Tests the SingleCardComparator by creating an array of SingleCards, shuffling
 * them (using an instance of CardDeck), and finally storing them in order in a
 * TreeSet.
 * 
 * @author Konstantinos Bompos
 */
public class TestSingleCardComparator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Instantiate a CardDeck for convenience (& "laziness") and shuffle
        CardDeck cardDeck = new CardDeck();
        cardDeck.shuffleDeck();
        System.out.println("After Shuffle:\n=================");
        System.out.println(cardDeck);
        
//        Put the cards in a List for inclusion in the TreeSet
        SingleCard[] cards = cardDeck.getMyCards();
        List<SingleCard> cardsList = Arrays.asList(cards);
        System.out.println("\nSame as List now:\n=================");
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);            
        }
        
//        Instantiate a TreeSet with the SingleCardComparator
        SortedSet<SingleCard> sortedCards = new TreeSet<>(new SingleCardComparator());
//        Add all the SingleCards in the List
        sortedCards.addAll(cardsList);
//        VGerify that they are now sorted
        System.out.println("\nAfter sorting:\n=============");
        for (SingleCard card : sortedCards) {
            System.out.println(card);
        }

    }
    
}
