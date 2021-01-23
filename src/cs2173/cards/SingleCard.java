/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2173.cards;

/**
 * This is the SingleCard class which it is used to create a single card.
 * It contains:
 *          2 instance variables: suit and value
 *          1 constructor
 *          3 instance methods: the 2 getters and the 1 toSting()
 * 
 * @author Konstantinos Bompos
 * Date: 01/16/2020
 */
public class SingleCard {
    
    // Declare the variables
    private Suit suit;
    private int value;
    
    
    // Constructor
    /**
     * Constuct a single card
     * @param suit Give the suit of each card
     * @param value Give the value of each card
     */
    public SingleCard(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    
    
    /** Accessors - Getter
     * I will not create a setter because after a card is created I want to be 
     * and not to be changed later
     */ 

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
    
    
    /**
     * Output Prettier
     * Replace all the values of the cards in word. And replace 1, 2, 11, 12, 
     * and 13 to Ace, Deuce, Jack, Queen, and King respectively.
     * 
     * @return 
     */
    @Override
    public String toString(){
        
        String valueStrCard;
        
        switch(value){
            case 1:
                valueStrCard = "Ace";
                break;
            case 2:
                valueStrCard = "Deuce";
                break;
            case 3:
                valueStrCard = "Three";
                break;
            case 4:
                valueStrCard = "Four";
                break;
            case 5:
                valueStrCard = "Five";
                break;
            case 6:
                valueStrCard = "Six";
                break;
            case 7:
                valueStrCard = "Seven";
                break;
            case 8:
                valueStrCard = "Eight";
                break;
            case 9:
                valueStrCard = "Nine";
                break;
            case 10:
                valueStrCard = "Ten";
                break;
            case 11:
                valueStrCard = "Jack";
                break;
            case 12:
                valueStrCard = "Queen";
                break;
            case 13:
                valueStrCard = "King";
                break;
            default:
                // it will not be used
                valueStrCard = Integer.toString(value);
                break;
        }// switch
        
        return  valueStrCard + " of " + getSuit();
    }// toString
    
  }// class SingleCard
