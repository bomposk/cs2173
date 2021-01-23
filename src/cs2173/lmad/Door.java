package cs2173.lmad;

/**
 * Reprsent a Dorr that Contains a Prize
 * 
 * @author Konstantinos Bompos
 * Date: 02/07/2020
 */
public class Door {
    
    private Prize prize;
    
    
    /**
     * @param prize the prize to set
     */
    public void setPrize(Prize prize) {
        this.prize = prize;
    }
    
    
    /**
     * @return the prize
     */
    public Prize getPrize() {
        return prize;
    }

}//class
