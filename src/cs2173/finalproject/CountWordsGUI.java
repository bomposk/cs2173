package cs2173.finalproject;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import java.awt.Color;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This is a GUI file that it used to interact between the user and the class
 * CountWords.
 * 
 * @author Konstantinos Bompos
 * Date: 03/06/2020
 */
public class CountWordsGUI extends JFrame {

    //Graphical
    private JPanel inputPanel;
    private ButtonGroup inputGroup;
    private JRadioButton localJRadioButton;
    private JButton openFileButton;
    private JRadioButton urlJRadioButton;
    private JTextField urlTextField;
    private JButton countWordsButton;
    private JButton exitButton;
    private JLabel fileNameLabel;
    private JButton saveButton;
    private JTextArea textArea;

    //menubar
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openMenuItem;
    JMenuItem saveMenuItem;
    JMenuItem exitMenuItem;
    JMenu countMenu;
    JMenuItem countMenuItem;

    //Action Listeneres
    private WindowCloser windowCloser;
    private DisplayRadioChoices displayRadioChoices;
    private OpenFileAction openFileAction;
    private CountActionListener countActionListener;
    private SaveActionListener saveActionListener;

    private CountWords countWords;

    private File chosenFile;
    private JFileChooser openFileChooser;

    /**
     * Instantiate FileChooserDemo and initialize all components
     */
    public CountWordsGUI() {
        super("Word Counting");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        initComponents();
        initMenuBar();
    }

    /**
     * Instantiate buttons and set ActionListeners
     */
    private void initComponents() {
        //Action Listeneres
        windowCloser = new WindowCloser();
        this.addWindowListener(windowCloser);
        displayRadioChoices = new DisplayRadioChoices();
        openFileAction = new OpenFileAction();
        countActionListener = new CountActionListener();
        saveActionListener = new SaveActionListener();

        setLayout(new BorderLayout());

        //NORTH LAYOUT
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 20, 20));

        //1st Row
        localJRadioButton = new JRadioButton("Local Files:", true);
        inputPanel.add(localJRadioButton);
        localJRadioButton.addActionListener(displayRadioChoices);

        openFileButton = new JButton("Open");
        inputPanel.add(openFileButton);
        openFileButton.addActionListener(openFileAction);        

        //2nd Row
        urlJRadioButton = new JRadioButton("URL Files:");
        inputPanel.add(urlJRadioButton);
        urlJRadioButton.addActionListener(displayRadioChoices);

        urlTextField = new JTextField();
        inputPanel.add(urlTextField);
        urlTextField.setVisible(urlJRadioButton.isSelected());
        urlTextField.addActionListener(displayRadioChoices);

        //3rd Row
        countWordsButton = new JButton("Count Words");
        inputPanel.add(countWordsButton);
        countWordsButton.addActionListener(countActionListener);
        countWordsButton.setVisible(false);

        exitButton = new JButton("Exit");
        inputPanel.add(exitButton);
        exitButton.addActionListener(windowCloser);

        //4th Row
        fileNameLabel = new JLabel("fileNameLabel", SwingConstants.CENTER);
        inputPanel.add(fileNameLabel);
        fileNameLabel.setVisible(false);

        saveButton = new JButton("Save");
        inputPanel.add(saveButton);
        saveButton.addActionListener(saveActionListener);
        saveButton.setVisible(false);

        getContentPane().add(inputPanel, NORTH);

        //Group Radio Buttons
        inputGroup = new ButtonGroup();
        inputGroup.add(localJRadioButton);
        inputGroup.add(urlJRadioButton);

        //Display Area
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, CENTER);
        
        //Open file options
        openFileChooser = new JFileChooser();
        openFileChooser.setAcceptAllFileFilterUsed(false);
        openFileChooser.addChoosableFileFilter(
                new FileNameExtensionFilter("Text File (*.txt)", "txt", "TXT"));
        openFileChooser.addChoosableFileFilter(
                new FileNameExtensionFilter("CSV File (*.csv)", "csv", "CSV"));
        openFileChooser.addChoosableFileFilter(
                new FileNameExtensionFilter("XML File (*.xml)", "xml", "XML"));

        //Object
        countWords = new CountWords();
    }//initComponents
    
    /**
     * Instantiate and configure the JMenuBar.
     */
    private void initMenuBar(){
        //menubar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        //File Options
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        menuBar.add(fileMenu);

        openMenuItem = new JMenuItem("Open");
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                Event.CTRL_MASK));
        openMenuItem.addActionListener(openFileAction);
        openMenuItem.setEnabled(true);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Event.CTRL_MASK));
        saveMenuItem.addActionListener(saveActionListener);
        saveMenuItem.setEnabled(false);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                Event.ALT_MASK));
        exitMenuItem.addActionListener(windowCloser);
        fileMenu.add(exitMenuItem);
        
        //Count Options
        countMenu = new JMenu("Count");
        countMenu.setMnemonic('C');
        menuBar.add(countMenu);

        countMenuItem = new JMenuItem("Count Words");
        countMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.SHIFT_MASK));
        countMenuItem.addActionListener(countActionListener);
        countMenuItem.setEnabled(false);
        countMenu.add(countMenuItem);
    }//initMenuBar

    /**
     * It is used to reset all the compoents in the frame when ever it needs 
     */
    private void reset() {
        fileNameLabel.setVisible(false);
        saveButton.setVisible(false);
        saveMenuItem.setEnabled(false);
//        textArea.setEditable(true);
        textArea.setText("");
//        textArea.setEditable(false);
        countWords.clearCounts();
    }



