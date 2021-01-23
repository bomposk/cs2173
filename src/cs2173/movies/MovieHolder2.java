package cs2173.movies;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * It is slightly faster, but it does not follow the description of addMovie 
 * at the assignment
 * 
 * 
 * This class is used to populate an object that holds instances representing 
 * movies.
 * Instead off adding each time to each Map. I search in the allMovie set and 
 * then add to the Map the set that I am looking. However, this way each Map is 
 * null if it is not called or it has only the key for the filter that was 
 * apllied from the TestMovieHolder.
 * 
 * IT 
 * 
 * @author Konstantinos Bompos
 * Date: 02/28/2020
 */
public class MovieHolder2 {
    
    private Set<Movie> allMovies;
    private Map<String, Set<Movie>> allMoviesByTitle;
    private Map<Integer, Set<Movie>> allMoviesByYear;
    private Map<String, Set<Movie>> allMoviesByGenre;
    
    
    /**
     * Constructor. 
     * Initialize the variables
     */
    public MovieHolder2(){
        this.allMovies = new TreeSet<>();
        this.allMoviesByTitle = new HashMap<>();
        this.allMoviesByYear = new HashMap<>();
        this.allMoviesByGenre = new HashMap<>();
    }
    
    
    /**
     * Add each movie to the main set that contains all the movies
     * 
     * @param movie 
     */
    public void addMovie(Movie movie){
        allMovies.add(movie);
    }


    /**
     * 
     * @return a set of all Movie in sort 
     */
    public Set<Movie> getAllMovies() {
        return new TreeSet<>(allMovies);
    }

    
    /**
     * It uses setTitle to store all the movies with the given title. We 
     * iterate the allMovies set and comparing with the given title. Each 
     * movie that matches it is stored to setTitle set. Then the given title 
     * is used as a KEY, and the setTitle is used as a VALUE in the current map.
     * 
     * @param title
     * @return a set of all movies by the given title
     */
    public Set<Movie> getAllMoviesByTitle(String title) {
        
        Set<Movie> setTitle = new TreeSet<>();
        
        for (Movie movie : getAllMovies()) {
            if (movie.getTitle().equals(title)){
                setTitle.add(movie);
            }
        }
        
        allMoviesByTitle.put(title, setTitle);

        return allMoviesByTitle.get(title);
    }//getAllMoviesByTitle

    
    /**
     * It uses setYear to store all the movies in the given year. We iterate 
     * the allMovies set and comparing with the given year. Each movie that 
     * matches it is stored to setYear set. Then the given year is used as a 
     * KEY, and the setYear is used as a VALUE in the current map.
     * 
     * @param year
     * @return a set of all movies in the given year
     */
    public Set<Movie> getAllMoviesByYear(int year) {
        
        Set<Movie> setYear = new TreeSet<>();
        
        for (Movie movie : getAllMovies()) {
            if (movie.getYear() == year){
                setYear.add(movie);
            }
        }
        
        allMoviesByYear.put(year, setYear);

        return allMoviesByYear.get(year);
    }//getAllMoviesByYear


    /**
     * It uses setGenre to store all the movies by the given genre. We iterate 
     * the allMovies set and comparing each movie's genre with the given genre. 
     * We ignore cases (e.g. "Comedy" matches with "comedy"). Each movie that 
     * matches it is stored to setGenre set. Then the given genre is used as a 
     * KEY, and the setGenre is used as a VALUE in the current map.
     * 
     * @param genre
     * @return a set of all movies by the given genre
     */
    public Set<Movie> getAllMoviesByGenre(String genre) {
        
        Set<Movie> setGenre = new TreeSet<>();
        
        for (Movie movie : getAllMovies()) {
            for(String gerneString : movie.getGenres()){
                if (gerneString.equalsIgnoreCase(genre)){
                    setGenre.add(movie);
                }
            }
        }
        
        allMoviesByGenre.put(genre, setGenre);

        return allMoviesByGenre.get(genre);
    }//getAllMoviesByGenre
    
}//class