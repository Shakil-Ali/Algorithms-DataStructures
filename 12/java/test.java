public class test
{
	public static void main(String [] args)
	{
		BinarySearch a = new BinarySearch();
		int [] arr = new int[33508402];
		for (int i = 0; i < arr.length ; i++)
		{
			arr[i]=i;
		}
		a.search(arr, 0, 28496, 33508402);
	    System.out.println(a.counter.report());
    }
}