/////////////////////      DisplayRadioChoices      ///////////////////////////
    /**
     * It is used to manage what component is visible depends on the radio 
     * buttons.
     * When the user chooses a local file:
     * -Can select only OPEN and EXIT
     * When the user selects a URL file:
     * -Can select only EXIT and set the URL. If the length of the URL is >0, 
     * then the COUNT is available
     */
    private class DisplayRadioChoices implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            openFileButton.setVisible(localJRadioButton.isSelected());
            openMenuItem.setEnabled(localJRadioButton.isSelected());
            urlTextField.setVisible(urlJRadioButton.isSelected());

            //Display countButton if he have select URL and we have text in the
            //field. If the user has select Local Files it will be visable 
            //after the OpenFileAction class
            boolean countButtonBoolean = (urlJRadioButton.isSelected()
                    && urlTextField.getText().length() > 0);
            countWordsButton.setVisible(countButtonBoolean);
            countMenuItem.setEnabled(countButtonBoolean);

            //in case there is a successful previous display
            reset();
        }
    }//DisplayRadioChoices



/////////////////////      OpenFileAction      ///////////////////////////
    /**
     * An instance of OpenFileAction will listen for the user's request to open
     * a file.
     */
    private class OpenFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Display open dialog
            int result = openFileChooser.showOpenDialog(CountWordsGUI.this);
            //If user "approves" - otherwise do nothing
            if (result == APPROVE_OPTION) {
                chosenFile = openFileChooser.getSelectedFile();

                //In case that we previous use count for URL
                //Clear urlTextField.
                CountWordsGUI.this.urlTextField.setText("");
                //Hide fileNameLabel and saveButton
                reset();
                
                //open is triggered only for local files
                countWordsButton.setVisible(localJRadioButton.isSelected());
                countMenuItem.setEnabled(localJRadioButton.isSelected());
            }
        }//OpenFileAction actionPerformed
    }//OpenFileAction



/////////////////////      CountActionListener      ///////////////////////////   
    /**
     * An instance of CountActionListener will listen for the user's request to 
     * count the words in the file.
     * If it is successful the user will have available the SAVE button.
     */
    private class CountActionListener implements ActionListener, Runnable {

        //This will be a single-thread executor for counting the file
        private ExecutorService executorService;

        @Override
        public void actionPerformed(ActionEvent e) {
            executorService = Executors.newSingleThreadExecutor();
            executorService.submit(this);

            //clear in case there is already a previous success counting
            countWords.clearCounts();

            //display - during the programm create the Map with the words from
            //class CountWords
            textArea.setEnabled(true);
            textArea.setForeground(Color.green);
            textArea.setText("Processing DATA...");
        }//actionPerformed  

        @Override
        public void run() {
            //calculate the words
            //Depends on the radio button the program feeds the addWords method 
            //with the appropriate input
            if (localJRadioButton.isSelected()) {
                countWords.addWords(chosenFile.toString());
            } else {
                countWords.addWords(urlTextField.getText());
            }

            //display the results
            textArea.setText(countWords.toString());
            textArea.setCaretPosition(0);

            //extract extension
            //if it is local the files names is contained here 
            //chosenFile.getName(). If it is URL here urlTextField.getText()
            String localExtension = "";
            String urlExtension = "";

            if (localJRadioButton.isSelected()) {
                int localIndexOfDot = chosenFile.getName().lastIndexOf('.');
                localExtension = chosenFile.getName().
                        substring(localIndexOfDot + 1);
            } else {
                int urlIndexOfSlash = urlTextField.getText().lastIndexOf('.');
                urlExtension = urlTextField.getText().
                        substring(urlIndexOfSlash + 1);
            }

            //validate extension
            //Our program should accept only txt, xml and csv.
            if ((localExtension.toLowerCase().contains("txt"))
                    || (localExtension.toLowerCase().contains("xml"))
                    || (localExtension.toLowerCase().contains("csv"))
                    || (urlExtension.toLowerCase().contains("txt"))
                    || (urlExtension.toLowerCase().contains("xml"))
                    || (urlExtension.toLowerCase().contains("csv"))) {

                //check if the Map is empty or not
                if (countWords.getUniqueWordsCount() > 0) {
                    textArea.setForeground(Color.black);

                    //diplsay the name of the file in the fileNameLabel
                    if (localJRadioButton.isSelected()) {
                        CountWordsGUI.this.fileNameLabel.
                                setText(chosenFile.getName());
                    } else {
                        int indexOfSlash = urlTextField.getText().
                                lastIndexOf('/');
                        String urlFileName = urlTextField.getText().
                                substring(indexOfSlash + 1);
                        CountWordsGUI.this.fileNameLabel.setText(urlFileName);
                    }

                    //set visable the fileNameLabel and the SAVE (menu and 
                    //button)
                    fileNameLabel.setVisible(true);
                    fileNameLabel.setForeground(Color.blue);
                    saveButton.setVisible(true);
                    saveButton.setForeground(Color.blue);
                    saveMenuItem.setEnabled(true);
                    
                } else {
                    textArea.setForeground(Color.red);
//                    textArea.setText("The file could not be found.");
                }//countWords.getUniqueWordsCount() > 0
                
            } else {
                //error message in case that our file has not the right 
                //extension
                textArea.setForeground(Color.red);
                textArea.setText("You can process only files with extension "
                        + ".txt, .csv, or .xml");
            }//extension  
        }//run CountActionListener 
    }//CountActionListener    
    


