/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2173.cards.run;

import cs2173.cards.SingleCard;
import cs2173.cards.Suit;

/**
 * The TestSingle is used to make sure that SingleCard is working.
 * Finally, it will print all individuals cards in the deck.
 * 
 * @author Konstantinos Bompos
 * Date: 01/16/2020
 */
public class TestSingleCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declare the variables
        int maxValueCards; // to store the maximum value of a card
        Suit [] allDefinedSuits; // an array of all Suits
        SingleCard [] deck; // an array of all possibles card in a deck
        int index; // to track the index in the deck
        
        
        // Initialize the variables
        maxValueCards = 13; // the maximum value of each suit
        // Suit.values() return an array of ALL of the defined enums.
        // Store them in array named allDefinedSuits
        allDefinedSuits = Suit.values();
        // an array of all the cards 13 * 4 = 52
        deck = new SingleCard[maxValueCards * allDefinedSuits.length];
        index = 0; // initiliaze with the # of first cell
        
        
        // Store all the possibles cards in the deck        
        // Create a for-loop to print all the defined Suits
        for (int i = 0; i < allDefinedSuits.length; i++) {
            // Nested for-loop to print the cards from 1 to 13
            for (int j = 1; j <= maxValueCards; j++) {
                deck[index] = new SingleCard(allDefinedSuits[i], j);
                // each time increase the index to store the next card
                index += 1; 
            }// inner for-loop number        
        }// outer for-loop suit
        
        
        // call toSting() to print the deck
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
        
    }// main
    
}// class TestSingleCard
