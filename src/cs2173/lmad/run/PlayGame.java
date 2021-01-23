package cs2173.lmad.run;

import cs2173.lmad.Contestant;
import cs2173.lmad.LetsMakeADeal;
import cs2173.lmad.Strategy;
import cs2173.stat.StatisticsCalculator;

/**
 * Test the Game
 * 
 * @author Konstantinos Bompos
 * Date: 02/07/2020
 */
public class PlayGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int NUMBER_OF_GAMES = 1000000;
        double WIN = 1.0;
        double LOSE = 0.0;
        
        //An array with the all possible Strategies
        Strategy [] allDefinedStrategys = Strategy.values();
        
        // Create a new objects
        StatisticsCalculator statisticsObject;
        LetsMakeADeal letsMakeADeal;
        Contestant contestant;
        
        // Initialize the variables
        statisticsObject = new StatisticsCalculator();
        letsMakeADeal = new LetsMakeADeal();
        
        
        System.out.printf("%,d games will be simulated for each strategy\n", 
                NUMBER_OF_GAMES);
        
        
        // Outer Loop for Strategy
        for (int i = 0; i < allDefinedStrategys.length; i++) {
            System.out.println("Using Stategy " + allDefinedStrategys[i]);
            
            //reset the calculations
            statisticsObject.reset();
            
            //initiate the Contestant according to his strategy
            contestant =  new Contestant(allDefinedStrategys[i]);
            
            
            // Inner Loop for game - Begin the replication
            for (int j = 0; j < NUMBER_OF_GAMES; j++) {           
                
                letsMakeADeal.play(contestant);
                
                double resultWeight;
                
                if (letsMakeADeal.winner()){
                    resultWeight = WIN;
                }else{
                    resultWeight = LOSE;
                }
                
                statisticsObject.newObservation(resultWeight);     
                
            }//game loop 
            
            System.out.printf("      Prob(win) = %,.5f\n", 
                    statisticsObject.getMean());
            
        }//strategy loop
        
    }//main
    
}//class
