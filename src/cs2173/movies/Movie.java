package cs2173.movies;

import java.util.Arrays;


/**
 * This class is used to construct an object for each Movie that is read from 
 * the given file.
 * 
 * @author Konstantinos Bompos
 * Date: 02/28/2020
 */
public class Movie implements Comparable<Movie>{
    
    private final String title;
    private final String[] genres;
    private final TitleType titleType;
    private final boolean adult;
    private final int year;
    private final int runningTimeInMinutes;
    
    
    /**
     * Constructor for each movie. Initialize the variables
     * 
     * @param titleType
     * @param title
     * @param adult
     * @param year
     * @param runningTimeInMinutes
     * @param genres 
     */
    public Movie(TitleType titleType, String title, boolean adult, int year,
            int runningTimeInMinutes, String[] genres) {
        this.titleType = titleType;
        this.title = title;
        this.adult = adult;
        this.year = year;
        this.runningTimeInMinutes = runningTimeInMinutes;
        this.genres = genres;        
    }

    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    
    /**
     * @return the genres
     */
    public String[] getGenres() {
        return genres.clone();
    }

    
    /**
     * @return the titleType
     */
    public TitleType getTitleType() {
        return titleType;
    }

    
    /**
     * @return the adult
     */
    public boolean isAdult() {
        return adult;
    }

    
    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    
    /**
     * @return the runningTimeInMinutes
     */
    public int getRunningTimeInMinutes() {
        return runningTimeInMinutes;
    }
    
    
    
    @Override
    /**
     * 
     */
    public String toString() {
        return getTitle() + "\t" + getYear()+ "\t" 
                + Arrays.toString(getGenres());
    }

    
    /**
     * Sort them first Alphabetical by Title and 
     * then by year
     * 
     * < 0 :   this   <   o1
     *   0 :   this   =   o1
     * > 0 :   this   >   o1
     * 
     * 
     * @param o
     * @return result
     */
    @Override
    public int compareTo(Movie o) {
        //Compare first by ignoring Case
        int result = this.title.compareToIgnoreCase(o.getTitle());
        
        //If 2 movies have the same title--> check the year
        if (result == 0){
            result = this.year - o.getYear(); 
        }
       
        return result;        
    }
    
}//class