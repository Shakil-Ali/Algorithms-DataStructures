import java.lang.Math;

public class BinarySearch 
{
	int count = 0;

	public OpCounter counter = new OpCounter();

    public boolean search(int array [], int key, int lo, int hi) 
    {
    	int mid = lo + (hi - lo - 1)/2;
    	if (lo == hi)
    	{
    		return false;
    	}
    	else if (array[mid] == key)
    	{
    		count++;
    		counter.add(1);
    		return true;
    	}
    	else if (key < array[mid])
    	{
    		count++;
    		counter.add(1);
    		return search(array, key, lo, mid);
    	}
    	else
    	{
    		count++;
    		counter.add(1);
    		return search(array, key, (mid+1), hi);
    	}

    }

    public int count(int array [], int key, int lo, int hi)
    {
    	count = 0;
    	search(array, key, lo, hi);
    	return count;
    }

    public static void main(String [] args)
	{
		BinarySearch a = new BinarySearch();
		int [] arr = new int[33508402];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = i;
		}
        int [] arr2 = {};
		a.search(arr2,9,0, arr2.length);
	    System.out.println(a.counter.report());
    }


}
