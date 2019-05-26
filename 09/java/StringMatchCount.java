class StringMatchCount {
    public static void main(String args[]) {
	//String P = "ab";
	String P = "";
	//String T = "aaaaaaaaaa";
	String T = "";
	int m = 3350;
	int n = 28496;

	// all except rk
	for(int i = 0; i < m; i++)
	{
		if(i == m - 1)
		{
			P += "b";
		}
		else
		{
			P += "a";
		}
		for(int k = 0; k < n; k++)
		{
			T += "a";
		}
	}

	/*
	for(int i = 0; i < n; i++)
	{
			P = P + "b";
			P = P + "a";
	}
	*/


	StringMatch matcher = new NaiveStringMatch();

	matcher.match(T, P);
	System.out.println("char reads: " + matcher.counter.report());
    }

}
