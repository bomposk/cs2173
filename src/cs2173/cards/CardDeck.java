/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2173.cards;

import java.util.Random;

/**
 *
 * @author Konstantinos Bompos
 * Date: 01/16/2020
 */
public class CardDeck {
    
    // Declare the variables
    private SingleCard[] myCards;
    private  Random random;
    
    
    // Constructor
    /**
     * Constuct a new Deck
     */
    public CardDeck() {
        this.myCards =  new SingleCard[52];
        this.random = new Random();
        this.createNewDeck(); // create a New Deck
    }
    
    
    /**
     * It will give us a set of 52 cards in order.
     * An Unshuffle Deck
     */
    public void createNewDeck(){
        Suit [] allDefinedSuits; // an array of all Suits
        int maxValueCards; // to store the maximum value of a card
        int index; // to track the index in the deck
        
        allDefinedSuits = Suit.values(); // store all the defined suits
        maxValueCards = 13; // the maximum value of each suit
        index = 0; // initiliaze with the # of first cell
        
        // Store all the possibles cards in the deck        
        // Create a for-loop to print all the defined Suits
        for (int i = 0; i < allDefinedSuits.length; i++) {
            // Nested for-loop to print the cards from 1 to 13
            for (int j = 1; j <= maxValueCards; j++) {
                myCards[index] = new SingleCard(allDefinedSuits[i], j);
                // each time increase the index to store the next card
                index += 1; 
            }// inner for-loop number        
        }// outer for-loop suit
        
    }// createNewDeck
    
    
    /**
     * It shuffles the cards of myDeck by looping each one and randomly swap
     * it with another.
     * It generates a ranondom number each time between 0 and 51.
     */
    public void shuffleDeck(){
        
        int randomIndex; // for the random number
        SingleCard tempCard; // to hold the value for the swap
        
        for (int i = 0; i < myCards.length; i++) {
            
            tempCard = myCards[i]; // store the value
            
            //generate a random until myCards.length==> between 0 and 51
            randomIndex = random.nextInt(myCards.length); 
           
            // swap with the random card
            myCards[i] = myCards[randomIndex];
            myCards[randomIndex] = tempCard; 
            
        }// for-loop
    
    }// shuffleDeck
    
    
    /**
     * @return the myCards
     */
    public SingleCard[] getMyCards() {
        return myCards.clone();
    }
    
    
    /**
     * 
     * @param index Given an index of card
     * @return The SingleCard of the given index
     */
    // Overwritten by the professor's code
    //This is mine:    
//    public SingleCard getCard(int index){
//        return myCards[index];
//    }
    // Professor's code:
    public SingleCard getCard(int index){
        SingleCard theCard = null;
        if (index >= 0 && index < myCards.length) {
            theCard = myCards[index];
        }
        return theCard;
    }
    

    @Override
    public String toString() {
        String cardOutput = "";
        
        for (int i = 0; i < myCards.length; ++i) {
            cardOutput +=  myCards[i];
            if (i < myCards.length - 1){
                cardOutput += "\n";
            }// if
        }// for-loop
  
        return cardOutput;
        
    }// toSting()
    
}// class CardDeck
