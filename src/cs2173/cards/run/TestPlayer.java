package cs2173.cards.run;

import cs2173.cards.Player;
import cs2173.cards.PokerDeck;
import cs2173.cards.SingleCard;

/**
 * Test code for player:
 * -Create a player with empty hand
 * -Initiate player's hand & Clear the his hand
 * 
 * -Add 3 more players & Clear their hand
 * 
 * -Add 11 new players. I dont shuffle the deck to check that the first 52 
 * cards are in order and after that all cards are duplicate but shuffled
 * 
 * -Shuffle the deck. The first 52 cards should not be in order and only 3 of 
 *  them should be duplicate
 * 
 * @author Konstantinos Bompos
 * Date: 01/31/2020
 */
public class TestPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String RESET  = "\u001B[0m";
        String RED    = "\033[0;31m";   // RED
        String GREEN  = "\033[0;32m";   // GREEN
        final int CARDS_TO_HAND = 5;    // # of cards in each player's hand
        final int PLAYERS = 3;          // # of players for 1st test
        final int NEW_PLAYERS = 11;     // # of players for 2nd test
        
        Player player = new Player();
        
        /*
         * No cards have been dealt yet
         */  
        System.out.println(GREEN + "No cards have been dealt yet");
        System.out.println(player);

        // Instatiate
        PokerDeck pokerDeck = new PokerDeck();
        SingleCard[] hand = new SingleCard[CARDS_TO_HAND];

        
        /*
         * Without shuffling. The cards should be in order
         */ 
        System.out.println("\n" + GREEN + "Without shuffling and 1 player");
        for (int j = 0; j < hand.length; j++) {
            hand[j] = pokerDeck.dealCard();
        }
        player.setHand(hand);
        System.out.println(player);
        
        
        /*
         * Clear player΄s ηand
         */
        System.out.println("\n" + GREEN + "Clear player's Hand");
        player.clearHand();
        System.out.println(player);
        
        
        /*
         * AGAIN - Without shuffling. The cards should be in order
         */ 
        System.out.println("\n" + GREEN + "AGAIN - Without shuffling and 1 "
                + "player");
        for (int j = 0; j < hand.length; j++) {
            hand[j] = pokerDeck.dealCard();
        }
        player.setHand(hand);
        System.out.println(player);

        
        /*
         * Without shuffling. The cards should continue to be in order
         */ 
        System.out.println("\n" + GREEN + "Without shuffling and add " + PLAYERS 
                + " more players");

        // Add 3 more players
        Player[] players = new Player[PLAYERS];
        
        // Loop for create 3 players
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
            // Loop for draw 5 cards each
            for (int j = 0; j < hand.length; j++) {
                hand[j] = pokerDeck.dealCard();
            }
            players[i].setHand(hand);
            System.out.println(players[i]);
        }
        
        
        /*
         * AGAIN - Clear hand for all players
         */ 
        System.out.println("\n" + GREEN + "AGAIN - Clear hand for all players");
        for (int i = 0; i < players.length; i++) {
            players[i].clearHand();
            System.out.println(players[i]);
        }
        

        /**
         * Without shuffling and 11 players
         * The first 52 cards should be continue to be in order but after the 
         * deck has finished the next 3 card (11 * 5 = 55, 55-52 =3) should be 
         * repeat but not in order because I initialize a new SHUFFLE deck
         */
        System.out.println("\n" + GREEN + "Without shuffling and " 
                + NEW_PLAYERS + " players");

        Player[] newPlayers = new Player[NEW_PLAYERS];
        PokerDeck newPokerDeck = new PokerDeck();
        SingleCard[] newHand = new SingleCard[CARDS_TO_HAND];

        // Loop for create 11 playes
        for (int i = 0; i < newPlayers.length; i++) {
            newPlayers[i] = new Player();
            // Loop for draw 5 cards each
            for (int j = 0; j < newHand.length; j++) {
                newHand[j] = newPokerDeck.dealCard();
            }
            newPlayers[i].setHand(newHand);
            System.out.println(newPlayers[i]);
        }

        
        /**
         * The first 52 cards should be UNIQUE and NOT IN ORDER but after the 
         * deck has finished the next 3 card (11 * 5 = 55, 55-52 =3) should be 
         * repeat but not in order because I initialize a new SHUFFLE deck
         */
        System.out.println("\n" + GREEN + "With shuffling and " + NEW_PLAYERS 
                + " players");

        newPokerDeck.shuffleDeck();
        
        // Arrays for later check. singleCards will store all the given cards and
        // sameCards will store the duplicate cards
        SingleCard[] givenCards = new SingleCard[NEW_PLAYERS*CARDS_TO_HAND];
        SingleCard[] sameCards = new SingleCard[NEW_PLAYERS*CARDS_TO_HAND];
        int indexGiven = 0;
        int indexSame = 0;
 
        for (int i = 0; i < newPlayers.length; i++) {
            for (int j = 0; j < newHand.length; j++) {
                newHand[j] = newPokerDeck.dealCard();
                // Strore cards
                givenCards[indexGiven] = newHand[j];
                indexGiven++;
            }
            newPlayers[i].setHand(newHand);
            System.out.println(newPlayers[i]);
        }

        // Check how many cards are duplicate
        for (int i = 0; i < (givenCards.length - 1); i++) {
            for (int j = (i + 1); j < givenCards.length; j++) {
                if (givenCards[i].equals(givenCards[j])) {
                    sameCards[indexSame] = givenCards[i];
                    indexSame++;
                }
            }
        }
        
        // Print the array with same cards
        System.out.println("\n" + GREEN + "These cards are same:");
        
        int count = 0;
        // Convert to 0 if the result is negative
        int duplicateCards = Math.max(0, ((NEW_PLAYERS*CARDS_TO_HAND) - 52 + 
                (((NEW_PLAYERS*CARDS_TO_HAND)/52) - 1)));

        for (int i = 0; i < sameCards.length; i++) {
            if (sameCards[i] != null) {
                System.out.println(sameCards[i]);
                count++;
            }
        }
        
        if (count == duplicateCards){
            System.out.println(GREEN + "The number of same cards is right: " 
                    + count);
        }else{
            System.out.println(RED + "The number of same cards should be: " 
                    + count);
        }
        
    }// main
}// class
