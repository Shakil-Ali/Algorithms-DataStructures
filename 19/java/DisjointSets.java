/* Code has been adapted from https://www.youtube.com/watch?v=ID00PMy0-vE and https://www.geeksforgeeks.org/disjoint-set-data-structures-java-implementation/ */

/////////////////// SKELETON FILE FOR DISJOINT SETS ///////////////


// Import statements
import java.io.*;
import java.util.*;

// Public class DisjointSets
public class DisjointSets
{
	// Global variables
	int [] prominence;
	int [] ancestor;
	int n;

	// Constructor
	public DisjointSets(int n)
	{

	}

	// Creates n sets with single item in each
	public void makeSet()
	{

	}

	// Method to find and get elements of x's set
	public int find(int x)
	{
		return -1;
	}

	// Method to join set x and set which includes its elements
	public void union(int x, int y)
	{

	}

	// Main Method
	public static void main(String [] args)
	{
		// Test with main function from test file (DisjointSetsSolution.java)
	}

}
































/*

///////////////// ANSWERS FOR DISJOINT SETS /////////////////////////////

// Import statements required
import java.io.*;
import java.util.*;

// Public class DisjointSets
public class DisjointSets
{
	// Integer array for rank (prominence) array
	int [] prominence;
	// Integer array for ancestor (parent) array
	int [] ancestor;
	// Integer variable to store n
	int n;

	// Constructor
	public DisjointSets(int n)
	{
		// Set prominence array to n empty storage spaces
		prominence = new int[n];
		// Set ancest array to n empty storage spaces
		ancestor = new int[n];
		// Set n variable to n
		this.n = n;
		// Call make set function
		makeSet();
	}

	// Creates n sets with single item in each
	public void makeSet()
	{
		// For loop to iterate n times
		for(int i = 0; i < n; i++)
		{
			// Set index i of ancestor array to index i
			ancestor[i] = i;
		}
	}

	// Method to find and get elements of x's set
	public int find(int x)
	{
		// Conditional if to check if index x of ancestor array is not equal to x
		if(ancestor[x] != x)
		{
			// Set index x of ancestor array to find operation, which passes ancestor index x 
			ancestor[x] = find(ancestor[x]);
		}
		// Return the xth index of ancestor array
		return ancestor[x];
	}

	// Method to join set x and set which includes its elements
	public void union(int x, int y)
	{
		// Create integer variable to store the find method on x
		int xRoot = find(x);
		// Create integer variable to store the find method on y
		int yRoot = find(y);
		// Conditional if to check if both parents share a common ancestor
		if(xRoot == yRoot)
		{
			// If they do then exit the conditional
			return;
		}
		// Conditional to check if the rank of input x is less than input y
		if(prominence[xRoot] < prominence[yRoot])
		{
			// Set the parent of input x to the input y
			ancestor[xRoot] = yRoot;
		}
		// Conditional which is vise versa of above conditional
		else if(prominence[yRoot] < prominence[xRoot])
		{
			// Set the parent of input y to the input x
			ancestor[yRoot] = xRoot;
		}
		// Conditional else statement 
		else
		{
			// Set the ancestor of input y to input x ancestor
			ancestor[yRoot] = xRoot;
			// Set rank of input x to rank of itself plus 1
			prominence[xRoot] = prominence[xRoot] + 1;
		}
	}

	// Main Method
	public static void main(String [] args)
	{
		int n = 5;
		DisjointSets ds = new DisjointSets(n);

		ds.union(0, 2);

		ds.union(4, 2);

		ds.union(3, 1);

		if(ds.find(4) == ds.find(0))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}

		if(ds.find(1) == ds.find(0))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
}


*/










