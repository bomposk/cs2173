package cs2173.movies.run;

import cs2173.movies.Movie;
import cs2173.movies.MovieHolder2;
import cs2173.movies.TitleType;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 * It is used to read the online file. And test each method/filter
 * 
 * Break down each line from the online file 
 * splitLine[0] = tconst 
 * splitLine[1] = titleType
 * splitLine[2] = primaryTitle 
 * splitLine[3] = originalTitle 
 * splitLine[4] = isAdult 
 * splitLine[5] = startYear 
 * splitLine[6] = endYear 
 * splitLine[7] = runtimeMinutes 
 * splitLine[8] = genres
 *
 * @author Konstantinos Bompos 
 * Date: 02/28/2020
 */
public class TestMovieHolder2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //more meaningful name 
        int ID = 0;
        int TITLE_TYPE = 1;
        int PRIMARY_TITLE = 2;
        int IS_ADULT = 4;
        int START_YEAR = 5;
        int RUNTIME_MINUTES = 7;
        int GENRES = 8;
        String RED = "\033[0;31m";     // RED
        String GREEN = "\033[0;32m";   // GREEN

        
        /**
         * Filters - Methods
         * For each method set the boolean variable to true and any other 
         * variable if it is needed.
         */
        //display all the movies
        boolean DISLAY_ALL_MOVIES = false;  
        
        //display all the movies /w the given title
        boolean SEARCH_BY_TITLE = true;     
        String TITLE = "Total Recall";      
        
        //display all the movies in given year
        boolean SEARCH_BY_YEAR = true;
        int YEAR = 1900;
        
        //display all the movies by the given genre
        boolean SEARCH_BY_GENRE = true;
        String GENRE = "WaR";

        //Debug
        boolean DEBUG = false;

        //Source url
        String urlString = "https://datasets.imdbws.com/title.basics.tsv.gz";
//        String fileName = "input/title.basics.tsv.gz";
        
        //Create a new object
        MovieHolder2 movieHolder2 = new MovieHolder2();

        try {
            URL url = new URL(urlString);
            InputStream urlInputStream = url.openStream();
//            FileInputStream urlInputStream = new FileInputStream(fileName);
            GZIPInputStream gZIPInputStream
                    = new GZIPInputStream(urlInputStream);
            BufferedInputStream bufferedInputStream
                    = new BufferedInputStream(gZIPInputStream);
            Scanner scanner = new Scanner(bufferedInputStream);

            //skip headers of the file(1st line)
            scanner.nextLine();

            //read one line at a time
            while (scanner.hasNextLine()) {  
//            for (int i = 0; i < 100000; i++) {
                String nextLine = scanner.nextLine();
                String[] splitLine = nextLine.split("\t");

                //Convert splitLine[] to feed the constructor
                //enum titleType
                TitleType titleType
                        = TitleType.valueOf(splitLine[TITLE_TYPE].toUpperCase());

                //isAdult to boolean
                boolean adult;
                if (splitLine[IS_ADULT].equals("0")) {
                    adult = false;
                } else {
                    adult = true;
                }

                //int startYear
                int year;
                //to be sure that startYear contains only numbers
                String strYear
                        = splitLine[START_YEAR].replaceAll("[^\\d.]", "");
                try {
                    year = Integer.parseInt(strYear);
                } catch (NumberFormatException nfe) {
                    if (DEBUG) {
                        System.out.println("Bad input for YEAR at movie with "
                                + "tconst= " + splitLine[ID]);
                    }
                    //hard-coding the value in case that the year is missing
                    year = -1;
                }

                //int runtimeMinutes
                int runtimeMinutes;
                //to be sure that runtimeMinutes contains only numbers
                String strRuntimeMinutes
                        = splitLine[RUNTIME_MINUTES].replaceAll("[^\\d.]", "");
                try {
                    runtimeMinutes = Integer.parseInt(strRuntimeMinutes);
                } catch (NumberFormatException nfe) {
                    if (DEBUG) {
                        System.out.println("Bad input for RUNTIME at movie "
                                + "with tconst= " + splitLine[ID]);
                    }
                    //hard-coding the value in case that the runtime is missing
                    runtimeMinutes = -1;
                }

                //[] genres
                //In case that some movie does not have a genre. I replace the
                //\N with a more meaningful string
                String strGernes
                        = splitLine[GENRES].replace("\\N", "UNKNOWN");
                //convert genres to a array by spliting at ","
                String[] genres = strGernes.split(",");

                //Built Object Movie by avoiding if it is an Adult movie
                if (!(adult)) {
                    Movie movie = new Movie(titleType,
                            splitLine[PRIMARY_TITLE],
                            adult,
                            year,
                            runtimeMinutes,
                            genres);

                    //store each movie to each set
                    movieHolder2.addMovie(movie);
//                    System.out.println(movie);
                }
            }//loop reading file

            //Release all resources
            scanner.close();
            bufferedInputStream.close();
            gZIPInputStream.close();
            urlInputStream.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(TestMovieHolder2.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestMovieHolder2.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        //Display results - Use filters
        //Display all
        if (DISLAY_ALL_MOVIES) {
            System.out.println(GREEN + "Display all the Movies");
            //if the set is empty print a message
            if (movieHolder2.getAllMovies().isEmpty()) {
                System.out.println(RED + "There are no Movies in the set");
            } else {
                for (Movie movie : movieHolder2.getAllMovies()) {
                    System.out.println(movie);
                }
            }
        }//diplay all movies

        //Filter by Title
        if (SEARCH_BY_TITLE) {
            System.out.println(GREEN + "Display movies with title: " + TITLE);
            //if the set is empty print a message
            if (movieHolder2.getAllMoviesByTitle(TITLE).isEmpty()) {
                System.out.println(RED + "There are not movies with tilte: " 
                        + TITLE);
            } else {
                for (Movie movie : movieHolder2.getAllMoviesByTitle(TITLE)) {
                    System.out.println(movie);
                }
            }
        }//display by title
        
        //Filter by Title
        if (SEARCH_BY_YEAR) {
            System.out.println(GREEN + "Display movies in the year: " + YEAR);
            //if the set is empty print a message
            if (movieHolder2.getAllMoviesByYear(YEAR).isEmpty()) {
                System.out.println(RED + "There are not movies in the year: " 
                        + YEAR);
            } else {
                for (Movie movie : movieHolder2.getAllMoviesByYear(YEAR)) {
                    System.out.println(movie);
                }
            }
        }//display by year
        
        //Filter by Genre
        if (SEARCH_BY_GENRE) {
            System.out.println(GREEN + "Display movies at category: " + GENRE);
            //if the set is empty print a message
            if (movieHolder2.getAllMoviesByGenre(GENRE).isEmpty()) {
                System.out.println(RED + "There are not movies at category: " 
                        + GENRE);
            } else {
                for (Movie movie : movieHolder2.getAllMoviesByGenre(GENRE)) {
                    System.out.println(movie);
                }
            }
        }//display by genre

    }//main

}//class
