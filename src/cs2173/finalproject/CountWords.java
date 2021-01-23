package cs2173.finalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It takes file and count how many time each word exits. A “word” in this case 
 * consists only of letters – no numbers or special characters.
 *
 * @author Konstantinos Bompos 
 * Date: 03/06/2020
 */
public class CountWords {

    private URL inputURL;
    private File inputFile;
    private File outputFile;
    private Map<String, Integer> uniqueWords;

    
    /**
     * Constructor. 
     * Initialize the variables
     */
    public CountWords() {
        this.uniqueWords = new HashMap<>(); 
    }

    
    /**
     * It removes all the variables in the Map
     */
    public void clearCounts() {
        uniqueWords.clear();
    }
    
    
    /**
     * It receives an input that is the file that will count the words. This 
     * file could be a local file or a URL file, the distinction is made based 
     * on the string "http".
     * Then it updates the Map with the different words and how many times each 
     * word occurs.
     * 
     * @param input --> the file that we want to count
     */
    public void addWords(String input) {
        
        //check if the given input is URL or Local File
        boolean isURL = input.contains("http");
        
        String[] words;
    
        Scanner scanner;
        try {
            //It depends if it is URL or not, it constructs the object and 
            //initializes the scanner.
            if (isURL){
                inputURL = new URL(input);
                scanner = new Scanner(inputURL.openStream());
            }else{
                inputFile = new File(input);
                scanner = new Scanner(inputFile);
            }
            
            //looping each line, replace special characters and numbers, break 
            //the line to words and store them.
            while ((scanner.hasNextLine())) {
                String line = scanner.nextLine();
                
                //replace special characters and numbers with "space"
                line = line.replaceAll("[\\W\\d_]+", " ");
                //splits each line to words using the space delimeter
                words = line.split(" ");
                for (String word : words) {
                    word = word.trim();
                    
                    //for each word in the line check if the size is gt 0 and 
                    //ignore it if not
                    if (word.length() > 0) {
                        if (uniqueWords.containsKey(word)){
                            int oldCount = uniqueWords.get(word);
                            uniqueWords.put(word, oldCount + 1);
                        }else{
                            //the first time a word occurs
                            uniqueWords.put(word, 1);
                        }
                    }//(word.length() > 0
                }//loop check each word in the line
            }// while reading lines
            
            //Release all resources
            scanner.close();
            
        } catch (IOException ex) {
            Logger.getLogger(CountWords.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("The file could not be found");
        }
    }//addWords()

    
    /**
     * 
     * @return a Map of all words 
     */
    public Map<String, Integer> getUniqueWords() {
        return new HashMap<>(uniqueWords);
    }

    
    /**
     * 
     * @return the current size of the Map 
     */
    public int getUniqueWordsCount() {
        return uniqueWords.size();
    }
    
    
    /**
     * It saves the result in a csv form and to a csv file
     * 
     * @param output --> the name of the file that we will save the results
     */
    public void saveFile(String output) {
        //add the extension csv to be sure that the file will be saves as a csv 
        //file
        outputFile = new File(output + ".csv");
        
        SortedMap<String, Integer> sortedWordCounts =
                new TreeMap<>(new CountUniqueWordComparator());
        
        sortedWordCounts.putAll(uniqueWords);
        
        try {
            //The FileWriter connects to the File
            FileWriter fileWriter = new FileWriter(outputFile);
            //BufferedWriter writes to a buffer and flushes it when full.
            //This is more efficient than writing each time
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String word : sortedWordCounts.keySet()) {
                bufferedWriter.append(String.format("%s,%d", 
                        word, sortedWordCounts.get(word)));
                bufferedWriter.newLine();
            }
            //Release all resources
            bufferedWriter.close();
            System.out.printf("%s written!%n", outputFile.getAbsoluteFile());
        } catch (IOException ex) {
            Logger.getLogger(CountWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//saveFile
    
    @Override
    /**
     * It formats the way that the results will be displayed. If the Map is 
     * empty it displays the message "The file could not be found.", if not
     * it displays the "word" -> "frequency"
     */
    public String toString() {
        String outputUniqueCountString = "";
        
        //check if the Map is empty or not
        if (getUniqueWordsCount()>0){
            
            outputUniqueCountString += "Unique Words    -->    Frequency:";
            SortedMap<String, Integer> sortedWordCounts =
                new TreeMap<>(new CountUniqueWordComparator());
        
            sortedWordCounts.putAll(uniqueWords);

            //add each unique to the string
            for (String word : sortedWordCounts.keySet()) {
                outputUniqueCountString += String.format("\n%s    -->    %,d", 
                        word, sortedWordCounts.get(word));
            }
        }else{
            outputUniqueCountString += "The file could not be found.";
        }
            
        return outputUniqueCountString;
    }//toString

}//class
