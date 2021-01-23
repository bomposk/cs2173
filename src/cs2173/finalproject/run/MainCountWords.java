package cs2173.finalproject.run;

import cs2173.finalproject.CountWordsGUI;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * It is a main class that it runs the GUI
 * 
 * @author Konstantinos Bompos
 * Date: 03/06/2020
 */
public class MainCountWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //This call will set the look and feel to whatever operating system
        //the program is being run on
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainCountWords.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        JFrame countWordsGUI = new CountWordsGUI();
        //Here we will center the frame on the screen. This code will work
        //regardless of the size of the screen ion which it is run
        int frameWidth = 1100;
        int frameHeight  = 700;
        countWordsGUI.setSize(frameWidth, frameHeight);
        
        //This gives us the screen size in a Dimension object
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        //This will give us coordinates that will center the frame
        int xLoc = (screenDim.width - frameWidth) / 2;
        int yLoc = (screenDim.height - frameHeight) / 2;
        countWordsGUI.setLocation(xLoc, yLoc);
        
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                countWordsGUI.setVisible(true);
            }
        });
    }//main
}//class
