import java.util.ArrayList;
import java.util.List;

class Heap 
{

    // counter
    public static int counter = 0;

    // public for JUnit testing purposes

    // Arry containing nodes for heap
    public  ArrayList<Integer> array;
    // Integer storing the heap size
    public int heap_size;

    // Heap Constructor, takes a single argument
    public Heap(int size) 
    {
        // Initialise the heap size to argument size
       this.heap_size = size;
       // Initialise size of arraylist to argument size
       this.array = new ArrayList<Integer>(size);
    }

    // Heap Constructor, takes a single argument
    public Heap(List<Integer> source) 
    {
        // Calls 'Heap' constructor with 2 arguments 
        this(source, false);
    }

    // Heap Constructor, takes two arguments
    public Heap(List<Integer> source, boolean incremental) 
    {
        if(incremental)
        {
             // Create a new array list with size 'heap_size'
            this.array = new ArrayList<Integer>();
            for(int i = 0; i < source.size(); i++)
            {
                insert(source.get(i));
            }
        }
        else
        {
            this.array = new ArrayList<Integer>(source);
            buildMaxHeap();
        }
    }

    // Method to get the parent node
    public static int parent(int index) 
    {
        // Return statement
        return (index - 1) / 2;
    }

    // Method to get the left node
    public static int left(int index) 
    {
        // Return statement
        return (2 * index) + 1;
    }

    // Method to get the right node
    public static int right(int index) 
    {
        // Return statement
        return (2 * index) + 2;
    }
    
    // Method to ensure max property
    public void maxHeapify(int i) 
    {
        // Integer to store the left of i
        int l = left(i);
        // Integer to store the right of i
        int r = right(i);
        // Integer to store current value of i
        int largest = i;
        // Conditional if to check if l less than heap size
        // && the value at index l is greater than value at index greatest (i)
        if((l < heap_size) && (array.get(l) > array.get(largest)))
        {
            // Set largest to the value of l
            largest = l;
        }
        // Conditional if to check if r less than heap size
        // && the value at index 4 is greater than value at index greatest (i)
        if((r < heap_size) && (array.get(r) > array.get(largest))) 
        {
            // Set largest to value of r
            largest = r;
        }
        // Conditional to check if the largest is not i
        if(largest != i)
        {
            // Swap the values at index i and largest, respectively
            swap(i, largest, array);
            // Max Heapify using the 'largest' value
            maxHeapify(largest);
        }
    }

    // Method to build a max heap
    public void buildMaxHeap() 
    {
        // Set heap size to the size of the array list 'array'
        heap_size = array.size();
        // An integer to store the array size divided by 2
        int calc = (array.size()) / 2;
        // for loop going from calc (above) to 0
        for(int i = calc; i >= 0; i--)
        {
            // Max Heapifying every element i
            maxHeapify(i);
        }
    }

    // Method to insert a new node
    public void insert(Integer k) 
    {
        // Set a variable to heap size
        int pos = heap_size;
        // Add the value k to the heap, pseudocode shows adding size of array
        array.add(k);
        // Increment the heap size by 1
        heap_size = heap_size + 1;
        // While statement for heap size greater than 0 and parent node less than node at i
        while((pos > 0) && (array.get(parent(pos)) < array.get(pos)))
        {
            // Swap the positions of i and the parent node
            swap(parent(pos), pos, array);
            // Set i to the value of the previous parent node
            pos = parent(pos);
        }
    }

    // Method to swap values
    public void swap(int a, int b, ArrayList<Integer> al)
    {
        int temp = al.get(a);
        al.set(a, al.get(b));
        al.set(b, temp);
        counter++;
    }

    // Method to get maximum node
    public Integer maximum() 
    {
        // Store length of array in integer
        int len = array.size();
        // Check if array is not empty
        if(len > 0)
        {
            // Store the largest node in a variable
            int largest = array.get(0);
            // Return largest
            return largest;
        }
        // Else statement
        else
        {
            // Return 0
            return -1;
        }
    }

    // Method to take the max from the heap
    public Integer extractMax() 
    {
        // Get the maximum element and stores it in a variable
        int maxi = maximum();
        // Set the next greatest element to index 0 (maximum)
        array.set(0, array.get(heap_size - 1));
        // Reduce size of heap_size by 1
        heap_size--;
        // Call max heapify
        maxHeapify(0);
        // Return the maximum value
        return maxi;   
    }

    public ArrayList<Integer> sort()
    {
        buildMaxHeap();
        while(heap_size > 0)
        {
            int i = heap_size - 1;
            array.set(i, extractMax());
        }
        return array;
    }

    public static void main(String args [])
    {
        // First one
        ArrayList<Integer> list = new ArrayList<Integer>(28496);
        Heap heap = new Heap(list, true);
        for(int i = 0; i < 28496; i++)
        {
            heap.insert(i);
            counter++;
        }
        System.out.println(counter);
        //394688
        //85466
    }

    /*
    Given an ordered collection of integers of length equal to your five-digit moodle ID, 
    where that collection contains the numbers from 0 to one less than your ID in that order, 
    how many memory writes does it take to construct a binary max-heap by inserting each element into an initially-empty heap one at a time?
    For example, for a collection of size 11342, the answer to this question is 142419.
    */

}