///////////////////////     SaveActionListener      /////////////////////////// 
    /**
     * An instance of this class will prompt the user for a file to save the
     * text in the textArea to a file - when the actionPerformed method is
     * invoked.
     */
    private class SaveActionListener implements ActionListener, Runnable {

        //This will be a single-thread executor for writing the file
        private ExecutorService executorService;

        //This will prompt the user for the name of a file to save
        private JFileChooser saveFileChooser;


        @Override
        public void actionPerformed(ActionEvent e) {
            if (saveFileChooser == null) {
                saveFileChooser = new JFileChooser();
            }

            //show to the user only the csv files
            saveFileChooser.setAcceptAllFileFilterUsed(false);
            saveFileChooser.addChoosableFileFilter(
                    new FileNameExtensionFilter("CSV File (*.csv)", "csv", 
                            "CSV"));

            int result = saveFileChooser.showSaveDialog(CountWordsGUI.this);
            if (result == APPROVE_OPTION) {
                if (executorService == null) {
                    executorService = Executors.newSingleThreadExecutor();
                }
                executorService.submit(this);
            }
        }//save actionPerformed

        /**
         * Get the selected File from the saveFileChooser. Check if the given
         * name/file already exist and warn the user if he want to overwrite 
         * it and and procees only if the user agrees. Then save the results to 
         * the given file/name
         */
        @Override
        public void run() {
            String csvExtension = ".csv";
            
            //get the name of the given file and extension csv
            //if the user select an exist csv file
            int indexOfDot = saveFileChooser.getSelectedFile().toString().
                    lastIndexOf(csvExtension);
            
            String nameSavedFile = "";
            //check if the found .csv is extension or just a substring in the
            //main string
            //Index position of index == lenght of string - 4(length of .csv) ->
            //means that the .csv is in the end of the string -->IS A EXTENSION
            if (indexOfDot == (saveFileChooser.getSelectedFile().toString().
                    length() - csvExtension.length())){
                nameSavedFile = saveFileChooser.getSelectedFile().toString();
//                nameSavedFile = saveFileChooser.getSelectedFile().toString().
//                        substring(0, indexOfDot) + ".csv";
            }else{
                //.csv is not an extension. Add it in the end
                nameSavedFile = saveFileChooser.getSelectedFile().toString()
                        + csvExtension;
            }

            //create an object file with the nameSavedFile in order to 
            //compare later if this file already exist
            File fileName = new File(nameSavedFile);

            //Check if the given file already exist. If yes ask the user
            //if he wants to overwrite it
            if (fileName.exists()) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to replace the existing file?",
                        "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                //Response-->Not Yes.... Do nothing + close pop-up
                if (response != JOptionPane.YES_OPTION) {
                    return;
                }
                //Response-->Yes 
                countWords.saveFile(saveFileChooser.getSelectedFile().
                        toString());
            } else {
                countWords.saveFile(saveFileChooser.getSelectedFile().
                        toString());
            }//fileName.exists()
        }//run SaveActionListener
    }//SaveActionListener



////////////////////////////      WindowCloser      ///////////////////////////
    /**
     * An instance of this class will manage all attempts to close the program
     * by requesting confirmation from the user
     */
    private class WindowCloser extends WindowAdapter implements WindowListener,
            ActionListener {

        /**
         * Simply call confirmExit()
         *
         * @param e Heard ActionEvent
         */
        @Override
        public void windowClosing(WindowEvent e) {
            confirmExit();
        }

        /**
         * Simply call confirmExit()
         *
         * @param e Heard ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            confirmExit();
        }

        /**
         * Display the confirmation dialog and only exit if user "OK's" it
         */
        private void confirmExit() {
            int result = JOptionPane.showConfirmDialog(CountWordsGUI.this,
                    "Really Exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
    }//WindowCloser

}//class WordCountGUI