

/**
 * This class contains function that translate English text into 
 * Pig Latin. This includes words with apostrophes in them. 
 * 
 * (If an apostrophe is sandwiched between at least two letters, 
 * the program will consider it part of the word. If there's 
 * something other than a letter directly on either side of the 
 * apostrophe, the program registers it as seperate from all of
 * the words near it.)
 * 
 * The client can prompt the translation by calling the translate
 * function and passing it a String containing what they want the
 * program to translate.
 *
 * @Fe Jackson
 * @05-29-2021
 */

public class PigLatinTranslator
{
    //constructor
    public PigLatinTranslator()
    {
    }
    
    //translate function
    public String translate (String translateFrom)
    {
        String translation = new String (); 
        
        int size = translateFrom.length ();
        
        boolean caseChange = false;

        
        char testChar1 = ' ';
        char testChar2 = ' ';
        
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        
        while (index3 < size)
        {
            testChar1 = translateFrom.charAt(index3);
            
            while(index3 < size && isLetterOrAp (testChar1).compareTo ("letter") != 0)
            {
                ++index3;
                if (index3 < size)
                {
                    testChar1 = translateFrom.charAt (index3);
                }
            }
            
            translation += translateFrom.substring (index1, index3);
            
            if (index3 < size)
            {
                index1 = index3;
            
                testChar1 = translateFrom.charAt (index3);
                
                while (index3 < size && isLetterOrAp (testChar1).compareTo ("letter") == 0)
                {
                    ++index3;
                    if (index3 < size)
                    {
                        testChar1 = translateFrom.charAt (index3);
                    }
                }
           
                if (index3 < (size - 1))
                {
                    testChar1 = translateFrom.charAt (index3);
                    testChar2 = translateFrom.charAt (index3 + 1);
                }
            
                //increment index3 while it's an apostrophe, not the last index, and the following index is a letter
                while (index3 < (size - 1) && isLetterOrAp(testChar1).compareTo ("'") == 0 
                    && isLetterOrAp(testChar2).compareTo("letter") == 0)
                {
                    ++index3;
                    testChar1 = translateFrom.charAt (index3); 
                    
                    while (index3 < size && isLetterOrAp (testChar1).compareTo ("letter") == 0)
                    {
                        ++index3;
                        if (index3 < size)
                        {
                            testChar1 = translateFrom.charAt (index3);
                        }
                    }
                    
                    if (index3 < (size - 1))
                    {
                        testChar2 = translateFrom.charAt (index3 + 1);
                    }
                }
                
                index2 = index1; 
                testChar1 = translateFrom.charAt (index2);
            
                while(index2 < (index3 - 1) && isVowel (testChar1) == false)
                {
                    ++index2;
                    if (index2 < index3)
                    {
                        testChar1 = translateFrom.charAt (index2);
                    }
                }
            
                if (index2 == index1)
                {
                    translation += translateFrom.substring (index1, index3);
                }
                else if (index2 != index3)
                {
                    if (Character.isUpperCase(translateFrom.charAt (index1)) == true &&
                        Character.isLowerCase(translateFrom.charAt (index2)) == true)
                    {
                        caseChange = true;
                    }
                
                    if (caseChange == true)
                    {
                        translation += Character.toUpperCase (translateFrom.charAt (index2));
                    
                        if (index2 < (index3 - 1))
                        {
                            translation += translateFrom.substring (index2 + 1, index3);
                        }
                    
                        translation += Character.toLowerCase (translateFrom.charAt (index1));
                    
                        if (index1 < (index2 - 1))
                        {
                            translation += translateFrom.substring (index1 + 1, index2);
                        }
                    
                        caseChange = false;
                    }
                    
                    else
                    {
                        translation += translateFrom.substring (index2, index3);
                        translation += translateFrom.substring (index1, index2);
                    }
                }
                
                translation += "ay";
                
                index1 = index3;
            }
        }
        
        return translation;
    }

    
    public boolean isVowel (char toCalculate)
    {
        boolean tf = false;
        
        if (toCalculate == 'a' || toCalculate == 'A' ||
            toCalculate == 'e' || toCalculate == 'E' ||
            toCalculate == 'i' || toCalculate == 'I' ||
            toCalculate == 'o' || toCalculate == 'O' ||
            toCalculate == 'u' || toCalculate == 'U' ||
            toCalculate == 'y' || toCalculate == 'Y')
        {
            tf = true;
        }   
           
        return tf;
    }
    
    String isLetterOrAp (char toCalculate)
    {
        String answer = new String ();
        
        if (Character.isLetter(toCalculate) == true)
        {
            answer = "letter";
        }
        else if (Character.toString (toCalculate).compareTo ("'") == 0)
        {
            answer = "'";
        }
            
        else
        {
            answer = "neither";
        }
        
        return answer;
    }
}
