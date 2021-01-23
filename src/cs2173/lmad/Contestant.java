package cs2173.lmad;

import java.util.Random;

/**
 * Represent a Player/Contestant define his strategy and his first choise 
 * on the doors.
 * Later define his second choice according to his strategy
 * 
 * @author Konstantinos Bompos
 * Date: 02/07/2020
 */
public class Contestant {
    
    private final Strategy strategy;
    private final Random random;
    private int guess;
    
    int NUMBER_OF_DOORS = 3;
    
    /**
     * Constructor
     * Initiate a Contestant with his strategy and instatiate random
     * 
     * @param strategy 
     */
    public Contestant(Strategy strategy){
        this.strategy = strategy;
        this.random = new Random();
    }
    
    
    /**
     * Set guess as an integer between 0 and 2
     */
    public void initialChoice(){
        this.guess = random.nextInt(NUMBER_OF_DOORS);
    }
    
    
    /**
     * boobydoor is a door that --> contains a Goat and 
     *                              is not the Contestant's door
     * 
     * Moreover, boobydoor is the door that host opens
     * 
     * If the strategy is Switch the Contenstant choose the remaining door
     * If the strategy is Keep the Contenstant keep his first choice
     * 
     * @param boobyDoor 
     */
    public void stayOrSwitch(int boobyDoor){
                
        if (getStrategy()== Strategy.SWITCH){
            for (int i = 0; i < NUMBER_OF_DOORS; i++) {
                if (i!=getGuess()&& i!=boobyDoor){
                    guess = i;
                    break;
                }
            }
        }
    }

    
    /**
     * @return the guess
     */
    public int getGuess() {
        return guess;
    }
    

    /**
     * @return the strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }
    
    
}//class
