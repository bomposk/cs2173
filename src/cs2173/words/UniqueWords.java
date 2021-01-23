package cs2173.words;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It takes a plain text file and find the unique words in it between a
 * beginning and an ending String. A “word” in this case consists only of
 * letters – no numbers or special characters.
 *
 * @author Konstantinos Bompos 
 * Date: 02/21/2020
 */
public class UniqueWords {

    private URL input;
    private SortedSet<String> uniqueWords;
    private String startString;
    private String endString;
    private boolean inText;

    
    // Constructor
    /**
     * Initialize the variables
     * 
     * @param input
     * @param startString
     * @param endString 
     */
    public UniqueWords(URL input, String startString, String endString) {
        this.input = input;
        this.startString = startString;
        this.endString = endString;
        //Here is my comparator in order to be more case-sensitivity 
//        this.uniqueWords = new TreeSet<>(new UniqueWordComparator());
        //This is the comparator that we used in class.
        //I used that because the given sample is not case-sensitivity
        //Sample -> "Resources > Handouts > Heart of Darkness.txt"
        this.uniqueWords = new TreeSet<>(new AlphabeticalComparator());
        this.inText = false;
    }

    
    /**
     * The unique words are calculates approximately.
     * The reason is that the the author uses contractions and a lot - between 
     * words. 
     * 
     * I decided to check each line and replace any special character with 
     * "space" and then implement trim() for each word. The disadvantage to 
     * this approach is that any contraction will be separated, and it will 
     * create unique words that not exist (e.g., "You've" --> "You" and "ve", 
     * "accountant's" --> "accountant" and "s", etc.). But in reality, "ve" and 
     * "s" are not words. 
     * With this approach, the result is 5,420 unique words.
     * 
     * I did not choose to replace any special character with "nothing" because 
     * the author uses a lot "-" between words. This will cause store as unique 
     * words, words like "abovethe" (from "above-the") wherein reality are 2 
     * words. 
     * With this approach, the result is 6,024 unique words by far more 
     * than the true result, and for that, I decided the previous approach.
     * 
     * 
     * It start reading the document until it meets the strartString. After that
     * check each line if contains the endString. If not replace each special
     * character or number with "space" in the line. Break each line to words 
     * which are seperated by space and store them to the set
     * 
     */
    public void readWords() {
        
        Scanner scanner;
        try {
            scanner = new Scanner(input.openStream());

            //looping each line until it finds the startString
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                //exits from the loop
                if (line.contains(startString)) {
                    inText = true;
                    break;
                }
            }//while find the beginning

            //looping each line, replace special characters and numbers, break 
            //the line to words and store them until it finds the endString
            while ((scanner.hasNextLine())) {
                String line = scanner.nextLine();

                //exits from the loop
                if (line.contains(endString)) {
                    inText = false;
                    break;
                }
                
                //replace special characters and numbers with "space"
                line = line.replaceAll("[\\W\\d_]+", " ");
                //splits each line to words using the space delimeter
                String[] words = line.split(" ");
                for (String word : words) {
//                    word = word.replaceAll("[\\W\\d_]+", " ");
                    //for each word in the line check if the size is gt 0 and 
                    //if this is true remove any whitespace and store the word 
                    //in the set
                    if (word.length() > 0) {
                        uniqueWords.add(word.trim());
                    }
                }
            }// while storing the words
            
            scanner.close();
            
        } catch (IOException ex) {
            Logger.getLogger(UniqueWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//readWords()

    
    /**
     * 
     * @return the number/size of the unique words
     */
    public int getUniqueWordsCount() {
        return getUniqueWords().size();
    }

    
    /**
     * @return the uniqueWords
     */
    public SortedSet<String> getUniqueWords() {
        return uniqueWords;
    }
    

    /**
     * 
     * @return The number of the unique and the unique words
     */
    @Override
    public String toString() {
        String outputUniqueString = "";

        //add each unique to the string
        for (String word : getUniqueWords()) {
            outputUniqueString += "\n" + word;
        }
        
        return outputUniqueString;

//        return String.format("The number of the unique words is: %,d. "
//                + "\nAnd here are the unique words:" + outputUniqueString,
//                getUniqueWordsCount());
    }

}//class
