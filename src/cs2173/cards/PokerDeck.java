package cs2173.cards;


/**
 * A subclass form CardDeck. Draw cards from a deck and keep tracking the 
 * number of the given cards
 * 
 * @author Konstantinos Bompos
 * Date: 01/31/2020
 */
public class PokerDeck extends CardDeck{
    
    private int nextIndex;
    

    /**
     * Override CardDeck.shuffleDeck() by doing the same and set nextIndex to 0
     */
    @Override    
    public void shuffleDeck(){
        super.shuffleDeck();
        nextIndex = 0;
    }
    
    
    /**
     * We draw each time a card from the deck. If the deck is finished we 
     * shuffle and continue from a new fresh deck
     * 
     * @return the card that it had been referencing in the myCards array 
     */
    public SingleCard dealCard(){
        
        SingleCard dealNewCard;
        dealNewCard = getCard(nextIndex);
        
        nextIndex += 1;
        
        // Check if the deck is finished
        if (nextIndex == getMyCards().length){
            shuffleDeck();
        }
        
        return dealNewCard;
    }
        
}// class