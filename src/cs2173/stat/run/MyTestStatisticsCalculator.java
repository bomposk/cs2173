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
public class MyTestStatisticsCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Debug
        boolean debug = false;
        int NUMBER_OF_TESTS = 9;
        int numberOfPassedTests = 0;
        String given1 = "";
        String RESET  = "\u001B[0m";
        String RED = "\033[0;31m";     // RED
        String GREEN = "\033[0;32m";   // GREEN


        // Create a new object
        StatisticsCalculator statisticsObject;
        
        // Initialize the variables
        statisticsObject = new StatisticsCalculator();
        
        
        System.out.println("Testing StatisticsCalculator class\n");
        
        
        //Before any data
        System.out.println("Before any data:");
        System.out.println(statisticsObject + "\n");
        
        if (debug){
            String given = "0 Infinity -Infinity NaN NaN NaN";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        //After newObservation(1)
        statisticsObject.newObservation(1.0);
        System.out.println("After newObservation(1):");
        System.out.println(statisticsObject + "\n");
        
        if (debug){
            String given = "1 1,000 1,000 1,000 NaN NaN";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        //After newObservation(2)
        statisticsObject.newObservation(2.0);
        System.out.println("After newObservation(2):");
        System.out.println(statisticsObject + "\n");
        
        if (debug){
            String given = "2 1,000 2,000 1,500 0,707 0,500";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        //Same object after reset()
        statisticsObject.reset();
        System.out.println("Same object after reset():");
        System.out.println(statisticsObject + "\n");
        
        if (debug){
            String given = "0 Infinity -Infinity NaN NaN NaN";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        //Same object after reset() and first 100,000 integers
        for (int i = 1; i <= 100000; i++) {
            statisticsObject.newObservation((double) i);
        }
        System.out.println("Same object after reset() and first 100,000 "
                + "integers:");
        System.out.println(statisticsObject + "\n");
        
        if (debug){
            String given = "100.000 1,000 100.000,000 50.000,500 28.867,658 833.341.666,667";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
    
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
        
        if (debug){
            String given = "1,000,000 -4.864 5.770 -0.001 1.000 1.000";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        
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
        
        if (debug){
            String given = "23.809 7,000 99.999,000 50.001,000 28.867,484 833.331.655,661";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        //Multiples of 3 and 5
        statisticsObject.reset();
        
        for (int i = 1; i <= 100000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                statisticsObject.newObservation((double) i);                
            }   
        }
        System.out.println("Multiples of 3 and 5:");
        System.out.println(statisticsObject);
        
        if (debug){
            String given = "6.666 15,000 99.990,000 50.002,500 28.866,792 833.291.662,500";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        //Not Multiples of 3, 5, 7, or 9
        statisticsObject.reset();
        
        for (int i = 1; i <= 100000; i++) {
            if ((i % 3 != 0) && (i % 5 != 0) && (i % 7 != 0) && (i % 9 != 0)) {
                statisticsObject.newObservation((double) i);                
            }   
        }
        System.out.println("Not Multiples of 3, 5, 7, or 9:");
        System.out.println(statisticsObject);
        
        if (debug){
            String given = "45.714 1,000 99.998,000 49.999,688 28.867,649 833.341.147,520";
            if (given.equals(statisticsObject.toString())){
                System.out.println(GREEN + "PASS\n" + RESET);
                numberOfPassedTests ++;
            }else{
                System.out.println(RED + "FAIL" + RESET);
                System.out.println(given + " :PROF");
                System.out.println(statisticsObject + " :MINE \n");
            }
        }
        
        
        if (debug){
            if (numberOfPassedTests == NUMBER_OF_TESTS - 1){
                System.out.println(GREEN + "\n\nSucced : " + numberOfPassedTests + " / " + 
                    NUMBER_OF_TESTS + RESET);
            }else{
                System.out.println(RED + "\n\nSucced : " + numberOfPassedTests + " / " + 
                    NUMBER_OF_TESTS + RESET);
            }
        }
        
        
    }// main
    
}// class
