/*
 * Computer Assignment 04
 */
package cs2173.stat.run;

import cs2173.stat.StatisticsCalculator;
import java.util.Random;

/**
 * Test the StatisticalCalculator class
 * 
 * @author Konstantinos Bompos
 * Date: 01/24/2020
 */
public class TestStatisticsCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a new object
        StatisticsCalculator statisticsObject;
        
        // Initialize the variables
        statisticsObject = new StatisticsCalculator();
        
        
        System.out.println("Testing StatisticsCalculator class\n");
        
        
        //Before any data
        System.out.println("Before any data:");
        System.out.println(statisticsObject + "\n");
        
        
        //After newObservation(1)
        statisticsObject.newObservation(1.0);
        System.out.println("After newObservation(1):");
        System.out.println(statisticsObject + "\n");
        
        
        //After newObservation(2)
        statisticsObject.newObservation(2.0);
        System.out.println("After newObservation(2):");
        System.out.println(statisticsObject + "\n");
        
        
        //Same object after reset()
        statisticsObject.reset();
        System.out.println("Same object after reset():");
        System.out.println(statisticsObject + "\n");
        
        
        //Same object after reset() and first 100,000 integers
        for (int i = 1; i <= 100000; i++) {
            statisticsObject.newObservation((double) i);
        }
        System.out.println("Same object after reset() and first 100,000 "
                + "integers:");
        System.out.println(statisticsObject + "\n");
        
    
        //Statistics for 1,000,000 Gaussian random variates
        statisticsObject.reset();
        
        Random rand = new Random();
        double x = 0;
       
        for (int i = 1; i <= 1000000; i++) {
            x = rand.nextGaussian();
            statisticsObject.newObservation(x);
        }
        System.out.println("Statistics for 1,000,000 Gaussian random "
                + "variates:");
        System.out.println(statisticsObject + "\n");        
        
        
        System.out.println("\n\nSecond Test\n");
        
        //Multiples of 7 or 9
        statisticsObject.reset();
        
        for (int i = 1; i <= 100000; i++) {
            if ((i % 7 == 0) || (i % 9 == 0)) {
                statisticsObject.newObservation((double) i);                
            }   
        }
        System.out.println("Multiples of 7 or 9:");
        System.out.println(statisticsObject);
        
        
        //Multiples of 3 and 5
        statisticsObject.reset();
        
        for (int i = 1; i <= 100000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                statisticsObject.newObservation((double) i);                
            }   
        }
        System.out.println("Multiples of 3 and 5:");
        System.out.println(statisticsObject);
        
        
        //Not Multiples of 3, 5, 7, or 9
        statisticsObject.reset();
        
        for (int i = 1; i <= 100000; i++) {
            if ((i % 3 != 0) && (i % 5 != 0) && (i % 7 != 0) && (i % 9 != 0)) {
                statisticsObject.newObservation((double) i);                
            }   
        }
        System.out.println("Not Multiples of 3, 5, 7, or 9:");
        System.out.println(statisticsObject);
        
    }// main
    
}// class
