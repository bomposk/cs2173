package cs2173.cards.run;

import cs2173.cards.Dealer;

/**
 * Test code for Dealer. Declare the number of players
 * 
 * @author Konstantinos Bompos
 * Date: 01/31/2020
 */
public class TestDealer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int NUMBER_OF_PLAYERS = 5;
//        final int NUMBER_OF_GAMES = 3;
        
        Dealer dealer = new Dealer(NUMBER_OF_PLAYERS);
        
//        for (int i = 0; i < NUMBER_OF_GAMES; i++) {
//            System.out.println(i + " Game");
//            dealer.dealAll();
//            System.out.println(dealer);
//        }

        System.out.println("First Game");
        dealer.dealAll();
        System.out.println(dealer);
        
        System.out.println("Second Game");
        dealer.dealAll();
        System.out.println(dealer);
        
        System.out.println("Third Game");
        dealer.dealAll();
        System.out.println(dealer);
        

    }// main
    
}// class
