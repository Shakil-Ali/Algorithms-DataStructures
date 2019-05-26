public class KMPStringMatch extends StringMatch {
    public int match(String text, String pattern) 
    {
        
        if(text.length() == 0 && pattern.length() == 0) 
        {
            return 0;
        }
        else if(text.length() == 0)
        {
            return -1;
        }
        else if(pattern.length() == 0)
        {
            return 0;
        }

        int n = text.length();
        int m = pattern.length();
        int [] pi = computePrefix(pattern);
        int q = 0;
        for (int i = 0; i < n; i++)
        {
            if(q >0)
            {
                counter.add(2);
            }
        	while((q > 0) && ((pattern.charAt(q))) != (text.charAt(i)))
        	{
        		q = pi[q-1];
        	}
            counter.add(2);
        	if((pattern.charAt(q)) == (text.charAt(i)))
        	{
        		q = q + 1;
        	}
        	if(q == m)
        	{
        		return i - m + 1;
        	}
        }
        return -1;
    }

    public int [] computePrefix(String pattern)
    {
    	int m = pattern.length();
    	int [] pi = new int [m];
    	pi[0] = 0;
    	int k = 0;
    	for(int q = 1; q < m; q++)
    	{
            if(k >0)
            {
                counter.add(2);
            }
    		while((k > 0) && ((pattern.charAt(k) != pattern.charAt(q))))
    		{
    			k = pi[k-1];
    		}
            counter.add(2);
    		if((pattern.charAt(k)) == (pattern.charAt(q)))
    		{
    			k = k + 1;
    		}
    		pi[q] = k;
    	}
    	return pi;
    }

    


}
