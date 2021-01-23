package cs2173.cards;

import java.util.Arrays;

/**
 * Represent a dealer and create the given number of players.
 * 
 * @author Konstantinos Bompos
 * Date: 01/31/2020
 */
public class Dealer {
    
    private PokerDeck deck;
    private Player[] players;
    
    
    /**
     * Constructor. Create the given number of players and instantiate them.
     * Also, create a new deck.
     * 
     * @param numberOfPlayers 
     */
    public Dealer(int numberOfPlayers){
        
        players = new Player[numberOfPlayers];
        
        // Instantiate each player
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        
        deck = new PokerDeck();
        
//        deck.shuffleDeck();
    }
    
    
    /**
     * Shuffle the deck, 
     * Clear each player's hand and 
     * then give 5 cards to each player. It will give 5 cards to the 1st 
     * player, then 5 to the 2nd one and .... 
     */
    public void dealAll(){
        
        deck.shuffleDeck();
        
        // Dealer clear each player’s hand before dealing it the card
        for (int i = 0; i < players.length; i++) {
            players[i].clearHand();
        }
        
        // Deal new cards to each player
        for (int i = 0; i < players.length; i++) {
            SingleCard[] newHand = new SingleCard[5];
            for (int j = 0; j < newHand.length; j++) {
                newHand[j] = deck.dealCard();
            }
            players[i].setHand(newHand);
        }
    }

    
    /**
     * @return the players
     */
    public Player[] getPlayers() {
        return players.clone();
    }
    
    
    @Override
    public String toString(){
        String outputGame = "";
        
//        for (int i = 0; i < players.length; i++) {
//            outputGame += players[i] + "\n"; 
//        }

        for (int i = 0; i < players.length; i++) {
            outputGame += "Player " + players[i].getId() + ": " 
                    + Arrays.toString(players[i].getHand()) + "\n";
        }
        
        return outputGame;
    }
}// class