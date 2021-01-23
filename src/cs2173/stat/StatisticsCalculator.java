/*
 * Computer Assignment 04
 */
package cs2173.stat;


/**
 * It accepts numerical data one observation at a time and compute simple 
 * summary statistics for the data. 
 * The summary statistics are: the number of observations recorded, 
 *                             the minimum and maximum values of the data, 
 *                             the mean of the data, 
 *                             the variance of the data, and 
 *                             the standard deviation of the data.
 * 
 * @author Konstantinos Bompos
 * Date: 01/24/2020
 */
public class StatisticsCalculator {
    
    // Declare the variables
    private int count;           // number of observation
    private double min;          // current min observation
    private double max;          // current max observation
    private double sum;          // sum of observation
    private double sumOfSquares; // sum of squares' observation
    
    
    // Constructor
    /**
     * Call reset() from the constructor to ensure that all variables have 
     * been initialized. 
     */
    public StatisticsCalculator(){
        reset();
    }
    
    
    // Initialize the variables
    /**
     * Initialize count, sum and sumOfSquares to 0
     * Initialize min to POSITIVE_INFINITY. Because later any given number will 
     * be smaller
     * Initialize max to NEGATIVE_INFINITY. Because later any given number will 
     * be greater
     */
    public final void reset(){
        count = 0;
        min = Double.POSITIVE_INFINITY;
        max = Double.NEGATIVE_INFINITY;
        sum = 0;
        sumOfSquares = 0;
    }
    
    
    /**
     * The updating is: increase count by 1, add the new observation to sum, 
     * and add the square of the new observation to sumOfSquares.
     * Then check if the value is smaller than min. If this is true replace the
     * min with the current observation.
     * Finally, check if the value is bigger than max. If this is true replace 
     * the max with the current observation.
     * 
     * @param x 
     */
    public void newObservation(double x){
        count += 1;
        sum += x;
        sumOfSquares += Math.pow(x, 2);
        min = Math.min(getMin(), x);
        max = Math.max(getMax(), x);        
    }

    
    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    
    /**
     * @return the min
     */
    public double getMin() {
        return min;
    }

    
    /**
     * @return the max
     */
    public double getMax() {
        return max;
    }
    
    
    /**
     * @return the mean of the data --> sum/ # of observations 
     */
    public double getMean(){
        return (sum / getCount());
    }
    
    
    /**
     * @return the standard deviation (σ) of the data --> square root of 
     * variance (σ^2)
     */
    public double getStandardDeviation(){
        return Math.sqrt(getVariance());
    }
    
    
    /**
     * @return the variance (σ^2) of the data
     */
    public double getVariance(){
        return (1/ ((double)getCount() -1)) * 
                (sumOfSquares - (getCount() * Math.pow(getMean(), 2)));
    }
    
    
    @Override
    /**
     * @return the given format 
     */
    public String toString(){
       return String.format("%,d %,.3f %,.3f %,.3f %,.3f %,.3f",
                                getCount(), 
                                getMin(), 
                                getMax(), 
                                getMean(), 
                                getStandardDeviation(), 
                                getVariance());
    }
    
}// class
