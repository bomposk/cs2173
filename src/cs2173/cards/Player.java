package cs2173.cards;

import java.util.Arrays;

/**
 * Represent a player holding 5 cards.
 * 
 * @author Konstantinos Bompos
 * Date: 01/31/2020
 */
public class Player {

    private static int NEXT_ID = 0;
    private final int id;
    private SingleCard[] hand;

    
    /**
     * Constructor
     * Instatiate a Player with the id the NEXT_ID. Then increase NEXT_ID by 1.
     * Also, initiate an empty hand
     */
    public Player() {
        this.id = NEXT_ID;
        NEXT_ID += 1;
        this.setHand(new SingleCard[5]); // Initiate an empty hand
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    
    /**
     * @return the hand
     */
    public SingleCard[] getHand() {
        return hand.clone();
    }

    
    /**
     * 
     * @param hand 
     */
    public void setHand(SingleCard[] hand) {
        this.hand = hand.clone();
    }
    
    
    /**
     * set each card in the hand to null
     */
    public void clearHand(){
        Arrays.fill(hand, null);        
    }
    
    
    @Override
    public String toString() {
        return "Player " + getId() + ": " + Arrays.toString(getHand());
    }

}// class