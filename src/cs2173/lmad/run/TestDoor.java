package cs2173.lmad.run;

import cs2173.lmad.Door;
import cs2173.lmad.Prize;

/**
 * Test Door class
 * 
 * @author Konstantinos Bompos
 * Date: 02/07/2020
 */
public class TestDoor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // initiate an Array with all types of Prize
        Prize [] allPossiblePrizes = Prize.values();
        
        //create an object
        Door door = new Door();
        
        //check getter
        System.out.println(door.getPrize());
        
        //check setter
        door.setPrize(Prize.CAR);
        System.out.println(door.getPrize());
        
        
        for (int i = 0; i < allPossiblePrizes.length; i++) {
            door.setPrize(allPossiblePrizes[i]);
            System.out.println(door.getPrize());
            
        }
    }//main
    
}//class
