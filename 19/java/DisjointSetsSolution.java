/////////////////// SOLUTION FILE FOR DISJOINT SETS ///////////////

// Import statements
import java.io.*;
import java.util.*;

// C
public class DisjointSetsSolution
{
	// Integer array for rank (prominence) array
	int [] prominence;
	// Integer array for ancestor (parent) array
	int [] ancestor;
	// Integer variable to store n
	int n;

	// Constructor
	public DisjointSetsSolution(int n)
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
		// Create an integer to store number of sets we want to create 
		int n = 5;
		// Then instantiate an object of a disjoint set and pass the stored integer n (e.g. n = 5 means we create 5 disjoint sets: 0, 1, 2, 3, 4)
		DisjointSetsSolution ds = new DisjointSetsSolution(n);

		// We then perform a union on set 0 and 2
		ds.union(0, 2);

		// We then perform a union on set 4 and 2
		ds.union(4, 2);

		// We then perform a union on set 3 and 1
		ds.union(3, 1);

		// Conditional if statement to check if sets 4 and 0 share any common elements (ancestors) and therefore a merged set, which makes them non-disjoint
		if(ds.find(4) == ds.find(0))
		{
			// Print statement to check 'Yes'
			System.out.println("YES, 4 & 0 ARE NOT DISJOINT");
		}
		// Else conditional if 4 and 0 do not share common elements, and are therefore disjoint sets
		else
		{
			// Print statement to check 'No'
			System.out.println("N0, 4 & 0 ARE DISJOINT");
		}


		// Conditional if statement to check if sets 1 and 0 share any common elements (ancestors) and therefore a merged set, which makes them non-disjoint
		if(ds.find(1) == ds.find(0))
		{
			// Print statement to check 'Yes'
			System.out.println("YES, 1 & 0 ARE NOT DISJOINT");
		}
		else
		{
			// Print statement to check 'No'
			System.out.println("N0, 1 & 0 ARE DISJOINT");
		}

		// We then perform a union on set 1 and 0
		ds.union(1, 0);

		// Conditional if statement to check if sets 1 and 0 share any common elements (ancestors) and therefore a merged set, which makes them non-disjoint
		if(ds.find(1) == ds.find(0))
		{
			// Print statement to check 'Yes'
			System.out.println("YES, 1 & 0 ARE NOT DISJOINT");
		}
		else
		{
			// Print statement to check 'No'
			System.out.println("N0, 1 & 0 ARE DISJOINT");
		}


	}


}


