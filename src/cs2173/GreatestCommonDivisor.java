/*
 * The greatest common divisor (gcd) of two integers is the largest number that 
 * divides both evenly. For example, the gcd of 525 and 810 is 15. One of the 
 * oldest algorithms is Euclid’s algorithm for finding the gcd of two =numbers.
 * 
 * Pseudo-code for Euclid’s algorithm is as follows: 
 * Method gcd(x,y)
 * 	Initialize: x ≥ 0, y ≥ 0
 * 		if x < y then swap x and y
 * 		if y = 0 then return x
 * 		else return gcd(x % y, y)
 */


/*
 * A program that the USER enters two numbers and the program returns the
 * greatest common divisor(gcd)
*/
package cs2173;

import java.util.Scanner; // import Scanner

/**
 *
 * @author Konstantinos Bompos
 * Date: 01/09/2020
 */
public class GreatestCommonDivisor {

    /**
     * Main--> ask from the user to enter the two numbers
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.printf("Enter two integers: ");
        
        // create an array for the 2 numbers
        int [] integers =  new int[2];
        
        // a for-loop to read the first two numbers and import them to the array
        for (int i = 0; i < integers.length; i++) {
            integers[i] = keyboard.nextInt();
        } //for-loop
        
        // release resource
        keyboard.close();

        System.out.printf("gcd(%d,%d) = %d%n", integers[0], integers[1], 
                                                gcd(integers[0],integers[1]));
    } // main
    

    /**
     * GCD--> Takes two numbers and returns the gcd
     */
    public static int gcd(int x, int y){

        // make the number positive in case they are negative
        x = Math.abs(x);
        y = Math.abs(y);
        
        // use later for swapping
        int temp;
        
        // Swap in case that x<y (from pseudo-code)
        if (x<y){
            temp = x;
            x = y;
            y = temp;
        } // if 
        
        // (from pseudo-code)
        if (y==0){
            return x;
        }else{
            return gcd(x%y, y);
        } // if
            
    } // gcd    
  
} // class
