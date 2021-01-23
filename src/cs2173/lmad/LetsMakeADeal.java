package cs2173.lmad;

import java.util.Random;

/**
 * It is used to setup the game
 * -Initiates the doors and the prizes
 * -Reflects the contestant's choice
 * -Determines if the contestant wins the Car or not
 * 
 * @author Konstantinos Bompos
 * Date: 02/07/2020
 */
public class LetsMakeADeal {
    
    private final Door[] doors;
    private final Random random;
    private int choice;
    
    int NUMBER_OF_DOORS = 3;
    
    
    /**
     * Initiate the number of Doors and create the object
     */
    public LetsMakeADeal(){
        this.doors = new Door[NUMBER_OF_DOORS];
        this.random = new Random();
        
        for (int i = 0; i < NUMBER_OF_DOORS; i++) {
            doors[i] = new Door();
        }
    }
    
    
    /**
     * carDoor will be random initiate between 0 and 2, and this will 
     * be the door that contains the Car prize. 
     * 
     * After that, the remaining doors will contain the Goat prize
     */
    public void newGame(){
        
        // random door for CAR
        int carDoor = random.nextInt(NUMBER_OF_DOORS);
        
        doors[carDoor].setPrize(Prize.CAR);
        
        // all remaining doors contain GOAT
        for (int i = 0; i < NUMBER_OF_DOORS; i++) {
            if (i != carDoor){
                doors[i].setPrize(Prize.GOAT);
            }
        }
    }
    
    
    /**
     * Represent the Contenstant's choice
     * 
     * @param choice 
     */
    public void chooseDoor(int choice){
        this.choice = choice;        
    }
    
    
    /**
     * Represents the door that host will open after the user initiate his 
     * choice.
     * 
     * goatOpenDoor is a door that --> contains a Goat and 
     *                                 is not the Contestant's door
     * 
     * @return goatOpenDoor 
     */
    public int getOpenGoatDoor(){
        
        //initiate to -1 just in case it fails to be initiated later to throw 
        //an error
        int goatOpenDoor = -1;
        
        //if it is not Contestant's choice AND contain goat open it
        for (int i = 0; i < NUMBER_OF_DOORS; i++) {
            if ((i != choice) && (doors[i].getPrize() == Prize.GOAT )){
                goatOpenDoor = i;
                break;
            } 
        }
        
        return goatOpenDoor;
    }
    
    
    /**
     * 1. Invoke newGame()
     * 2. Invoke initialChoice() on the Contestant
     * 3. Invoke chooseDoor(int) passing the Contestant’s first guess
     * 4. Determine the open door index with getOpenGoatDoor()
     * 5. Pass the open door index to Contestant’s stayOrSwitch(int) method
     * 6. The Contestant’s guess is now their final choice – pass that value 
     *    to chooseDoor(int)

     * @param contestant 
     */
    public void play(Contestant contestant){
        
        newGame();                              //1.
        contestant.initialChoice();              //2.
        chooseDoor(contestant.getGuess());      //3.
        int hostDoor = getOpenGoatDoor();       //4.
        contestant.stayOrSwitch(hostDoor);      //5.
        chooseDoor(contestant.getGuess());      //6.
    }
    
    
    /**
     * Determines if the contestant wins the Car or not
     * 
     * @return boolean winCar
     */
    public boolean winner(){
        
        boolean winCar = false;
        
        if (doors[choice].getPrize() == Prize.CAR ){
            winCar = true;
        }
        
        return winCar;
    }
    
}//class
