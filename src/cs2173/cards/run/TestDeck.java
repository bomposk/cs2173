/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2173.cards.run;

import cs2173.cards.CardDeck;
import cs2173.cards.SingleCard;
import java.util.Random;

/**
 * The Test Deck is used to test the CardDeck. In the beggining it prints an 
 * Unshuffled Deck, then a Shuffled Deck and finally it checks the getCard
 * 
 * @author Konstantinos Bompos
 * Date: 01/16/2020
 */
public class TestDeck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // A New Unshuffled Deck
        System.out.println("--- A New Unshuffled Deck ---");
        
        // Declare
        CardDeck cardDeck;
        
        //Initialize
        cardDeck = new CardDeck();
       
        System.out.println(cardDeck);
        
        
        // A Shuffled Deck
        System.out.println("\n\n--- A Shuffled Deck ---");
        cardDeck.shuffleDeck();
        System.out.println(cardDeck);
        
        
        // Check getCard
        System.out.println("\n\n--- Check getCard ---");
        System.out.println("The 2th card is the " + cardDeck.getCard(1));
        
        Random random = new Random();
        int randomIndex; // for the random number
        randomIndex = random.nextInt(52);
        System.out.println("The " +randomIndex +"th card is the " 
                + cardDeck.getCard(randomIndex-1));
        
        // Professor checks
//        Not required by assignment, but testing getCard(int)
//        First, one that should "work"
        int index = 30;
        SingleCard singleCard = cardDeck.getCard(index);
        System.out.printf("SingleCard at index %d is: %s%n", index, singleCard);
        
//        Now one that has a negative index, which should return null:
        index = -1;
        singleCard = cardDeck.getCard(index);
        System.out.printf("SingleCard at index %d is: %s%n", index, singleCard);
        
//        This is the size of the array, so it is "natural" to try to get it.
//        However, the maximum index is 51, not 52! So this should also be null:
        index = 52;
        singleCard = cardDeck.getCard(index);
        System.out.printf("SingleCard at index %d is: %s%n", index, singleCard);
        
    }// main
    
}// class TestDeck
