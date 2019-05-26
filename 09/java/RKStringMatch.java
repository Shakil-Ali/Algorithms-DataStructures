public class RKStringMatch extends StringMatch {
    public int match(String text, String pattern) {
    	int m = pattern.length();
    	int hm = hash(pattern);
    	boolean found;
       
        if((text.length() == 0) && (pattern.length() == 0))
        {
            return 0;
        }
        if(pattern.length() > text.length())
        {
            return -1;
        }
        if(text.length() == 0)
        {
         
            return -1;
        }
        
        int fhash = hash(text.substring(0, m));
    	for(int s = 0; s <= text.length()-m; s++)
    	{
            if(s != 0)
            {
                fhash = rollingHash(fhash, (int) text.charAt(s-1), (int) text.charAt(s+m-1));
            }
            //if(hash(text.substring(s, s+m)) == hm)
            if(fhash == hm)
            {
    			found = true;
    			for(int j = 0; j < m; j++)
    			{
                    counter.add(2);
    				if(text.charAt(s+j) != pattern.charAt(j))
    				{
    					found = false;
    					break;
    				}
    			}
    			if(found == true)
    			{
    				return s;
    			}
    		}
    	}
        return -1;
    }

    public int hash(String input) {
         int totaller = 0;
         for(int i = 0; i < input.length(); i++)
         {
             totaller = totaller + (int) input.charAt(i);
             counter.add(1);
         }
         return totaller;
    }

    public int rollingHash(int prev, int subt, int add) {
        return ((prev - subt) + add);
    }

}
