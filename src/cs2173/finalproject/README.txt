There are these classes:
-CountWords
    This class implements all the methods for this program. It initializes 
    the object, stores in the Map each word, and how many times this word 
    occurs, save the result to a CSV file and set the format of the print.
-CountUniqueWordComparator
    It used as a comparator to distinct the unique words 
-TestCountWords
    A test class for the methods in the CountWords class
-CountWordsGUI
    The GUI for the program
-MainCountWords
    The file that you should run to begin the program

How to use it:
	-The user can exit for the program through the button Exit, the menu 
         option Exit, the X icon, or by pressing Alt+F4
	-The user, in the beginning, is able to choose the source of the file 
         Local or URL via a radio button. Depends on his choice, different 
         options are available:
            -If he chooses Local File. He can open a file via a button named 
             Open, a menu option Open, or Ctrl+O. From there, the user could 
             choose the input file. The program shows the user only the TXT, 
             CSV, and XML files, but also it checks the input file with code in 
             case of the user type in the Open option.
            -If he chooses URL File, a text area is available for him to put 
             the URL of the file.
	-After that, a button name Count Words, Count Word menu option, and 
         Shift+C are available. This action tries to count the words from the 
         given input. 
            -If the file does not exist or it is empty a message, “The file 
             could not be found” is printed to the main text area. 
            -If the file has not the proper extension, a message "You can 
             process only files with extension .txt, .csv, or .xml" is printed 
             to the main text area. 
            -If the file exists, it is not empty, and it has the proper 
             extension, a message "Processing DATA..." is printed to the main 
             text are to notify the user that the input file is processed. When 
             it finishes, it displays to the user the outcome.
	-At the moment that the user has the outcome, he has a label to inform 
         him of the file’s name and the Save button, Save menu option, and 
         Ctrl+S are available to save the file. If the user decides to save the 
         file, he sets the file’s name and saves it. In case that this file 
         already exists, the program informs the user and asks him if he wants 
         to overwrite it.