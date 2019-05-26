// Import statements for test file
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


// Public class DisjointSetsTest
public class DisjointSetsTest
{

	// Test for constructor
	@Test
	public void testConstructor()
	{
		// Create integer to store input value
		int output = 5;
		// Create disjoint sets object and pass output variable
		DisjointSets ds_test1 = new DisjointSets(output);
		// Error message, expected result and test
		assertEquals("n is not right after basic constructor", output, ds_test1.n);

		// Create integer array with 5 empty storage units
		int []  test_rank = new int [5];
		// Error message, expected result and test
		assertEquals("rank array is not right after basic constructor", test_rank.length, ds_test1.prominence.length);

		// Create integer array with 5 empty storage units
		int []  test_parent = new int [5];
		// Error message, expected result and test
		assertEquals("rank array is not right after basic constructor", test_parent.length, ds_test1.ancestor.length);

		// Create integer array with 5 empty storage units
		DisjointSets ds_test2 = new DisjointSets(5);
		// Create integer array and fill it in ascending numerical order
		int [] parentFilled = {0,1,2,3,4};
		// Create an integer variable and set the parentFilled array to the first element
		int num = parentFilled[0];
		// Error message, expected result and test
		assertEquals("method makeSet not called", num, ds_test2.ancestor[0]);
	}


	// Test for make set method
	@Test
	public void testMakeSetMethod()
	{
		// Create instance of DisjointSet with 11 as argument
		DisjointSets ds_test5 = new DisjointSets(11);
		// Set the integer array to 11 integers, from 0 - 10
		int [] parentFilled = {0,1,2,3,4,5,6,7,8,9,10};
		// Store the 7th index of parentFilled to an integer variable
		int num = parentFilled[7];
		// Error message, expected result and test
		assertEquals("method makeSet not correctly created", num, ds_test5.ancestor[7]);
	}


	// Test for find method
	@Test
	public void testFindMethod()
	{
		// Create an instance of DisjointSets with 3 as argument
		DisjointSets ds_test3 = new DisjointSets(3);
		// Error message, expected result and test
		assertEquals("find method does not find right value", 2, ds_test3.find(2));
	}


	// Test for union method
	@Test
	public void testUnionMethod()
	{
		// Create an integer variable to store argument
		int n = 5;
		// Create instance of DisjointSets with n as argument
		DisjointSets ds_test4 = new DisjointSets(n);

		// Perform 3 union operations
		// Sets 0 and 2 are now joined
		ds_test4.union(0, 2);
		// Sets 4 and 2 are now joined
		ds_test4.union(4, 2);
		// Sets 3 and 1 are now joined
		ds_test4.union(3, 1);

		// Integer variable to store x which will be passed to find method
		int x = 4;
		// Integer variable to store x which will be passed to find method
		int y = 0;
		// Create integer store and set it to the object which has find operation with x passed to it
		int testRoot1 = ds_test4.find(x);
		// Create integer store and set it to the object which has find operation with y passed to it
		int testRoot2 = ds_test4.find(y);
		// Boolean variable set to false
		boolean checker1 = false;
		// Conditional if statement to check if testRoot1 is equal to testRoot2
		if(testRoot1 == testRoot2)
		{
			// Set boolean variable to true
			checker1 = true;
		}
		// Error message, expected result and test
		assertEquals("equal roots are not being equated", true, checker1);

		// Integer variable to store a which will be passed to find method
		int a = 1;
		// Integer variable to store b which will be passed to find method
		int b = 0;
		// Create integer store and set it to the object which has find operation with a passed to it
		int testRoot3 = ds_test4.find(a);
		// Create integer store and set it to the object which has find operation with b passed to it
		int testRoot4 = ds_test4.find(b);
		// Boolean variable set to false
		boolean checker2 = false;
		// Conditional if statement to check if testRoot3 is equal to testRoot4
		if(testRoot3 == testRoot4)
		{
			// Boolean variable set to false
			checker2 = true;
		}
		// Error message, expected result and test
		assertEquals("equal roots are not being equated", false, checker2);
	}


}