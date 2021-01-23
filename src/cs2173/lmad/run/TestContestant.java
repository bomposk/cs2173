package cs2173.lmad.run;

import cs2173.lmad.Contestant;
import cs2173.lmad.Strategy;
import java.util.Random;

/**
 * TestContestant checks: Initialize a user
 * 
 * @author Konstantinos Bompos
 * Date: 02/07/2020
 */
public class TestContestant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Contestant contestant;
        Random random = new Random();
        
        // the door that the host opens after player's choice
        int boobydoor;        
        
        Strategy [] allDefinedStrategys = Strategy.values();
        
        // Test 10 times with player's choice for both Strategies
        for (int j = 0; j < allDefinedStrategys.length; j++) {
            System.out.println("Using Stategy " + allDefinedStrategys[j]);
            
            //define Contestant's strategy
            contestant = new Contestant(allDefinedStrategys[j]);
            
            //check it 10 times
            for (int i = 0; i < 10; i++) {
                contestant.initialChoice();
                System.out.println("first choice: " + contestant.getGuess());

                boobydoor = random.nextInt(3);
                while (boobydoor == contestant.getGuess()){
                    boobydoor = random.nextInt(3);
                }

                System.out.println("Boobydoor is door:" + boobydoor);

                contestant.stayOrSwitch(boobydoor);
                
                System.out.println("New Choice is: " + contestant.getGuess() + "\n");

            }//game loop
        }//strategy loop
    }//main
}//class
