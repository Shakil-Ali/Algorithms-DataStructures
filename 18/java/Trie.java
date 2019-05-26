import java.util.*;
import java.io.*;


// Class trie
public class Trie 
{
	// Children array
    public Trie [] children;

    // Variable to store character
    char c;

    // Boolean variable
    public boolean isWord;

    // Variable to store string
    public String str; 

    // True constructor
    public Trie() 
    {
        // Set trie array to have 27 storage spaces
        this.children = new Trie[27];
        // Set boolean variable to false
        isWord = false;
    }

    // Method to insert
    public void insert(String s) 
    {
        // Set the string variable to store inputted string
        this.str = s;
        if(s.isEmpty())
        {
            this.isWord = true;
            this.children[26] = new Trie();
            return;
        }
        char letterAtPos = s.charAt(0);
        int position = letterAtPos - 'a';
        if(this.children[position] == null)
        {
            this.children[position] = new Trie();
            this.children[position].c = letterAtPos;
        }
        this.children[position].insert(s.substring(1));
    }

    // Method for querying
    public boolean query(String s) 
    {
        String store;
        store = s;
        if(store.isEmpty())
        {
            return this.isWord;
        }
		int position = store.charAt(0) - 'a';
        if(this.children[position] == null)
        {
            return false;
        }
        return this.children[position].query(s.substring(1));
    }

    // Method to get string
    public String getString()
    {
        return str;
    }

   


}
