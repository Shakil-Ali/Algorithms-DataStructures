// Public class ListVisualiser 
public class ListVisualiser {
    
    // Initialise SLList pum, which will be iterated below
    SLList pum;

    // Initialise SLList for checking pum SLList
    SLList searchList;
    
    // Constructor called ListVisualiser, which has one parameter 'l'
    public ListVisualiser(SLList l) { 
        // Assign SLList pum with argument SLList l
        pum = l;
    }
    
    // Method for visualising the linked list
    public void visualise() {

        // Conditional if statement to check if SLList is empty
        if(pum == pum.NIL)
        {
            // Print statement to show 
            System.out.println("Empty List");
            // Return statement
            return;
        }

        // Conditional if statement to check for loops in SLList
        if(loopExists(pum)) 
        {
            // Print statement to say loop has been found 
            System.out.println("Loop detected");
            // Return statement
            return;
        }
        // Else conditional statement if no loop has been found
        else 
        {

            // Print statement for no loop detected
            System.out.println("No Loop Detected");
        }


        // Variable 'len' used to store the length of the SLList pum
        int len = pum.length();

        // Conditional if statement to check if the SLList length is greater than 5
        if(len > 5 || large_num(pum))
        {
            // For loop to iterate through SLList pum
            for(int h = 0; h < len; h++) 
            {
                // Conditional to check if at the last element
                if(SLList.NIL == pum.rest()) 
                {
                    // Print statement for last element
                    System.out.println("["+pum.first+"|/]");
                } 
                // Conditional else statement for all other elements
                else 
                {
                    // Prints format for other elements (excludes final element)
                    System.out.print("["+pum.first+"|*]->");
                    // set the SLList to the rest of its SLList
                    pum = pum.rest();
                }
            }    
        }
        // Else condition
        else 
        {
            // Print statment so that the linked list starts a 'tab' space to the right each time
            System.out.print("\t");

            // For loop going through the elements of the SLList pum
            for (int i = 0; i < len; i++) 
            {
                // Conditional if statement to check if we are iterating the last element
                if (i == len-1) 
                {
                    // Prints out the specific last instance box for the linked list
                    System.out.println("[*|/]");
                } 
                // Conditionl else statement for all other instances except for the last element
                else 
                {
                    // Prints visual for all other elements in linked list (excludes last element)
                    System.out.print("[*|*]-->");
                }
            }


            // For loop going through the elements of the SLList pum
            for (int j = 0; j < len; j++) 
            {
                // Conditional if statement to check if we are iterating the last element
                if (j == len-1) 
                {
                    // Prints the case for the last element in the linked list
                    System.out.println("\t |");
                }
                // Conditional else statement for all other elements (excluding the last element)
                else 
                {
                    // Prints the case for all other instances
                    System.out.print("\t |");
                }
            }


            // Assign the SLList searchList with the SLList pum
            searchList = pum;

            // For loop going through the elements of the SLList pum
            for (int k = 0; k < len; k++) 
            {
                // Conditional if statement to check if we are iterating the last element
                if (k == len-1) 
                {
                    // Prints the case for the last element in the linked list
                    // Last element will be the first in the new SLList
                    System.out.println("\t " + searchList.first());
                }
                // Else statement for all other elements (excluding the last element)
                else 
                {
                    // Prints the case for all other instances
                    // Prints first element of each SLList, then modifies searchList to contain the rest of the SLList
                    System.out.print("\t " + searchList.first());
                    searchList = searchList.rest();
                }
            }
        }
        

    }

    // Boolean function for finding if a loop exists
    public boolean loopExists(SLList pum) {
        // Initialise SLList snail and set the value to the rest of pum
        SLList snail = pum;
        // Initialise SLList cheetah and set the value to the rest of snail
        SLList cheetah = snail.rest();
        // Conditional while loop
        while (cheetah != pum.NIL && cheetah.rest() != pum.NIL)
        {
            // Conditional if statement to check if cheetah is equal to snail
            if (cheetah == snail)
            {
                // Return true statement;
                return true;
            }
            // Set snail to the rest of snail
            snail = snail.rest();
            // Set cheetah to the rest, rest of cheetah
            cheetah = cheetah.rest().rest();
        }
        // Return false statement
        return false;
    }


    // Boolean function for testing if the data is longer than 3
    public boolean large_num(SLList pum) 
    {
        // SLList for storing pum 
        SLList pum_temp = new SLList(pum.first(), pum.rest());
        // For loop to iterate temporary list 
        for (int i = 0; i < pum_temp.length(); i++)
        {
            // Conditional if statement to check length of string 
            if(pum_temp.first.toString().length() > 3)
            {
                // Return true statement
                return true;
            }
        }
        // Set the pum_temp to the rest of pum_temp
        pum_temp = pum_temp.rest();
        // Return false statement
        return false;
    }


}

