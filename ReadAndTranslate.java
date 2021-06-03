
/**
 * This class has the main function in it. It tries to find and 
 * read a file whose path matches the first String argument passed
 * to main. 
 * 
 * If no exception is thrown, it uses the PigLatinTranslator
 * class to translate all the text in the file that it reads.
 * 
 * If there is an exception thrown, it prompts the user to type
 * in text. Then, it translates the text the user gave it and 
 * displays it. Finally, it asks the user if they want to 
 * translate more text. If the user types "yes", then the process 
 * explained in this paragraph repeats. If the user types "no", 
 * then the program thanks the user, says goodbye, and ends.
 *
 * @Fe Jackson
 * @05-29-2021
 */

import java.util.Scanner;
import java.io.File;

public class ReadAndTranslate extends PigLatinTranslator
{
       public static void main (String [] args)
    {
        PigLatinTranslator translator = new PigLatinTranslator ();
        String line = " ";
        String again = " ";
        
        try
        {
            Scanner sc = new Scanner (new File (args [0]));
            
            while (sc.hasNextLine ())
            {
                line = sc.nextLine ();
                System.out.println (translator.translate (line));
            }
        }
        catch (Exception e)
        {
            Scanner sc2 = new Scanner (System.in);
            System.out.println ("Welcome to The Pig Latin Translator!");
            
            do
            {
                System.out.println ("Please type in a line that you want to translate followed by the Enter key.");
                line = sc2.nextLine ();
                System.out.println ("Translation:");
                System.out.println (translator.translate (line));
                
                System.out.println ("Would you like to translate another line of text?");
                
                do
                {
                    System.out.println ("Please type \"yes\" or \"no\" followed by the Enter key.");
                        
                    again = sc2.nextLine ();
                    again = again.toLowerCase ();
                    
                } while (again.compareTo ("yes") != 0 && 
                    again.compareTo ("no") != 0);
                    
            } while (again.compareTo ("yes") == 0);
            
            System.out.println ("Thank you! Goodbye!");
        }
    }
}
