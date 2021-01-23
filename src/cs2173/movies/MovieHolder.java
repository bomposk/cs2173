package cs2173.movies;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is used to populate an object that holds instances representing 
 * movies.
 * 
 * @author Konstantinos Bompos
 * Date: 02/28/2020
 */
public class MovieHolder {
    
    private Set<Movie> allMovies;
    private Map<String, Set<Movie>> allMoviesByTitle;
    private Map<Integer, Set<Movie>> allMoviesByYear;
    private Map<String, Set<Movie>> allMoviesByGenre;
    
    
    /**
     * Constructor. 
     * Initialize the variables
     */
    public MovieHolder(){
        this.allMovies = new TreeSet<>();
        this.allMoviesByTitle = new HashMap<>();
        this.allMoviesByYear = new HashMap<>();
        this.allMoviesByGenre = new HashMap<>();
    }
    
    
    /**
     * Add each movie to the main set that contains all the movies. Then add it
     * to each of the appropiate Maps
     * 
     * @param movie 
     */
    public void addMovie(Movie movie){
        //add the movie to the allMovie set
        allMovies.add(movie);
        
        //store at allMoviesByTitle
        //create a temporary set to be used for the first time
        Set<Movie> setTitle = new TreeSet<>();
        
        //check if there is a movie with the same title
        if (getAllMoviesByTitle(movie.getTitle()) == null){
            //if not add it to the temporary set
            setTitle.add(movie);
            //and then to the Map by title
            allMoviesByTitle.put(movie.getTitle(), setTitle);
        }else{
            //if there are movies with the same title, add the new one in the 
            //set
            getAllMoviesByTitle(movie.getTitle()).add(movie);
            //then replace the old set for this title with the new one
            allMoviesByTitle.put(movie.getTitle(), 
                    getAllMoviesByTitle(movie.getTitle()));
        }
        //end adding to allMoviesByTitle
        
        
        //store at allMoviesByYear
        //create a temporary set for the first time
        Set<Movie> setYear = new TreeSet<>();
        
        //check if there is a movie in the same year
        if (getAllMoviesByYear(movie.getYear()) == null){
            //if not add it to the temporary set
            setYear.add(movie);
            //and then to the Map by year
            allMoviesByYear.put(movie.getYear(), setYear);
        }else{
            //if there are movies in the same year, add the new one in the 
            //set
            getAllMoviesByYear(movie.getYear()).add(movie);
            //then replace the old set for this year with the new one
            allMoviesByYear.put(movie.getYear(), 
            getAllMoviesByYear(movie.getYear()));
        }
        //end adding to allMoviesByYear
        
        
        //store at allMoviesByGenre
        //probably the movie belongs to more than one genre
        for(String gerneString : movie.getGenres()){
            //create a temporary set for the first time
            Set<Movie> setGenre = new TreeSet<>();
            //check if there is a movie in the same genre
            if (getAllMoviesByGenre(gerneString) == null){
                //if not add it to the temporary set
                setGenre.add(movie);
                //and then to the Map by genre
                allMoviesByGenre.put(gerneString, setGenre);
            }else{
                //if there are movies in the same genre, add the new one in the 
                //set
                getAllMoviesByGenre(gerneString).add(movie);
                //then replace the old set for this genre with the new one
                allMoviesByGenre.put(gerneString, 
                        getAllMoviesByGenre(gerneString));
            } 
            
        }//loop adding to allMoviesByGenre
    }//addMovie


    /**
     * 
     * @return a set of all Movie in sort 
     */
    public Set<Movie> getAllMovies() {
        return new TreeSet<>(allMovies);
    }

    
    /**
     * 
     * @param title
     * @return a set of all movies by the given title
     */
    public Set<Movie> getAllMoviesByTitle(String title) {
        return allMoviesByTitle.get(title);
    }

    
    /**
     * @param year
     * @return a set of all movies in the given year
     */
    public Set<Movie> getAllMoviesByYear(int year) {
        return allMoviesByYear.get(year);
    }


    /**
     * 
     * @param genre
     * @return a set of all movies by the given genre
     */
    public Set<Movie> getAllMoviesByGenre(String genre) {
        return allMoviesByGenre.get(genre);
    }
    
}//class