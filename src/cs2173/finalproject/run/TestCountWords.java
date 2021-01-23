package cs2173.finalproject.run;

import cs2173.finalproject.CountWords;

/**
 * It used to test CountWords that it is able to read for a local file or a URL.
 * And then display and save the results for each word exists to the text.
 * 
 * @author Konstantinos Bompos
 * Date: 03/06/2020
 */
public class TestCountWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //File or URL
//        String site = "https://www.gutenberg.org/files/219/219-0.txt";
        String site = "C:\\Users\\KostAS\\OneDrive - Naval Postgraduate "
                + "School\\6th Qrt\\CS2173 - Buss\\Assignments\\Final "
                + "Project\\small.txt";        
            
        //String outputfile
        String fileName = "CountWords.csv";

        //constructs the object
        CountWords countWords = new CountWords ();

        //reads the object
        countWords.addWords(site);

        System.out.println("Input: " + site);

        //returns the results
        System.out.println(countWords);
        
//        int uniqueWordsCount = countWords.getUniqueWordsCount();
//
//            if (uniqueWordsCount > 0) {
//                System.out.println(uniqueWordsCount + " unique words");
//            } else {
//                System.out.println("No words");
//            }
        
        //save the results
        countWords.saveFile(fileName);

    }//main
}//class