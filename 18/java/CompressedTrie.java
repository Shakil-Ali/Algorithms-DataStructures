// Import statements
import java.util.Map;
import java.util.TreeMap;

// Compressed Trie Class
public class CompressedTrie 
{
    // Map  intialisation
    public Map<String, CompressedTrie> children;
    
    // Compressed Trie Constructor
    public CompressedTrie() 
    {
        children = new TreeMap<String, CompressedTrie>();
    }

    // Static compressTrie method
    public static CompressedTrie compressTrie(Trie t) 
    { 
        CompressedTrie c = new CompressedTrie();
        char [] set_ct = new char[27];
        c.children.put(t.str + '{', c);
        System.out.println();
        System.out.println(c.children.toString());
        return c;
    }

    // Method to query
    public boolean query(String s) 
    {
       return false;
    }

    // Method to insert
    public void insert(String s) 
    {

    }

    
}
