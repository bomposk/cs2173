package cs2173.words.run;

import cs2173.words.UniqueWords;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It used to test UniqueWords. It display the # of the unique words and the
 * unique words
 * 
 * @author Konstantinos Bompos
 * Date: 02/21/2020
 */
public class TestUniqueWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String site = "https://www.gutenberg.org/files/219/219-0.txt";
        String startString = "By Joseph Conrad";
        String endString = "End of the Project Gutenberg EBook of Heart of "
                + "Darkness, by Joseph Conrad";
        
        try {
            //constructs the URL 
            URL input = new URL(site);
            
            //constructs the object
            UniqueWords uniqueWords = new UniqueWords (input, startString, 
                    endString);
            //reads the object
            uniqueWords.readWords();
            
            System.out.println("Input: " + site);
            //returns the results
            System.out.println("Unique Words:" + uniqueWords);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestUniqueWords.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
    }//main
    
}//class